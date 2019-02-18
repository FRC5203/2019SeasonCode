package frc.robot;

public class RocketAutonomous extends AutonomousMode{
    
    public RocketAutonomous(){
        useLoopExecute = false;
    }
    
    @Override
    public void execute(){
        //Camera middle x is 80, y is 60, for 120p
        while(Robot.xEntry.getDouble(0) < 75 || Robot.xEntry.getDouble(0) > 85){
            float speedModifier = 1.0f;
            double currentDistance = Robot.xEntry.getDouble(0) - 80;
            double speedThreshold = 20;
            if(Math.abs(currentDistance) <= speedThreshold && speedModifier > 0.01f){
                speedThreshold -= 5;
                speedModifier -= 0.2f;
            }
            if(Robot.xEntry.getDouble(0) < 80){
                Drive.robotDrive.driveCartesian(0.2 * speedModifier, 0, 0);
            }
            else if(Robot.xEntry.getDouble(0) > 85 && speedModifier >= 0.01f){
                Drive.robotDrive.driveCartesian(-0.2 * speedModifier, 0, 0);
            }
        }
    }

}