package frc.robot;

public abstract class AutonomousMode {
    
    //boolean to decide if the mode will loop or have a one-time execution
    public boolean useLoopExecute;
    
    public void init(){

    }

    // Execute triggers if boolean useLoopExecute is set to false.
    public void execute(){

    }

    // loopExecute is boolean useLoopExecute is set to true. This code will cycle starting after init, and continuing until end of mode.
    public void loopExecute(){

    }

}