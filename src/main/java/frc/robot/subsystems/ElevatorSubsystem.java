package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.wpilibj.ADIS16470_IMU.IMUAxis;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;
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
import edu.wpi.first.wpilibj.ADIS16470_IMU.IMUAxis;
//import frc.robot.Constants.DriveConstants;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkAbsoluteEncoder;

public class ElevatorSubsystem extends SubsystemBase{
    SparkMax motor1 = new SparkMax(0,MotorType.kBrushless);
    
    
    public RelativeEncoder m_encoder1;
    
    public float motorSpeed = 0.5f;
    public float turnTolerence = 0.2f;
    public int heightLevel;
    public double desiredHeight; //inches
    public static float heightToTurnRatio = 1; //inches to rotations
    public double desiredTurns;
    public double elevatorBaseHeight; //inches, height that elevator is at lowest
    
    public ElevatorSubsystem(){
        m_encoder1 = motor1.getEncoder();
        
        
    }

    public void ElevatorSetHeight(int heightLevel){
        
        if(heightLevel < 0){
        heightLevel = 0;
        }
        if(heightLevel > 4){
        heightLevel = 4;
        }

        if(heightLevel==0){
            desiredHeight = 0; //0 inches
        }
        else if(heightLevel==1){
            desiredHeight = 18-elevatorBaseHeight; //1 foot 6 inches
        }
        else if(heightLevel==2){
            desiredHeight = 24.875f-elevatorBaseHeight; //2 foot 7/8 inches
        }
        else if(heightLevel==3){
            desiredHeight = 47.625f-elevatorBaseHeight; //3 foot 11+5/8 inches
        }
        else if(heightLevel==4){
            desiredHeight = 72-elevatorBaseHeight; //6 foot
        }
        desiredTurns = desiredHeight/heightToTurnRatio;

        
        double currentTurns;

        //desiredTurns = desiredTurns/2; //each motor moves half the total turns
        
        currentTurns = m_encoder1.getPosition();
        
        if(Math.abs(currentTurns-desiredTurns) > turnTolerence){
        motor1.set(Math.signum(currentTurns-desiredTurns) * motorSpeed);
        }



    }
}
