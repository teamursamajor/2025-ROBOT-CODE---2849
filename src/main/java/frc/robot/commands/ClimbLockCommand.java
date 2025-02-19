package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbLockCommand extends Command {
    private ClimbSubsystem climbSubsystem;
    public ClimbLockCommand(ClimbSubsystem climbSubsystem){
        this.climbSubsystem = climbSubsystem;
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climbSubsystem.lockServo();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //climbSubsystem.unlockServo();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
