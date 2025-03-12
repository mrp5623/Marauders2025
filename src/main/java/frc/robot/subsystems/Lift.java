// package frc.robot.subsystems;

// import com.revrobotics.RelativeEncoder;
// import com.revrobotics.spark.SparkBase;
// import com.revrobotics.spark.SparkBase.PersistMode;
// import com.revrobotics.spark.SparkBase.ResetMode;
// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.SparkMax;
// import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
// import com.revrobotics.spark.config.SparkMaxConfig;
// import edu.wpi.first.math.controller.PIDController;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import java.util.function.DoubleSupplier;

// public class Lift extends SubsystemBase {

//   SparkBase lift = new SparkMax(13, MotorType.kBrushless);
//   SparkMaxConfig liftConfig = new SparkMaxConfig();
//   RelativeEncoder liftEnc = lift.getEncoder();
//   PIDController liftController;
//   double radius = .38;

//   public Lift() {

//     liftConfig.idleMode(IdleMode.kBrake);
//     liftConfig.inverted(true);
//     liftConfig.limitSwitch.reverseLimitSwitchEnabled(false);

//     lift.configure(liftConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
//     liftController = new PIDController(.5, 0, 0);
//     liftController.setTolerance(2);
//     resetEncoders();
//   }

//   @Override
//   public void periodic() {
//     SmartDashboard.putNumber("Lift Encoder", getHeight());
//   }

//   public void manualRun(DoubleSupplier power) {
//     lift.set(power.getAsDouble());
//   }

//   public void setPower(double speed) {
//     lift.set(speed);
//   }

//   public void setSetpoint(double setpoint) {
//     liftController.setSetpoint(setpoint);
//   }

//   public boolean atSetpoint() {
//     return liftController.atSetpoint();
//   }

//   public void calculate() {
//     double power = liftController.calculate(getHeight());
//     lift.set(power);
//   }

//   public double getHeight() {

//     return liftEnc.getPosition() / 42 * 2 * 2 * Math.PI * radius;
//   }

//   public void resetEncoders() {
//     liftEnc.setPosition(0);
//   }
// }
