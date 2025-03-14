package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive.Drive;

public class DriveDistance extends Command {

  Drive drive;
  double distance;
  ChassisSpeeds speeds;
  boolean isFlipped;

  public DriveDistance(Drive s_drive, double distance) {
    drive = s_drive;
    this.distance = distance;
  }

  private static Translation2d getLinearVelocityFromJoysticks(double x, double y) {
    // Apply deadband
    double linearMagnitude = MathUtil.applyDeadband(Math.hypot(x, y), .1);
    Rotation2d linearDirection = new Rotation2d(Math.atan2(y, x));

    // Square magnitude for more precise control
    linearMagnitude = linearMagnitude * linearMagnitude;

    // Return new linear velocity
    return new Pose2d(new Translation2d(), linearDirection)
        .transformBy(new Transform2d(linearMagnitude, 0.0, new Rotation2d()))
        .getTranslation();
  }

  @Override
  public void execute() {
    // Get linear velocity
    Translation2d linearVelocity = getLinearVelocityFromJoysticks(.75, 0);

    // Apply rotation deadband
    double omega = MathUtil.applyDeadband(0, .1);

    // Square rotation value for more precise control
    omega = Math.copySign(omega * omega, omega);

    // Convert to field relative speeds & send command
    speeds =
        new ChassisSpeeds(
            linearVelocity.getX() * drive.getMaxLinearSpeedMetersPerSec(),
            linearVelocity.getY() * drive.getMaxLinearSpeedMetersPerSec(),
            omega * drive.getMaxAngularSpeedRadPerSec());
    isFlipped =
        DriverStation.getAlliance().isPresent()
            && DriverStation.getAlliance().get() == Alliance.Red;

    drive.runVelocity(
        ChassisSpeeds.fromFieldRelativeSpeeds(
            speeds,
            isFlipped ? drive.getRotation().plus(new Rotation2d(Math.PI)) : drive.getRotation()));
  }

  @Override
  public boolean isFinished() {

    return Math.abs(drive.getDrivePosistion() - distance) < 3;
  }

  @Override
  public void end(boolean interrupted) {

    drive.stop();
  }
}
