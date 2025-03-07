package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Lift;




public class LiftToHeight extends Command{
    private final Lift s_Lift;
    private final double targetHeight;

    public LiftToHeight(Lift s_Lift, double targetHeight) {
        this.s_Lift = s_Lift;
        this.targetHeight = targetHeight;
        addRequirements(s_Lift);
    }

    @Override
    public void initialize(){
        s_Lift.resetEncoders();
        s_Lift.setSetpoint(targetHeight);
    }

    @Override
    public void execute(){
        s_Lift.calculate();
    } 

    @Override
    public boolean isFinished() {
        return s_Lift.atSetpoint();
    }

    @Override
    public void end(boolean interrupted) {
        s_Lift.setPower(0);
    }
}