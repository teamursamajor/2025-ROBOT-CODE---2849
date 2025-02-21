package frc.robot.commands.AprilTag;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AprilTag.AprilTagAlign;
import frc.robot.subsystems.AprilTag.AprilTagSubsystem;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AprilTagTestCommand2 extends Command {
    
    AprilTagSubsystem aprilTag = new AprilTagSubsystem();

    private double yDesiredDistance;
    private double xDesiredDistance;
    private double yawDesiredDistance;

    private double yDesDistMargin = 1;
    private double xDesDistMargin = 1;
    private double yawDesDistMargin = 1;

    private boolean yIsInMargin = false;
    private boolean xIsInMargin = false;
    private boolean yawIsInMargin = false;


    @Override
    public void execute() {
        AprilTagAlign target = aprilTag.targetValues();
        if(target.getId() != Double.MAX_VALUE){



        }

    }
}
