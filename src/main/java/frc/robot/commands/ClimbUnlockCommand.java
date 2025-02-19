package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbUnlockCommand extends Command {
    private ClimbSubsystem climbsubsystem;

    public ClimbUnlockCommand(ClimbSubsystem climbSubsystem){
        this.climbsubsystem = climbSubsystem;
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climbsubsystem.unlockServo();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }

}
