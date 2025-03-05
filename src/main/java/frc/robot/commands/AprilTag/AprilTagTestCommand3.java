package frc.robot.commands.AprilTag;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AprilTag.AprilTagAlign;
import frc.robot.subsystems.AprilTag.AprilTagSubsystem;
import frc.robot.subsystems.Drive.DriveSubsystem;

public class AprilTagTestCommand3 extends Command {

    AprilTagSubsystem aprilTag = new AprilTagSubsystem();

    DriveSubsystem m_drive;

    public AprilTagTestCommand3(DriveSubsystem m_drive, AprilTagSubsystem apriltag){
        this.aprilTag = apriltag;
        this.m_drive = m_drive;
    }

    private double yDesiredDistance = 0;
    private double xDesiredDistance = 0.5;
    private double yawDesiredAngle = 0;

    private double yDesDistMargin = 0.1;
    private double xDesDistMargin = 0.1;
    private double yawDesDistMargin = 1;

    private double motorSpeedMult = 0.5;
    private double turnSpeedMult = 0.5;

    private boolean isFinished = false;

    AprilTagAlign target = aprilTag.targetValues();

    @Override
    public void execute() {
        if (target.getId() != Double.MAX_VALUE) {
            if (inYMargin() == false) {
                alignY();
            } else if (inYMargin()) {
                alignYaw();
            } else if (inYawMargin()) {
                alignX();
            } else if (inXMargin()) {
                m_drive.drive(0, 0, 0.0, false);
                isFinished = true;
            }
        }
    }

    public void alignY() {
        double direction = Math.signum(yDesiredDistance - target.getDistanceY()) * motorSpeedMult;
        //m_drive.drive(0, direction, 0.0, false);
        System.out.println("Y:" + direction);

    }

    public void alignYaw() {

        double rot = Math.signum(target.getYaw()) * -1;
        rot *= turnSpeedMult;
        //m_drive.drive(0.0, 0.0, rot, false);
        System.out.println("Yaw:" + rot);

    }

    public void alignX() {
        double direction = Math.signum(xDesiredDistance - target.getDistanceX()) * motorSpeedMult;
        //m_drive.drive(direction, 0.0, 0.0, false);
        System.out.println("X:" + direction);

    }

    public boolean inYMargin() {
        if (Math.abs(yDesiredDistance - target.getDistanceY()) < yDesDistMargin) {
            return true;
        } else {
            return false;
        }
    }

    public boolean inYawMargin() {
        double difference = Math.abs(yawDesiredAngle - target.getYaw());
        difference = Math.min(difference, 360 - difference);
        if (difference < yawDesDistMargin) {
            return true;
        } else {
            return false;
        }
    }

    public boolean inXMargin() {
        if (Math.abs(xDesiredDistance - target.getDistanceX()) < xDesDistMargin) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

}
