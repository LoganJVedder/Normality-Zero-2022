package subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class ZordBay {

    WPI_TalonSRX TalLeft = new WPI_TalonSRX(0);
    WPI_TalonSRX TalRight = new WPI_TalonSRX(1);
    DifferentialDrive myRobot = new DifferentialDrive(TalLeft, TalRight);
    Joystick JoyOne = new Joystick(0);
    Joystick JoyTwo = new Joystick(1);
    XboxController HandControl = new XboxController(2);

    //This is where the motors get set up and maybe add the drive loops
  
    public void robotInit() {
        TalLeft.setInverted(true);      
    }
    
    public void Zord() {

    }
}
