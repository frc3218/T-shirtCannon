package org.usfirst.frc.team3218.robot.subsystems;

import org.usfirst.frc.team3218.robot.Robot;
import org.usfirst.frc.team3218.robot.RobotMap;
import org.usfirst.frc.team3218.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 *
 */
public class DriveWheels extends Subsystem {
	
    SpeedController frontLeftMotor = new Jaguar(RobotMap.frontLeftChannel);
    SpeedController rearLeftMotor = new Jaguar(RobotMap.rearLeftChannel);
    SpeedController frontRightMotor = new Jaguar(RobotMap.frontRightChannel);
    SpeedController rearRightMotor = new Jaguar(RobotMap.rearRightChannel);
	MecanumDrive robotDrive = new MecanumDrive (frontLeftMotor,rearLeftMotor,frontRightMotor,rearRightMotor);
	 
	public DriveWheels(){
		//super();
		//robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		frontLeftMotor.setInverted(true);
	}
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
      }
    
    public void drive(double z, double y){
    //	robotDrive.arcadeDrive(x,z); //FULL POWER
   //.arcadeDrive(x/2,z/2); // HALF POWER
   // 	robotDrive.arcadeDrive(x/3,z/3);	//THIRD POWER
   
    	robotDrive.driveCartesian(Robot.oi.getJoystickX(),z,-y); //DIFFERENT POWER
    	
   
    }
}

