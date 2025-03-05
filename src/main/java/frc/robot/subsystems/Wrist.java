// package frc.robot.subsystems;

// import com.revrobotics.RelativeEncoder;
// import com.revrobotics.spark.SparkBase;
// import com.revrobotics.spark.SparkBase.PersistMode;
// import com.revrobotics.spark.SparkBase.ResetMode;
// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.SparkMax;
// import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
// import com.revrobotics.spark.config.SparkMaxConfig;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import java.util.function.DoubleSupplier;

// public class Wrist extends SubsystemBase {
//   SparkBase left = new SparkMax(15, MotorType.kBrushless);
//   SparkMaxConfig leftConfig = new SparkMaxConfig();
//   RelativeEncoder leftEnc = left.getEncoder();
//   SparkBase right = new SparkMax(16, MotorType.kBrushless);
//   SparkMaxConfig righConfig = new SparkMaxConfig();
//   RelativeEncoder rightEnc = right.getEncoder();

//   public Wrist() {
//     leftConfig.idleMode(IdleMode.kCoast);
//     righConfig.idleMode(IdleMode.kCoast);
//     left.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
//     right.configure(righConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
//   }

//   public void manualRun(DoubleSupplier power) {
//     left.set(power.getAsDouble());
//     right.set(power.getAsDouble());
//   }
// }
