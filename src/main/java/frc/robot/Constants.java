// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final CommandXboxController xboxController = new CommandXboxController(0);

   // Chassis configuration

   // Distance between centers of right and left wheels on robot
   public static final double kTrackWidth = Units.inchesToMeters(26);
   
   // Distance between front and back wheels on robot
   public static final double kWheelBase = Units.inchesToMeters(33.5);
   

  //SparkMax CAN ID's
 public static final int kBackRightDrivingTalonId = 1;
  public static final int kFrontRightDrivingTalonId = 0;
  public static final int kFrontLeftDrivingTalonId = 2;
  public static final int kBackLeftDrivingTalonId = 4;

  public static final int kFrontLeftTurningId = 6;
  public static final int kFrontRightTurningId = 8;
  public static final int kBackLeftTurningId = 5;
  public static final int kBackRightTurningId = 2; 

  //Driving Constants
  public static final double kDirectionSlewRate = 1.2; // radians per second
  public static final double kMaxSpeedMetersPerSecond = 4.8;
  public static final double kMaxAngularSpeed = 2 * Math.PI; // radians per second
  public static final boolean kGyroReversed = false;
  
}