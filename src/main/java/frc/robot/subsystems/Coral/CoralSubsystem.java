// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Coral;

import edu.wpi.first.hal.FRCNetComm.tInstances;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.ADIS16470_IMU.IMUAxis;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CoralSubsystem extends SubsystemBase {

    SparkMax Motor1 = new SparkMax(3, MotorType.kBrushless);
    SparkMax Motor2 = new SparkMax(7, MotorType.kBrushless);
    Spark Motor3 = new Spark(3);

    AnalogPotentiometer pot = new AnalogPotentiometer(0);

    private SparkMaxConfig SparkMaxConfig = new SparkMaxConfig();

    private final double speed = 0.1;
    // private final double angleSpeed = 0.25;
    // private double intakeAngle = 35;
    // private double outtakeAngle = 55;


    public CoralSubsystem() {
        SparkMaxConfig.idleMode(IdleMode.kBrake);
        Motor1.configure(SparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        Motor2.configure(SparkMaxConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        SmartDashboard.putNumber("Pot: ", pot.get());

    }

    public void push() {
        Motor1.set(speed);
        Motor2.set(-speed);

    }

    public void pull() {
        Motor1.set(-speed);
        Motor2.set(speed);

    }

    public void stopMotor() {
        Motor1.set(0);
        Motor2.set(0);
        Motor3.set(0);
    }

    public void setAngleMotor(double angleSpeed) {
        Motor3.set(angleSpeed);
    }

    public double getAngle(){
        return (pot.get());
    }

    public void troughOutake(){
        Motor1.set(0.6);
        Motor2.set(0.1);
    }

    
}
