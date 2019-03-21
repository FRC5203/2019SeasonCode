package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Elevator{
    
    //Creating the solenoids that are plumbed to the pistons that control the tracks of the elevator
    public static DoubleSolenoid track = new DoubleSolenoid(0,1);
    //Creating the talons for the elevator motors
    public static WPI_VictorSPX elev1 = new WPI_VictorSPX(6);

    public static DigitalInput switch1 = new DigitalInput(1);
    public static DigitalInput switch2 = new DigitalInput(2);
    public static DigitalInput switch3 = new DigitalInput(3);

    public static boolean runElevator;
    public static DigitalInput targetSwitch;
    public static int position;

    //Puts the elevator motor into brake mode, so that it doesn't move when no input is given
    static{
        elev1.setNeutralMode(NeutralMode.Brake);
    }

    //Function to move the elevator forward on its track
    public static void extend(){
        track.set(DoubleSolenoid.Value.kForward);
    }
    //Function to move the robot backwards on its track
    public static void detract(){
        track.set(DoubleSolenoid.Value.kReverse);
    }

    public static void moveToTargetSwitch(){
        int targetPosition = switchToPosition(targetSwitch);
        
        //we need to determine if the limit switch returns true or false by default
        if(targetSwitch.get()){
            if(targetPosition - position >= 1){
                //motor up
            }
            else if(targetPosition - position <= -1){
                //motor down
            }
            else{
                //motor set 0
            }
        }
        else{
            runElevator = false;
            position = targetPosition;
        }
    }

    public static int switchToPosition(DigitalInput d){
        if(d == switch1){
            return 1;
        }
        else if(d == switch2){
            return 2;
        }
        else if(d == switch3){
            return 3;
        }
        else{
            return 0;
        }
    }

    //Function to test the elevator's upward movement
    /*public static void upTest(){
        if(Robot.stick.getRawAxis(5) > 0.1 || Robot.stick.getRawAxis(5) < -0.1){
            elev1.set(Robot.stick.getRawAxis(5)*0.2);
        }
        else{
            elev1.set(0);
        }
       
    }
    */

}