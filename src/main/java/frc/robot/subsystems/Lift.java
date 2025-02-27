package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.DoubleSupplier;

public class Lift extends SubsystemBase {
  SparkBase left = new SparkMax(13, MotorType.kBrushless);
  SparkMaxConfig leftConfig = new SparkMaxConfig();
  RelativeEncoder leftEnc = left.getEncoder();

  public Lift() {
    leftConfig.idleMode(IdleMode.kCoast);
    left.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  public void manualRun(DoubleSupplier power) {
    left.set(power.getAsDouble());
  }
}
