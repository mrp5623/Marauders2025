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

public class Wrist extends SubsystemBase {
  SparkBase left = new SparkMax(15, MotorType.kBrushless);
  SparkMaxConfig leftConfig = new SparkMaxConfig();
  RelativeEncoder leftEnc = left.getEncoder();
  SparkBase right = new SparkMax(16, MotorType.kBrushless);
  SparkMaxConfig rightConfig = new SparkMaxConfig();
  RelativeEncoder rightEnc = right.getEncoder();
  PIDController wristController;

  public Wrist() {
    leftConfig.idleMode(IdleMode.kBrake);
    rightConfig.idleMode(IdleMode.kBrake);
    rightConfig.inverted(true);
    leftConfig.inverted(false);
    left.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    right.configure(rightConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    wristController = new PIDController(.08, 0, 0);
    wristController.setTolerance(5);
  }

  public void manualRun(DoubleSupplier power) {
    left.set(power.getAsDouble());
    right.set(power.getAsDouble());
  }

  public void setPosition(double setpoint) {
    wristController.setSetpoint(setpoint);
  }

  public double getAngle() {
    return leftEnc.getPosition()/(( 15.0 / 32 * 10.0 / 72 * 18.0 / 72)*42)*360;
  }

  public void update() {
    double output = wristController.calculate(leftEnc.getPosition());
    left.set(output);
    right.set(output);  
  }

  public boolean atSetpoint() {
    return wristController.atSetpoint();
  }
}
