
package org.usfirst.frc.team3218.robot;

import org.usfirst.frc.team3218.robot.subsystems.AngleMotor;
import org.usfirst.frc.team3218.robot.subsystems.Cannon;
import org.usfirst.frc.team3218.robot.subsystems.DriveWheels;
import org.usfirst.frc.team3218.robot.subsystems.Loader;
import org.usfirst.frc.team3218.robot.subsystems.MyCompressor;
import java.io.IOException;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//subsystems
	private final NetworkTable grip = NetworkTable.getTable("grip");
	public static DriveWheels drive;
	public static AngleMotor angle;
	public static Cannon cannon;
	public static Loader loader;
	public static MyCompressor compressor;
	//Operator Interface
	public static OI oi;

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
    	//subsystem initialization
    	drive = new DriveWheels();
    	angle = new AngleMotor();
    	cannon = new Cannon();
    	loader = new Loader();
    	compressor = new MyCompressor();
    	//smart dashboard subystem info
    	SmartDashboard.putData(Scheduler.getInstance());
    	SmartDashboard.putData(drive);
		SmartDashboard.putData(angle);
		SmartDashboard.putData(cannon);
		SmartDashboard.putData(loader);
		try {
			new ProcessBuilder("/home/lvuser/grip").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Operator Interface initialization
		oi = new OI();
		
        // instantiate the command used for the autonomous period
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        SmartDashboard.putBoolean("Pressure Switch", compressor.getPressureSwitch());
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
