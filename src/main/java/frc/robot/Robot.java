/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.networktables.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {



    //The controller (not just a single joystick)
    public static Joystick stick = new Joystick(0);

    //The chooser object that is used to put all possible autonomous modes into
    SendableChooser<String> sendableChooser = new SendableChooser<>();

    //The variable that will be assigned to an actual autonomous mode instance class in autonomous init
    AutonomousMode autonomousMode;

    //The network table instance that will hold all network tables 
    public static NetworkTableInstance nTableInstance = NetworkTableInstance.getDefault();
    //The network table holding all vision data
    public static NetworkTable nTable = nTableInstance.getTable("visiontable");
    //The entry in the network table holding the x value
    public static NetworkTableEntry xEntry = nTable.getEntry("X");
    //The entry holding the y value
    public static NetworkTableEntry yEntry = nTable.getEntry("Y");
  
    /**
    * This function is run when the robot is first started up and should be used
    * for any initialization code.
    */
    @Override
    public void robotInit() {
        //Lotus.comp.setClosedLoopControl(true);

        //Initialize the network table for team5203
        nTableInstance.startClientTeam(5203);
        
        sendableChooser.addOption("Cross the Line", "Line Cross");
        sendableChooser.addOption("Rocketship", "Rocket");
        sendableChooser.addOption("Cargo Ship", "Cargo");

        for(WPI_TalonSRX talon : new WPI_TalonSRX[]{Drive.frontLeft, Drive.rearLeft, Drive.frontRight, Drive.rearRight}){
            talon.configPeakCurrentLimit(25);
            talon.configPeakCurrentDuration(1);
            talon.configContinuousCurrentLimit(25);
            talon.enableCurrentLimit(true);
        }
  
    }

    @Override
    public void autonomousInit() {
        switch(sendableChooser.getSelected()){
            case "Line Cross" : autonomousMode = new LineCrossAutonomous();
            case "Rocketship" : autonomousMode = new RocketAutonomous();
            case "Cargo Ship" : autonomousMode = new CargoAutonomous();
            case "" : autonomousMode = new LineCrossAutonomous();
        }
    }

    @Override
    public void autonomousPeriodic() {
        
        //Boolean to determine if the one-time execution function in the autonomous mode was called
        boolean singleExecuteWasCalled = false;

        //If the the autonomous mode doesn't use looping and the execute() method is yet to be called, then call execute()
        if(!autonomousMode.useLoopExecute && singleExecuteWasCalled){
            autonomousMode.execute();
            singleExecuteWasCalled = true;
        }
        else{
            autonomousMode.loopExecute();
        }
    }

    @Override
    public void teleopInit() {
    }

    @Override
    public void teleopPeriodic() {
      
        ControllerMap.registerInput();
        
    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
    }

}