package frc.robot.commands.AprilTag;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AprilTag.AprilTagAlign;
import frc.robot.subsystems.AprilTag.AprilTagSubsystem;
import frc.robot.subsystems.Drive.DriveSubsystem;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AprilTagTestCommand extends Command {

    AprilTagSubsystem aprilTag;
    DriveSubsystem m_drive;

    private double desiredDistance;
    private double desiredDistanceMargin = 0.5;
    private double yawMarginError = 2;
    private double yDesiredDistance = 0;
    private double yDesDistMargin = 0.1;
    private double yMarginError = 0.5;
    private boolean isFinished = false;

    public AprilTagTestCommand(AprilTagSubsystem aprilSubsystem, DriveSubsystem driveSubsystem,
            double desiredDistance) {
        aprilTag = aprilSubsystem;
        m_drive = driveSubsystem;
        this.desiredDistance = desiredDistance;
        addRequirements(aprilSubsystem, driveSubsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        AprilTagAlign target = aprilTag.targetValues();

        SmartDashboard.putNumber("Distance", target.getDistanceX());
        // Align Y (horizontal)
        if (target.getId() != Double.MAX_VALUE) {
            if (Math.abs(yDesiredDistance - target.getDistanceY()) < yDesDistMargin) {
                double direction = Math.signum(yDesiredDistance - target.getDistanceY()) * 0.5;
                //m_drive.drive(0, direction, 0.0, false);
            } else {
                //m_drive.drive(0,0,0,false);
            }
        }

        //Align Yaw
        if (Math.abs(target.getYaw()) > yawMarginError) {
            System.out.println(Math.signum(target.getYaw()) * -1);
            double rot = Math.signum(target.getYaw()) * -1;
            rot *= 0.1;
            //m_drive.drive(0.0, 0.0, rot, false);
        } else {
            System.out.println("Yaw Alligned");
            //m_drive.drive(0,0,0,false);
        }

        //Align X(distance)
        if (Math.abs(target.getYaw()) < yawMarginError) {
            if (target.getId() != Double.MAX_VALUE) {
                if (Math.abs(target.getDistanceX() - desiredDistance) > desiredDistanceMargin) {
                    System.out.println(Math.signum(target.getDistanceX() - desiredDistance));
                    double direction = Math.signum(target.getDistanceX() - desiredDistance) * 0.5;
                    //m_drive.drive(direction, 0.0, 0.0, false);
                } else {
                    System.out.println("Distance Aligned");
                    //m_drive.drive(0,0,0,false);
                    isFinished = true;
                }

            }

        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        m_drive.drive(0, 0, 0, false);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}