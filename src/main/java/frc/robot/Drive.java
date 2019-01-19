package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class Drive {

    public static WPI_TalonSRX talon1 = new WPI_TalonSRX(1);
    public static WPI_TalonSRX talon2 = new WPI_TalonSRX(2);
    public static WPI_TalonSRX talon3 = new WPI_TalonSRX(3);
    public static WPI_TalonSRX talon4 = new WPI_TalonSRX(4);

    public static MecanumDrive robotDrive = new MecanumDrive(talon1, talon2, talon3, talon4);

    public static void controllerDrive(double ySpeed, double xSpeed, double zRotation){
        
        robotDrive.driveCartesian(ySpeed, xSpeed, zRotation);
        
    }

}