package org.usfirst.frc.team3218.robot.commands;

import org.usfirst.frc.team3218.robot.Robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CompressorCommand extends Command {

    public CompressorCommand() {
        requires(Robot.compressor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      	Robot.compressor.full =Robot.compressor.getPressureSwitch();
    	if(Robot.compressor.full)
    	Robot.compressor.compression();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
