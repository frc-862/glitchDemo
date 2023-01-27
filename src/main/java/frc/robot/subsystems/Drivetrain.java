package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DrivetrainConstants;
import frc.robot.Constants.RobotMap;

public class Drivetrain extends SubsystemBase {

    final TalonSRX left1 = new TalonSRX(RobotMap.LEFT_1);
    final VictorSPX left2 = new VictorSPX(RobotMap.LEFT_2);
    final VictorSPX left3 = new VictorSPX(RobotMap.LEFT_3);

    final TalonSRX right1 = new TalonSRX(RobotMap.RIGHT_1);
    final VictorSPX right2 = new VictorSPX(RobotMap.RIGHT_2);
    final VictorSPX right3 = new VictorSPX(RobotMap.RIGHT_3);

    public Drivetrain() {
        left1.configFactoryDefault();
        left2.configFactoryDefault();
        left3.configFactoryDefault();

        right1.configFactoryDefault();
        right2.configFactoryDefault();
        right3.configFactoryDefault();

        left1.setInverted(DrivetrainConstants.LEFT_1_INVERT);
        left2.setInverted(DrivetrainConstants.LEFT_2_INVERT);
        left3.setInverted(DrivetrainConstants.LEFT_3_INVERT);

        right1.setInverted(DrivetrainConstants.RIGHT_1_INVERT);
        right2.setInverted(DrivetrainConstants.RIGHT_2_INVERT);
        right3.setInverted(DrivetrainConstants.RIGHT_3_INVERT);

        left2.follow(left1);
        left3.follow(left1);

        right2.follow(right1);
        right3.follow(right1);

        //coast mode to ease tipping when we stop
        left1.setNeutralMode(DrivetrainConstants.NEUTRAL_MODE);
        left2.setNeutralMode(DrivetrainConstants.NEUTRAL_MODE);
        left3.setNeutralMode(DrivetrainConstants.NEUTRAL_MODE);

        right1.setNeutralMode(DrivetrainConstants.NEUTRAL_MODE);
        right2.setNeutralMode(DrivetrainConstants.NEUTRAL_MODE);
        right3.setNeutralMode(DrivetrainConstants.NEUTRAL_MODE);
    }

    public void setPower(double left, double right) {
        left1.set(ControlMode.PercentOutput, left*Constants.DRIVE_POWER_CAP);
        right1.set(ControlMode.PercentOutput, right*Constants.DRIVE_POWER_CAP);
    }

    public void stop(){ setPower(0, 0); }
}
