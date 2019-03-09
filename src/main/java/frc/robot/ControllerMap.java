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
        if(Robot.stick.getRawButtonReleased(BUTTON_START_VISION)){
            //Robot.enableVisionEntry.setBoolean(true);
        }
        if(Robot.stick.getRawButton(BUTTON_STOPALL)){
            //Robot.enableVisionEntry.setBoolean(false);
            //TODO add any other code needed for stopping all process on the robot
        }
        //if(Robot.stick.getRawButton(BUTTON_ELEVATOR_EXTEND)){
            //Elevator.extend();
        //}
        if(Robot.stick.getRawButton(BUTTON_ELEVATOR_UP_TEST)){
            //Elevator.upTest();
        }
        
        if(Robot.stick.getMagnitude() > 0.1 || (Robot.stick.getRawAxis(AXIS_STRAFE) > 0.1 || Robot.stick.getRawAxis(AXIS_STRAFE) < -0.1)){
            System.out.println(-Robot.stick.getY() + ", " + Robot.stick.getRawAxis(AXIS_STRAFE) + ", " + Robot.stick.getX());
            Drive.robotDrive.driveCartesian(Robot.stick.getRawAxis(4), Robot.stick.getY(), Robot.stick.getX());
        }
        else{
            Drive.robotDrive.driveCartesian(0, 0, 0);
        }
    }

    

}