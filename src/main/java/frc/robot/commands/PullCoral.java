package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.NeoSubsystem;

public class PullCoral extends Command{
    
  private final NeoSubsystem pullcoral;

    public PullCoral(NeoSubsystem neoSubsystem){
        pullcoral = neoSubsystem;
        addRequirements(neoSubsystem);

    }
    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    pullcoral.pull();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    pullcoral.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
