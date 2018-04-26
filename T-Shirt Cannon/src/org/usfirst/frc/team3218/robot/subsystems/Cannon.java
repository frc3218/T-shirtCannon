package org.usfirst.frc.team3218.robot.subsystems;

import org.usfirst.frc.team3218.robot.RobotMap;
import org.usfirst.frc.team3218.robot.commands.cannon.StandBy;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Cannon extends Subsystem {
    
     Relay fireRelay= new Relay(RobotMap.fireChannel);
//	Solenoid fireSolenoid = new Solenoid(RobotMap.fireChannel);
	
    public void initDefaultCommand() {
        setDefaultCommand(new StandBy());
    }
    
    public void shoot(){
    	fireRelay.set(Relay.Value.kForward);
    	//fireSolenoid.set(true);
    }
    
    public void doNothing(){
    	fireRelay.set(Relay.Value.kReverse);
  //  fireSolenoid.set(false);
    
    }
}

