package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FourBar extends SubsystemBase {
    final TalonSRX fourBarMotor = new TalonSRX(29);
    
    public FourBar() {
        fourBarMotor.configFactoryDefault();
        fourBarMotor.setNeutralMode(NeutralMode.Brake);
        fourBarMotor.setInverted(true);
    }

    public void setPower(double power) {
        fourBarMotor.set(ControlMode.PercentOutput, power);
    }

    public void stop() { setPower(0); }
}
