package frc.robot;

/**
 *  A one-time executed autonomous mode for crossing the autonomous line (the line right where the habitat platform ends).
 *  Note that the robot needs to drive forward 50 inches (rounded up from 48.28) for the back of the robot to cross this line.
 */
public class LineCrossAutonomous extends AutonomousMode {
    
    public LineCrossAutonomous(){
        useLoopExecute = false;
    }

    public void init(){

    }

    public void execute(){
        Drive.driveByInches(50);
    }

}