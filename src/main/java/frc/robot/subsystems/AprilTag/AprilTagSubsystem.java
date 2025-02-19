package frc.robot.subsystems.AprilTag;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.*;

public class AprilTagSubsystem extends SubsystemBase {
    //double cameraHeight = Units.inchesToMeters(57.75);
    double testHeight = Units.inchesToMeters(3.375);
    double testcamHeight = Units.inchesToMeters(6.75);
    double cameraPitchRadians = Units.degreesToRadians(-5); // Angle between horizontal and the camera.

    PhotonCamera camera = new PhotonCamera("Arducam_OV9281_USB_Camera"); // Change to camera name
    
    
    public AprilTagSubsystem() {
         
    }


    public AprilTagAlign targetValues(){
        // Vision-alignment mode
        // Query the latest result from PhotonVision
        List <PhotonPipelineResult> results = camera.getAllUnreadResults();

        
        double yaw = Double.MAX_VALUE;
        double pitch = Double.MAX_VALUE;
        double id = Double.MAX_VALUE;
        double distance = Double.MAX_VALUE;
        
        if (!results.isEmpty()) {
            // Camera processed a new frame since last
            // Get the last one in the list.
            var result = results.get(results.size() - 1);
            if(result.hasTargets()){
                PhotonTrackedTarget target = result.getBestTarget();
                Transform3d bestCameraToTarget = target.getBestCameraToTarget();
                System.out.println("X:" + Units.metersToInches(bestCameraToTarget.getX()));
                yaw = target.getYaw();
                pitch = target.getPitch();
                id = target.getFiducialId();
                distance = bestCameraToTarget.getX();
                SmartDashboard.putNumber("Distance", distance);
                SmartDashboard.putNumber("Yaw", yaw);
                
            }
            
            
            


        }
        return new AprilTagAlign(yaw,pitch,distance,id);
    }
}