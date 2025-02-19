package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.wpilibj.ADIS16470_IMU.IMUAxis;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Timer;


import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.WaitCommand;



public class ClimbSubsystem extends SubsystemBase{
    public Timer timer = new Timer();
    


    private Spark motor = new Spark(1);
    private Servo servo = new Servo(0);


    public ClimbSubsystem(){
    }
    
    public void lockServo() {
        //servo.setSpeed(1.0);
        servo.set(0.1);
        //System.out.println("lock");
    }
    public void unlockServo(){
        //servo.setSpeed(-1.0);
        servo.set(0.5);
        //System.out.println("unlock");
    }

    public void climbUp (){
        motor.set(.25);
    }

    public void climbDown(){
        motor.set(-.25);
    }
    public void stopClimb(){
        motor.set(0);
     
   }
   public double getPosition(){
    return servo.getPosition();
   }
}
