package frc.robot;
 
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

public class Lotus {
    
    //Solenoid for the track that moves the elevator and lotus forward and backwards
    public static Solenoid track = new Solenoid(0);
    public static Solenoid track2 = new Solenoid(1);
    //Solenoid for the lotus opening and closing
    public static DoubleSolenoid lotus = new DoubleSolenoid(2,3);

    public static void forward(){
        track.set(true);
        track2.set(true);
    }
    public static void open(){
        lotus.set(DoubleSolenoid.Value.kOff);
        lotus.set(DoubleSolenoid.Value.kForward);

    }
    public static void close(){
        lotus.set(DoubleSolenoid.Value.kOff);
        lotus.set(DoubleSolenoid.Value.kReverse);
    }

}