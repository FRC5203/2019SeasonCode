package frc.robot;
 
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Lotus {
    
    //Solenoid for the track that moves the elevator and lotus forward and backwards
    //Solenoid for the lotus opening and closing
    public static Compressor comp = new Compressor();
    public static DoubleSolenoid lotus = new DoubleSolenoid(2,3);

    public static void forward(){
        
    }
    public static void open(){
        lotus.set(DoubleSolenoid.Value.kForward);

    }
    public static void close(){
        lotus.set(DoubleSolenoid.Value.kReverse);
    }

}