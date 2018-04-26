package org.usfirst.frc.team3218.robot;

import org.usfirst.frc.team3218.robot.commands.*;
import org.usfirst.frc.team3218.robot.commands.Angle.AngleDown;
import org.usfirst.frc.team3218.robot.commands.Angle.AngleUp;
import org.usfirst.frc.team3218.robot.commands.Loader.LoadSequence;
import org.usfirst.frc.team3218.robot.commands.Loader.LoaderEject;
import org.usfirst.frc.team3218.robot.commands.Loader.LoaderRetract;
import org.usfirst.frc.team3218.robot.commands.cannon.Fire;
import org.usfirst.frc.team3218.robot.commands.cannon.FireSequence;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	
    private static Joystick stick = new Joystick(RobotMap.joystickChannel);

    private Button trigger = new JoystickButton(stick, RobotMap.fireButton),
    			   upButton = new JoystickButton(stick, RobotMap.upButton),
    			   downButton = new JoystickButton(stick, RobotMap.downButton),
    			   loadEjectButton = new JoystickButton(stick, RobotMap.loadEjectButton),
    			   loadRetractButton = new JoystickButton(stick, RobotMap.loadRetractButton),
    			   loadSequenceButton = new JoystickButton(stick, RobotMap.loadSequenceButton);
    			//   compressButton = new JoystickButton(stick, RobotMap.compressButton);
    
    public OI(){
    	//button actions
    	trigger.whileHeld(new FireSequence());
    	upButton.whileHeld(new AngleDown());
    	downButton.whileHeld(new AngleUp());
    	loadRetractButton.whenPressed(new LoaderRetract());
    	loadEjectButton.whenPressed(new LoaderEject());
    	loadSequenceButton.whenPressed(new LoadSequence());
    	//compressButton.whenPressed(new PowerSwitch());
    	
    	//Smart Dashboard command data
    	SmartDashboard.putData("Angle Up", new AngleUp());
    	SmartDashboard.putData("Angle Down", new AngleDown());
    	SmartDashboard.putData("FireSequence", new FireSequence());
    	SmartDashboard.putData("Fire", new Fire());
    	SmartDashboard.putData("LoaderEject", new LoaderEject());
    	SmartDashboard.putBoolean("Full Tank",Robot.compressor.full) ;
   

    }
    
    public static double getJoystickY(){
    	return stick.getY();
    }
    public static double getJoystickX(){
    	return stick.getX();
    }
    public static double getJoystickZ(){
    	return stick.getZ();
    }

}

