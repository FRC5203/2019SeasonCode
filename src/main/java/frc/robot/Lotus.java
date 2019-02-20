package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class Lotus {
    
    //Solenoid for the track that moves the elevator and lotus forward and backwards
    public static Solenoid track = new Solenoid(0);
    //Solenoid for the lotus opening and closing
    public static Solenoid lotus = new Solenoid(1);

    public static void forward(){
        track.set(true);
    }
    public static void open(){
        lotus.set(true);
    }
    public static void close(){
        lotus.set(false);
    }

}