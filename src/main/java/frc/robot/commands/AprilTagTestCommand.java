package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AprilTagAlign;
import frc.robot.subsystems.AprilTagSubsystem;

public class AprilTagTestCommand extends Command {

    AprilTagSubsystem aprilTag = new AprilTagSubsystem();
    
    
    private double desiredDistance = 10;
    private double desiredDistanceMargin = 1;
    private double yawMarginError = 0.5;
    private boolean isFinished = false;
    
    public AprilTagTestCommand (AprilTagSubsystem aprilSubsystem){
        aprilTag = aprilSubsystem;
        addRequirements(aprilSubsystem);
    }


    AprilTagAlign target = aprilTag.targetValues();
    


 // Called when the command is initially scheduled.
 @Override
 public void initialize() {
    
 }

 // Called every time the scheduler runs while the command is scheduled.
 @Override
 public void execute() {
    if(target.getId() != Double.MAX_VALUE){
            if(Math.abs(target.getYaw()) > yawMarginError){
                System.out.println(Math.signum(target.getYaw()) * -1);
            }
            else{
                System.out.println(0);
            }

    }
    if(Math.abs(target.getYaw()) < yawMarginError){
        if(target.getId() != Double.MAX_VALUE){
            if(Math.abs(target.getDistance() - desiredDistance) > desiredDistanceMargin){
                System.out.println(Math.signum(target.getDistance() - desiredDistance));
            }
            else{
                System.out.println(0);
                isFinished = true;
            }
            

        }
    }

 }

 // Called once the command ends or is interrupted.
 @Override
 public void end(boolean interrupted) {
    System.out.println("completed");
 }

 // Returns true when the command should end.
 @Override
 public boolean isFinished() {
   return isFinished;
 }

}