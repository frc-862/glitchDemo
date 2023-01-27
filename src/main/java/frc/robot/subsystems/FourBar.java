package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RobotMap;
import frc.robot.Constants;
import frc.robot.Constants.FourBarConstants;;

public class FourBar extends SubsystemBase {
    final TalonSRX fourBarMotor = new TalonSRX(RobotMap.FOUR_BAR);
    
    public FourBar() {
        fourBarMotor.configFactoryDefault();
        fourBarMotor.setNeutralMode(FourBarConstants.NEUTRAL_MODE);
        fourBarMotor.setInverted(FourBarConstants.INVERT);
        fourBarMotor.configSelectedFeedbackSensor(FourBarConstants.FEEDBACK_DEVICE, 0, Constants.CAN_TIMEOUT);
        fourBarMotor.config_kP(0, FourBarConstants.P, Constants.CAN_TIMEOUT);
        fourBarMotor.config_kI(0, FourBarConstants.I, Constants.CAN_TIMEOUT);
        fourBarMotor.config_kD(0, FourBarConstants.D, Constants.CAN_TIMEOUT);
        fourBarMotor.config_kF(0, FourBarConstants.F, Constants.CAN_TIMEOUT);
        fourBarMotor.configAllowableClosedloopError(0, FourBarConstants.ALLOWABLE_ERROR, Constants.CAN_TIMEOUT);
        fourBarMotor.configPeakOutputForward(FourBarConstants.MAX_FORWARD_POWER, Constants.CAN_TIMEOUT);
        fourBarMotor.configPeakOutputReverse(FourBarConstants.MAX_REVERSE_POWER, Constants.CAN_TIMEOUT);
    }

    public void setPower(double power) {
        fourBarMotor.set(ControlMode.PercentOutput, power);
    }

    public double getRawPosition() {
        return fourBarMotor.getSelectedSensorPosition();
    }

    public double getAngle() {
        return getRawPosition() / FourBarConstants.ENCODER_TICKS_PER_REV * 360;
    }

    public void setAngle(double angle) {
        fourBarMotor.set(ControlMode.Position, angle / 360 * FourBarConstants.ENCODER_TICKS_PER_REV);
    }

    public boolean onTarget() {
        return fourBarMotor.getClosedLoopError() < FourBarConstants.ALLOWABLE_ERROR;
    }

    public void stop() { setPower(0); }
}
