package org.usfirst.frc.team3218.robot.subsystems;

import org.usfirst.frc.team3218.robot.commands.CompressorCommand;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MyCompressor extends Subsystem {
    public boolean full =true;
   Compressor compressor = new Compressor();

    public void initDefaultCommand() {
       setDefaultCommand(new CompressorCommand());
    }
    public void compression(){
    	//compressor.setClosedLoopControl(true/*compressor.getPressureSwitchValue()*/);
    }
    public boolean getPressureSwitch(){
    	return compressor.getPressureSwitchValue();
  
    }
}

