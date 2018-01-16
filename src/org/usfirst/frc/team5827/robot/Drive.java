package org.usfirst.frc.team5827.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drive {
	public WPI_TalonSRX r1;
	public WPI_TalonSRX l1;
	public boolean mode = false;
	
	
	
	
	
	//public static ControlMode modez;
	public Drive(WPI_TalonSRX a, WPI_TalonSRX b) {
		r1 = a;
		l1 = b;
		mode = true;
	}
	public void TankDrive(double l, double r) {
		if (mode) {
			r1.set(ControlMode.PercentOutput, r);
			l1.set(ControlMode.PercentOutput, -l);
			
		}
	}

}
