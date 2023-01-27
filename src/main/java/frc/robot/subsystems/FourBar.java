package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;
import frc.robot.Constants.FourBarConstants;;

public class FourBar extends SubsystemBase {
    final TalonSRX fourBarMotor = new TalonSRX(RobotMap.FOUR_BAR);
    
    public FourBar() {
        fourBarMotor.configFactoryDefault();
        fourBarMotor.setNeutralMode(FourBarConstants.NEUTRAL_MODE);
        fourBarMotor.setInverted(FourBarConstants.INVERT);
    }

    public void setPower(double power) {
        fourBarMotor.set(ControlMode.PercentOutput, power);
    }

    public void stop() { setPower(0); }
}
