/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Test extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
  private CANSparkMax f_leftMotor;
  private CANSparkMax f_rightMotor;
  private CANSparkMax b_leftMotor;
  private CANSparkMax b_rightMotor;

  @Override
  public void robotInit() {
    f_leftMotor = new CANSparkMax(1, MotorType.kBrushless);
    f_rightMotor = new CANSparkMax(2, MotorType.kBrushless);
    
    b_leftMotor = new CANSparkMax(3, MotorType.kBrushless);
    b_rightMotor = new CANSparkMax(4, MotorType.kBrushless);

    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    // f_leftMotor.set(m_leftStick.getY());
    // b_leftMotor.set(m_leftStick.getY());
    // f_rightMotor.set(m_rightStick.getY());
    // b_rightMotor.set(m_rightStick.getY());

    f_leftMotor.set(0.2);
    b_leftMotor.set(0.2);
    f_rightMotor.set(0.2);
    b_rightMotor.set(0.2);
  }
}