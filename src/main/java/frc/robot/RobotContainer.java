// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.AprilTag.AprilTagTestCommand;
import frc.robot.commands.Climb.ClimbDownCommand;
import frc.robot.commands.Climb.ClimbLockCommand;
import frc.robot.commands.Climb.ClimbUnlockCommand;
import frc.robot.commands.Climb.ClimbUpCommand;
import frc.robot.commands.Coral.DeceraseAngle;
import frc.robot.commands.Coral.IncreaseAngle;
import frc.robot.commands.Coral.PullCoral;
import frc.robot.commands.Coral.PushCoral;
//import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.AprilTag.AprilTagSubsystem;
import frc.robot.subsystems.Climb.ClimbSubsystem;
import frc.robot.subsystems.Coral.CoralSubsystem;
import frc.robot.subsystems.Drive.DriveSubsystem;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  public static final double kTrackWidth = Units.inchesToMeters(27.5);
    // Distance between centers of right and left wheels on robot
  public static final double kWheelBase = Units.inchesToMeters(28.0);
  
  public final double kMaxSpeedMetersPerSecond = 4.8;
  public final double kMaxAccelerationMetersPerSecondSquared = 3;
  public final double kPXController = 1;
  public final double kPYController = 1;
  public final double kPThetaController = 1;
  public final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
  public final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;
  public final double kDriveDeadband = 0.5;
  
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  //public DriveSubsystem m_robotDrive = new DriveSubsystem(); 
  //private AprilTagSubsystem m_aprilTag = new AprilTagSubsystem();
  private final ClimbSubsystem climbsubsys = new ClimbSubsystem();
  //private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();  
  private final CoralSubsystem coralSubsystem = new CoralSubsystem();

  
  // The driver's controller(s)
  XboxController m_driverController = new XboxController(0);


  

  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
     /* 
     // Configure default commands
     /*m_robotDrive.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
         
         new RunCommand(
            () -> m_robotDrive.drive(
                -MathUtil.applyDeadband(m_driverController.getLeftY(), kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getLeftX(), kDriveDeadband),
                -MathUtil.applyDeadband(m_driverController.getRightX(), kDriveDeadband),
                true),
            m_robotDrive));
      */
      
  }
            

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    //Constants.xboxController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
    
    // Climb
    Constants.xboxController.y().whileTrue(new ClimbUpCommand(climbsubsys));
    Constants.xboxController.a().whileTrue(new ClimbDownCommand(climbsubsys));
    Constants.xboxController.x().onTrue(new ClimbUnlockCommand(climbsubsys)).onTrue(new ClimbUpCommand(climbsubsys));
    Constants.xboxController.b().onTrue(new ClimbLockCommand(climbsubsys));

    // Elevator
    //Constants.xboxController.a().onTrue(new ElevatorUp(elevatorSubsystem));
    //Constants.xboxController.y().onTrue(new ElevatorDown(elevatorSubsystem));
    

    // Coral Commands
    // Constants.xboxController.povUp().whileTrue(new IncreaseAngle(coralSubsystem));
    // Constants.xboxController.povDown().whileTrue(new DeceraseAngle(coralSubsystem));
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);

  }
}
