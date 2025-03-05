package frc.robot.commands.Climb;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climb.ClimbSubsystem;

public class ClimbDownCommand extends Command{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ClimbSubsystem climb_subsystem;

  
  public ClimbDownCommand(ClimbSubsystem subsystem) {
    climb_subsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    //climb_subsystem.unlockServo();
    
      //Timer.delay(0.25);
    
     
      climb_subsystem.climbDown();
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Climb ended: " + interrupted);
    climb_subsystem.stopClimb();
    climb_subsystem.lockServo();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}