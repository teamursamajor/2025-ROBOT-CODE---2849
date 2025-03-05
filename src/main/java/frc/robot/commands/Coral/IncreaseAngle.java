package frc.robot.commands.Coral;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Coral.CoralSubsystem;

public class IncreaseAngle extends Command{
    private final CoralSubsystem coral;

    public IncreaseAngle(CoralSubsystem coral){
        this.coral = coral;
        addRequirements(coral);
    }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    coral.increaseAngle();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    coral.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
