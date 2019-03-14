package frc.robot;

public class ControllerMap{

    //Should be the left bumper
    private static int BUTTON_LOTUS_OPEN = 5;
    //Should be the right bumper
    private static int BUTTON_LOTUS_CLOSE = 6;
    //Should be the B button
    private static int BUTTON_START_VISION = 2;
    //Should be the start button
    private static int BUTTON_STOPALL = 8;
    //Should be the menu button
    private static int BUTTON_ELEVATOR_EXTEND = 7;
    //TEMPORARY
    private static int BUTTON_ELEVATOR_UP_TEST = 3;
    //Should be the horizontal axis on the right joystick
    private static int AXIS_STRAFE = 4;
    //Should be the horizontal axis on the left joystick
    private static int AXIS_SPIN = 2;
    //Should be the vertical axis on the left joystick
    private static int AXIS_Y_DRIVE = 1;

    public static void registerInput(){
       if(Robot.stick.getRawButton(BUTTON_LOTUS_OPEN)){
            Lotus.open();
        }
        else if(Robot.stick.getRawButton(BUTTON_LOTUS_CLOSE)){
            Lotus.close();
        }
        

        
            //Camera middle x is 80, y is 60, for 120p
            //While loop that runs while the center of the hatch isn't the center of the camera
        if(Robot.stick.getRawButton(BUTTON_START_VISION)){
            if(Robot.xEntry.getDouble(0) < 78 || Robot.xEntry.getDouble(0) > 82){
                //How far the center of the hatch is from the center of the camera
                double currentDistance = Robot.xEntry.getDouble(0) - 80;
                //A double to set the amount of pixels before the robot starts to slow
                double threshold = 20;
                //A function that makes it so once a threshold is met the robot slows by 50%, this happens 4 times
                //Values are very much subject to change
                //Strafes the robot while the center of the hatch is to the left of the camera
                if(Robot.xEntry.getDouble(0) < 80){
                    Drive.robotDrive.driveCartesian(0.55,0,0 );
                }
                //Strafes the robot while the center of the hatch is to the right of the camera
                else if(Robot.xEntry.getDouble(0) > 85){
                    Drive.robotDrive.driveCartesian(-0.55,0,0 );
                }
            }
        }
        
        //if statement to drive the robot
        if(Robot.stick.getMagnitude() > 0.1 || (Robot.stick.getRawAxis(AXIS_STRAFE) > 0.1 || Robot.stick.getRawAxis(AXIS_STRAFE) < -0.1)){
            System.out.println(-Robot.stick.getY() + ", " + Robot.stick.getRawAxis(AXIS_STRAFE) + ", " + Robot.stick.getX());
            Drive.robotDrive.driveCartesian(Robot.stick.getRawAxis(4), -Robot.stick.getY(), Robot.stick.getX());
        }
        else{
            Drive.robotDrive.driveCartesian(0, 0, 0);
        }
        //Slow drive forward for hatch placement
        if(Robot.stick.getRawAxis(2) >= 0.1 || Robot.stick.getRawAxis(2) <= -0.1){
            Drive.robotDrive.driveCartesian(0,0.2, 0);
        }
        //Extends the elevator(WIP)
        if(Robot.stick.getRawButton(1)){
            Elevator.extend();
        }
        //Detracts the elevator(WIP)
        else if(Robot.stick.getRawButton(3)){
            Elevator.detract();
        }

    }

}