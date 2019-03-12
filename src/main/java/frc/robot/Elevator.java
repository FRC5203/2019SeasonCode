package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;

public class Elevator{
    
    //Creating the solenoids that are plumbed to the pistons that control the tracks of the elevator
    //public static Solenoid track1 = new Solenoid(1);
    //public static Solenoid track2 = new Solenoid(2);
    //Creating the talons for the elevator motors
    public static WPI_VictorSPX elev1 = new WPI_VictorSPX(6);

    static{
        elev1.setNeutralMode(NeutralMode.Brake);
    }
    

    //Function to move the elevator forward on its track
    public static void extend(){
        //track1.set(true);
        //track2.set(true);
    }

    //Function to test the elevator's upward movement
    public static void upTest(){
        if(Robot.stick.getRawAxis(5) > 0.1 || Robot.stick.getRawAxis(5) < -0.1){
            elev1.set(Robot.stick.getRawAxis(5)*0.2);
        }
        else{
            elev1.set(0);
        }
       
    }

}