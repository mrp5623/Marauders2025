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

// public class Claw extends SubsystemBase {
//   SparkBase left = new SparkMax(17, MotorType.kBrushless);
//   SparkMaxConfig leftConfig = new SparkMaxConfig();
//   RelativeEncoder leftEnc = left.getEncoder();
//   SparkBase right = new SparkMax(18, MotorType.kBrushless);
//   SparkMaxConfig righConfig = new SparkMaxConfig();
//   RelativeEncoder rightEnc = right.getEncoder();

//   public Claw() {
//     leftConfig.idleMode(IdleMode.kCoast);
//     leftConfig.inverted(false);
//     righConfig.idleMode(IdleMode.kCoast);
//     righConfig.inverted(true);
//     left.configure(leftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
//     right.configure(righConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
//   }

//   public void manualRun(double power) {
//     left.set(power);
//     right.set(power);
//   }
// }
