package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;
import frc.robot.Constants;
import frc.robot.Constants.ElevatorConstants;;


public class Elevator extends SubsystemBase {
    final TalonSRX elevatorMotor = new TalonSRX(RobotMap.ELEVATOR);

    public Elevator() {
        elevatorMotor.configFactoryDefault();
        elevatorMotor.setNeutralMode(ElevatorConstants.NEUTRAL_MODE);
        elevatorMotor.setInverted(ElevatorConstants.INVERT);
        elevatorMotor.configSelectedFeedbackSensor(ElevatorConstants.FEEDBACK_DEVICE, 0, Constants.CAN_TIMEOUT);
        elevatorMotor.config_kP(0, ElevatorConstants.P, Constants.CAN_TIMEOUT);
        elevatorMotor.config_kI(0, ElevatorConstants.I, Constants.CAN_TIMEOUT);
        elevatorMotor.config_kD(0, ElevatorConstants.D, Constants.CAN_TIMEOUT);
        elevatorMotor.config_kF(0, ElevatorConstants.F, Constants.CAN_TIMEOUT);
        elevatorMotor.configAllowableClosedloopError(0, ElevatorConstants.ALLOWABLE_ERROR, Constants.CAN_TIMEOUT);
    }

    public void setPower(double power) {
        elevatorMotor.set(ControlMode.PercentOutput, power);
    }

    public double getRawPosition() {
        return elevatorMotor.getSelectedSensorPosition();
    }

    public double getHeight() {
        return getRawPosition() / ElevatorConstants.ENCODER_TICKS_PER_REV * Math.PI * ElevatorConstants.SPROCKET_DIAMETER;
    }

    public void setHeight(double height) {
        elevatorMotor.set(ControlMode.Position, height / Math.PI / ElevatorConstants.SPROCKET_DIAMETER * ElevatorConstants.ENCODER_TICKS_PER_REV);
    }

    public boolean onTarget() {
        return elevatorMotor.getClosedLoopError() < ElevatorConstants.ALLOWABLE_ERROR;
    }

    public void stop() { setPower(0); }

    @Override
    public void periodic() {
        if (getRawPosition() < 0 | elevatorMotor.isRevLimitSwitchClosed() == 1) {
            elevatorMotor.setSelectedSensorPosition(0);
        }

        if (getHeight() > ElevatorConstants.MAX_HEIGHT) {
            elevatorMotor.setSelectedSensorPosition(ElevatorConstants.MAX_HEIGHT / Math.PI / ElevatorConstants.SPROCKET_DIAMETER * ElevatorConstants.ENCODER_TICKS_PER_REV);
        }
    }
}
