package org.usfirst.frc.team3218.robot.subsystems;

import org.usfirst.frc.team3218.robot.RobotMap;
import org.usfirst.frc.team3218.robot.commands.Angle.AngleDoNothing;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AngleMotor extends Subsystem {
    
    Relay acuator = new Relay(RobotMap.angleacuatorChannel);
 
    
    public void initDefaultCommand() {
        setDefaultCommand(new AngleDoNothing());
    }
    
    public void up(){
    	acuator.set(Relay.Value.kForward);
    
    }
    
    public void down(){
    	acuator.set(Relay.Value.kReverse);
    }
    
    public void doNothing(){
    	acuator.set(Relay.Value.kOff);
    }
}

