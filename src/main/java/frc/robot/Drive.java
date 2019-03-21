package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Drive {

    //Bunch of drive talons
    public static WPI_TalonSRX frontLeft = new WPI_TalonSRX(1);
    public static WPI_TalonSRX rearLeft = new WPI_TalonSRX(2);
    public static WPI_TalonSRX frontRight = new WPI_TalonSRX(3);
    public static WPI_TalonSRX rearRight = new WPI_TalonSRX(4);

    //The navX-mxp gyro (it's the big purple board plugged into the rio)
    public static AHRS ahrs;

    //The fixed speed the robot will use when autonomously driving
    public static double fixedSpeed = 0.5;

    //The fixed speed that the robot will use for rotation when turning autonomously
    public static double fixedRotSpeed = 0.5;

    static {
        ahrs = new AHRS(SPI.Port.kMXP);
    }

    public static MecanumDrive robotDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    public static void timedDrive(double seconds){
        double startTime = System.currentTimeMillis();

        while(System.currentTimeMillis() - startTime < seconds){
            robotDrive.driveCartesian(0, fixedSpeed, 0);
        }
    }

    public static void driveByInches(double inches){
        double inchesPerSecond = 0;
        double startTime = System.currentTimeMillis();
        double elapsedTime = 0;
        
        while(elapsedTime * inchesPerSecond < inches){
            elapsedTime += System.currentTimeMillis() - startTime;
            robotDrive.driveCartesian(0, fixedSpeed, 0);
        }
    }
    
    public static void rotate(int angle){
        /* Note that roll is rotation around the x-axis and due to the position of the rio on the bot, 
        *  the x-axis is the axis that the robot will be turning around 
        */
        float lastAngle = ahrs.getRoll();
        float totalAngle = 0;
        
        if(angle > 0){
            while(!(totalAngle >= angle - 3)){
                
                totalAngle += ahrs.getRoll() - lastAngle;

                robotDrive.driveCartesian(0, 0, fixedRotSpeed); 
                
                lastAngle = ahrs.getRoll();
            }
        }
        else if (angle < 0){
            while(!(totalAngle <= angle + 3)){
                
                totalAngle += ahrs.getRoll() - lastAngle;

                robotDrive.driveCartesian(0, 0, -0.5); 
                
                lastAngle = ahrs.getRoll();
            }
        }
        else{
            return;
        }
        
       
    }

}