package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.DoubleSupplier;

public class Lift extends SubsystemBase {
  SparkBase left = new SparkMax(13, MotorType.kBrushless);
  SparkMaxConfig leftConfig = new SparkMaxConfig();
  RelativeEncoder leftEnc = left.getEncoder();
  SparkBase right = new SparkMax(14, MotorType.kBrushless);
  SparkMaxConfig rightConfig = new SparkMaxConfig();
  RelativeEncoder rightEnc = right.getEncoder();
  PIDController liftController;
    double radius = 1;

  public Lift() {
    leftConfig.idleMode(IdleMode.kBrake);
    rightConfig.idleMode(IdleMode.kBrake);
    rightConfig.inverted(true);
    leftConfig.inverted(false);
    left.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    right.configure(rightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    liftController = new PIDController(.5, 0, 0);
    liftController.setTolerance(2);
  }

  public void manualRun(DoubleSupplier power) {
    left.set(power.getAsDouble());
    right.set(power.getAsDouble());
  }

  public void setPower(double speed){
    left.set(speed);
    right.set(speed);
  }

  public void setSetpoint(double setpoint){
    liftController.setSetpoint(setpoint);
  }

  public boolean atSetpoint(){
    return liftController.atSetpoint();
  }

  public void calculate(){
    double power =liftController.calculate(getHeight());
    left.set(power);
    right.set(power);
  }

  public double getHeight(){
    return rightEnc.getPosition()/((1/2)*42)*2*Math.PI*radius;
  }

  public void resetEncoders(){
    leftEnc.setPosition(0);
    rightEnc.setPosition(0);
  }
}
