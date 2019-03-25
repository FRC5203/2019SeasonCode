package frc.robot;
 
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lotus {
    
    //Solenoid for the track that moves the elevator and lotus forward and backwards
    //Solenoid for the lotus opening and closing
    //Created the compressor for all of the pnuematics
    public static Compressor comp = new Compressor();
    //The solenoid for the lotus
    public static DoubleSolenoid lotus = new DoubleSolenoid(0,1);

    //Opens the lotus
    public static void open(){
        lotus.set(DoubleSolenoid.Value.kForward);
        SmartDashboard.putBoolean("Lotus State", true);
    }
    //Closes the lotus
    public static void close(){
        lotus.set(DoubleSolenoid.Value.kReverse);
        SmartDashboard.putBoolean("Lotus State", false);
    }

}