package frc.robot.commands.Coral;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Coral.CoralSubsystem;

public class OutakeAngle extends Command{
    private CoralSubsystem coral;
    private double outakeAngle = 35;
    private double angleMargin = 2;
    private double speed = 0.5;
    private boolean isFinished = false;

    public OutakeAngle(CoralSubsystem coral){
        this.coral = coral;
    }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(coral.getAngle() > outakeAngle + angleMargin){
      coral.setAngleMotor(-speed);
    } else if (coral.getAngle() < outakeAngle - angleMargin){
      coral.setAngleMotor(speed);
    } else {
      isFinished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    coral.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
