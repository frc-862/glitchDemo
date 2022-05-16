package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.RobotMap;

public class FourBar extends SubsystemBase {
    final TalonSRX fourBarMotor = new TalonSRX(RobotMap.FOURBAR);
    
    public FourBar() {
        fourBarMotor.configFactoryDefault();
        fourBarMotor.setNeutralMode(Constants.FOURBAR_NEUTRAL);
        fourBarMotor.setInverted(Constants.FOURBAR_INVERT);
    }

    public void setPower(double power) {
        fourBarMotor.set(ControlMode.PercentOutput, power);
    }

    public void stop() { setPower(0); }
}
