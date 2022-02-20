package frc.robot;

// the following import seems to allow the motors to be set to zero motion upon start up.

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Robot extends TimedRobot {
  Servo servo = new Servo(0);
  
  CANSparkMax Front_Left = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax Front_Right = new CANSparkMax(4, MotorType.kBrushless);
  CANSparkMax Back_Left = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax Back_Right = new CANSparkMax(3, MotorType.kBrushless);

  MotorControllerGroup Left = new MotorControllerGroup(Front_Left, Back_Left);
  MotorControllerGroup Right = new MotorControllerGroup(Front_Right, Back_Right);
  WPI_TalonSRX TalLeft = new WPI_TalonSRX(0);
  WPI_TalonSRX TalRight = new WPI_TalonSRX(1);

  DifferentialDrive myRobot = new DifferentialDrive(Front_Left, Front_Right);

  //Joystick JoyOne = new Joystick(0);
  //Joystick JoyTwo = new Joystick(1);
  XboxController HandControl = new XboxController(0);

  double HS = 0.8;
  double LS = 0.4;
  double STOP = 0;

  @Override
  public void robotInit() {
    // Put what should happen when the robot starts.
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
        double StickLeft = HandControl.getLeftY();
        double StickRight = HandControl.getRightY();
        myRobot.tankDrive(0.5, 0.5);

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
          servo.setAngle(25);
        }

        while (HandControl.getYButtonReleased() || HandControl.getBButtonReleased() || HandControl.getXButtonReleased()) {
          servo.setAngle(75);
          TalLeft.set(ControlMode.PercentOutput, STOP);
          TalRight.set(ControlMode.PercentOutput, STOP);
        }
  }
}