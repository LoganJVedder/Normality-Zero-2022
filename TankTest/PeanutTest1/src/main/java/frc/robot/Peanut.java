package frc.robot;

// the following import seems to allow the motors to be set to zero motion upon start up.

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Peanut extends TimedRobot {
  Servo servo = new Servo(9);
  WPI_TalonSRX TalLeft = new WPI_TalonSRX(0);
  WPI_TalonSRX TalRight = new WPI_TalonSRX(1);

  // In the actual program this will be 4 CAN SPARK MAXes instead of 2 Talons
  // DifferentialDrive myRobot = new DifferentialDrive(TalLeft, TalRight);

  // Make the back Sparks follow the forward ones with .follow

  Joystick JoyOne = new Joystick(0);
  Joystick JoyTwo = new Joystick(1);
  XboxController HandControl = new XboxController(0);

  double HS = 0.8;
  double LS = 0.4;
  double STOP = 0;

  @Override
  public void robotInit() {
    // TalLeft.setInverted(true);
    // TalRight.setInverted(true);
    // TalLeft.set(ControlMode.PercentOutput, 0);
    // TalRight.set(ControlMode.PercentOutput, 0);

  }

  @Override
  public void autonomousInit() {
    // Everything in comments is what needs to be done.
    // Drive off the platform.
    // Have the limelight line the robot up with the high target
    // All in under 15 seconds
  }

  @Override
  public void teleopPeriodic() {
        double StickLeft = JoyOne.getRawAxis(1);
        double StickRight = JoyTwo.getRawAxis(1);
        // myRobot.tankDrive(StickLeft, StickRight);

        while (HandControl.getXButtonPressed()) {
          TalLeft.set(ControlMode.PercentOutput, LS);
          TalRight.set(ControlMode.PercentOutput, LS);
          Timer.delay(.5);
          servo.setAngle(25);
        }

        while (HandControl.getBButtonPressed()) {
          TalLeft.set(ControlMode.PercentOutput, HS);
          TalRight.set(ControlMode.PercentOutput, HS);
          Timer.delay(.5);
          servo.setAngle(25);
        }

        while (HandControl.getYButtonPressed()) {
          servo.setAngle(50);
        }

        while (HandControl.getYButtonReleased() || HandControl.getBButtonReleased() || HandControl.getXButtonReleased()) {
          servo.setAngle(130);
          TalLeft.set(ControlMode.PercentOutput, STOP);
          TalRight.set(ControlMode.PercentOutput, STOP);
        }
  }
}