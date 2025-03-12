// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.subsystems.Wrist;

// public class WristToAngle extends Command {

//   private final Wrist s_Wrist;
//   private final double targetAngle;

//   public WristToAngle(Wrist s_Wrist, double targetAngle) {
//     this.s_Wrist = s_Wrist;
//     this.targetAngle = targetAngle;
//     addRequirements(s_Wrist);
//   }

//   @Override
//   public void initialize() {
//     s_Wrist.resetEncoders();
//     s_Wrist.setSetpoint(targetAngle);
//   }

//   @Override
//   public void execute() {
//     s_Wrist.calculate();
//   }

//   @Override
//   public boolean isFinished() {
//     return s_Wrist.atSetpoint();
//   }

//   @Override
//   public void end(boolean interrupted) {
//     s_Wrist.setPower(0);
//   }
// }
