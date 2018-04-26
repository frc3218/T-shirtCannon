package org.usfirst.frc.team3218.robot.commands.cannon;

import org.usfirst.frc.team3218.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class FireSequence extends CommandGroup {
    
    public  FireSequence() {
        addSequential(new Fire());
        
      // addSequential(new LoaderEject());
    }
}
