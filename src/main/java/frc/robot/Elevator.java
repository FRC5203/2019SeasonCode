package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;

public class Elevator{
    
    //Creating the solenoids that are plumbed to the pistons that control the tracks of the elevator
    //public static Solenoid track1 = new Solenoid(1);
    //public static Solenoid track2 = new Solenoid(2);
    //Creating the talons for the elevator motors
    public static WPI_TalonSRX elev1 = new WPI_TalonSRX(7);

    //Function to move the elevator forward on its track
    public static void extend(){
        //track1.set(true);
        //track2.set(true);
    }

    //Function to test the elevator's upward movement
    public static void upTest(){
        if(Robot.stick.getRawAxis(5) > 0.1 || Robot.stick.getRawAxis(5) < -0.1){
            System.out.println("Moving the arch");
            elev1.set(Robot.stick.getRawAxis(5)*0.1);
        }
        else{
            elev1.set(0);
        }
       
    }

}