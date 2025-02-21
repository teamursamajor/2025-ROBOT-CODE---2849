package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class LeaveCommand extends Command{
    private DriveSubsystem m_drive;
    private boolean isFinished = false;

    public LeaveCommand(DriveSubsystem driveSubsystem){
        addRequirements(m_drive);
        m_drive = driveSubsystem;
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    // Place Holder Values
    m_drive.drive(0, 0, 60, false);
    Timer.delay(2);
    m_drive.drive(0.5, 0, 0, false);
    Timer.delay(0.5);
    m_drive.drive(0, 0, 0, false);
    isFinished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drive.drive(0, 0, 0, false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  
}

}
