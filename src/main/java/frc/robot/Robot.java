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
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
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
    UsbCamera camera;
    @Override
    public void robotInit() {

        //camera
        camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(320, 240);
        
        //Enable this only when not using pnuematics
        Lotus.comp.setClosedLoopControl(true);
        
        //Initialize the network table for team5203
        nTableInstance.startClientTeam(5203);

        for(WPI_TalonSRX talon : new WPI_TalonSRX[]{Drive.frontLeft, Drive.rearLeft, Drive.frontRight, Drive.rearRight}){
            talon.configPeakCurrentLimit(30);
            talon.configPeakCurrentDuration(1);
            talon.configContinuousCurrentLimit(30);
            talon.enableCurrentLimit(true);
        }
  
    }
    
    /**
     * WARNING: Sendable chooser created null pointer error in competition!
     * Only use it after extensive testing
     */
    @Override
    public void autonomousInit() {
        Lotus.open();
    }

    @Override
    public void autonomousPeriodic() {
        
        ControllerMap.registerInput();
    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
      
        ControllerMap.registerInput(); 

        //For moving the elevator up and down
        /*if(Elevator.runElevator){
            Elevator.moveToTargetSwitch();
        }*/
   
    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
    }

}