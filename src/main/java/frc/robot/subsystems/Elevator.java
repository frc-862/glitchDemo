package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;
import frc.robot.Constants.ElevatorConstants;;


public class Elevator extends SubsystemBase {
    final TalonSRX elevatorMotor = new TalonSRX(RobotMap.ELEVATOR);

    public Elevator() {
        elevatorMotor.configFactoryDefault();
        elevatorMotor.setNeutralMode(ElevatorConstants.NEUTRAL_MODE);
        elevatorMotor.setInverted(ElevatorConstants.INVERT);
    }

    public void setPower(double power) {
        elevatorMotor.set(ControlMode.PercentOutput, power);
    }

    public void stop() { setPower(0); }
}
