package org.usfirst.frc.team3218.robot.subsystems;

import javax.security.auth.kerberos.KerberosKey;

import org.usfirst.frc.team3218.robot.RobotMap;
import org.usfirst.frc.team3218.robot.commands.Loader.LoaderDoNothing;
import org.usfirst.frc.team3218.robot.commands.Loader.LoaderRetract;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Loader extends Subsystem {
    
  //  Solenoid loadingSolenoidEject = new Solenoid(RobotMap.loaderEjectChannel);
   // Solenoid loadingSolenoidRetract = new Solenoid(RobotMap.loaderRetractChannel);
    DoubleSolenoid loadingSolenoid = new DoubleSolenoid(RobotMap.loaderEjectChannel,
    												RobotMap.loaderRetractChannel );
    public void initDefaultCommand() {
        setDefaultCommand(new LoaderDoNothing());
    }
    
    public void Eject(){
   loadingSolenoid.set(DoubleSolenoid.Value.kReverse);
    	//loadingSolenoidEject.set(true);
    //	loadingSolenoidRetract.set(false);
    }
    
    public void Retract(){
   loadingSolenoid.set(DoubleSolenoid.Value.kForward);
    	//loadingSolenoidEject.set(false);
    //	loadingSolenoidRetract.set(true);
    }
    public void Nothing(){
    	loadingSolenoid.set(DoubleSolenoid.Value.kOff);
    	//loadingSolenoidEject.set(false);
    //	loadingSolenoidRetract.set(false);
    }
}

