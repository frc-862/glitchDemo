package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    final TalonSRX elevatorMotor = new TalonSRX(28);

    public Elevator() {
        elevatorMotor.configFactoryDefault();
        elevatorMotor.setNeutralMode(NeutralMode.Brake);
        elevatorMotor.setInverted(true);
    }

    public void setPower(double power) {
        elevatorMotor.set(ControlMode.PercentOutput, power);
    }

    public void stop() { setPower(0); }
}
