package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.RobotMap;

public class Elevator extends SubsystemBase {
    final TalonSRX elevatorMotor = new TalonSRX(RobotMap.ELEVATOR);

    public Elevator() {
        elevatorMotor.configFactoryDefault();
        elevatorMotor.setNeutralMode(Constants.ELEVATOR_NEUTRAL);
        elevatorMotor.setInverted(Constants.ELEVATOR_INVERT);
    }

    public void setPower(double power) {
        elevatorMotor.set(ControlMode.PercentOutput, power);
    }

    public void stop() { setPower(0); }
}
