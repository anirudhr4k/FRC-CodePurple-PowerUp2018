/*
 * FRC PowerUp 2018 Robot Code for Team 5827 - Anirudh Suresh(s-asuresh)
 */

package org.usfirst.frc.team5827.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogGyro;

public class Robot extends IterativeRobot {
	public boolean driverControl;
	public boolean gyroActivation;
	public AnalogGyro gyro = new AnalogGyro(0, 0, 0);
	//private DifferentialDrive m_robotDrive
	//		= new DifferentialDrive(new Spark(5), new Spark(1));
	public Drive drive = new Drive(new WPI_TalonSRX(14), new WPI_TalonSRX(15));
	
	
	private Joystick joyl = new Joystick(0);
	//private Shifter shift;
	private JoySticks cons = new JoySticks(0);
	private Timer timer = new Timer();
	
	

	@Override
	public void robotInit() {
		gyro.calibrate();
		
	}
		
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
		gyro.reset();
	}

	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (timer.get() < 4.0) {
			//m_robotDrive.arcadeDrive(0.15, 0.0); // drive forwards half speed
		} else {
			//m_robotDrive.stopMotor(); // stop robot
		}
	}


	@Override
	public void teleopInit() {
		driverControl = true;
	}

	
	@Override
	public void teleopPeriodic() {
		if (driverControl) {
			cons.UpdateID(0);
			//m_robotDrive.arcadeDrive(joyl.getY(), joyl.getX());
			drive.TankDrive(joyl.getRawAxis(1), joyl.getRawAxis(5));
			
		}
	}

	
	@Override
	public void testPeriodic() {
	}
}
