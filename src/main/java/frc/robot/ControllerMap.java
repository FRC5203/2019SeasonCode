package frc.robot;

public class ControllerMap{

    //left bumper
    private static int BUTTON_LOTUS_OPEN = 5;
    //right bumper
    private static int BUTTON_LOTUS_CLOSE = 6;
    //B button
    private static int BUTTON_DO_VISION = 2;
    //start button
    private static int BUTTON_STOPALL = 8;
    //menu button
    private static int BUTTON_ELEVATOR_EXTEND = 7;
    //TEMPORARY
    private static int BUTTON_ELEVATOR_UP_TEST = 3;
    //A button
    private static int BUTTON_ELEVATOR_OUT = 1;
    //X button
    private static int BUTTON_ELEVATOR_IN = 3;
    //horizontal axis on the right joystick
    private static int AXIS_STRAFE = 4;
    //horizontal axis on the left joystick
    private static int AXIS_SPIN = 2;
    //vertical axis on the left joystick
    private static int AXIS_Y_DRIVE = 1;

    public static void registerInput(){
        
        if(Robot.stick.getRawButton(BUTTON_LOTUS_OPEN)){
            Lotus.open();
        }
        else if(Robot.stick.getRawButton(BUTTON_LOTUS_CLOSE)){
            Lotus.close();
        }
        
        //Vision processing is currently not in use because strafing does not work

        //Camera middle x is 80, y is 60, for 120p
        //If BUTTON_DO_VISION is being pressed, line up robot with the hatch
        /*if(Robot.stick.getRawButton(BUTTON_DO_VISION)){
            if(Robot.xEntry.getDouble(80) < 78 || Robot.xEntry.getDouble(80) > 82){
                //How far the center of the hatch is from the center of the camera
                double currentDistance = Robot.xEntry.getDouble(80) - 80;

                if(currentDistance > 0){
                    Drive.robotDrive.driveCartesian(0, 1, 0);
                    
                }
                else if(currentDistance < 0){
                    Drive.robotDrive.driveCartesian(0, -1, 0);
                }
                else{
                    Drive.robotDrive.driveCartesian(0, 0, 0);
                }
            }
            else {
                Drive.robotDrive.driveCartesian(0, 0, 0);
            }
        }*/
        
        //if statement to drive the robot forward and backwards and spin if left stick is pushed
        if(Robot.stick.getMagnitude() > 0.15){
            Drive.robotDrive.driveCartesian(0, -Robot.stick.getY(), Robot.stick.getX());
        }
        //else if right stick is in use, strafe
        else if((Robot.stick.getRawAxis(AXIS_STRAFE) > 0.15 || Robot.stick.getRawAxis(AXIS_STRAFE) < -0.15)){
            Drive.robotDrive.driveCartesian(Robot.stick.getRawAxis(4) * 0.8, 0, 0);
        }
        //else, give the robot drive all zeros
        else{
            Drive.robotDrive.driveCartesian(0, 0, 0);
        }

        //Slow drive forward for hatch placement
        if(Robot.stick.getRawAxis(2) >= 0.15 || Robot.stick.getRawAxis(2) <= -0.15){
            Drive.robotDrive.driveCartesian(0,0.2, 0);
        }

        //Extends the elevator
        if(Robot.stick.getRawButton(BUTTON_ELEVATOR_OUT)){
            Elevator.extend();
        }
        //Detracts the elevator
        else if(Robot.stick.getRawButton(BUTTON_ELEVATOR_IN)){
          Elevator.detract();
        }

        //Elevator code to move to three different levels based on seperate buttons pressed
        /*
        if(Robot.stick.getRawButton(1)){
            Elevator.targetSwitch = Elevator.switch1;
            Elevator.runElevator = true;
        }
        if(Robot.stick.getRawButton(3)){
            Elevator.targetSwitch = Elevator.switch2;
            Elevator.runElevator = true;
        }
        if(Robot.stick.getRawButton(4)){
            Elevator.targetSwitch = Elevator.switch3;
            Elevator.runElevator = true;
        }
        */
    }

}