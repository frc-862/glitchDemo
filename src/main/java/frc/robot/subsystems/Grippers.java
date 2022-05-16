package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;
import frc.robot.constants.RobotMap;

public class Grippers extends SubsystemBase {
    final VictorSPX gripperMotorRight = new VictorSPX(RobotMap.GRIPPER_RIGHT);
    final VictorSPX gripperMotorLeft = new VictorSPX(RobotMap.GRIPPER_LEFT);

    public Grippers() {
        //Reset configs to default to avoid some weirdness
        gripperMotorLeft.configFactoryDefault();
        gripperMotorRight.configFactoryDefault();
        //set neutral modes
        gripperMotorLeft.setNeutralMode(Constants.GRIPPER_LEFT_NEUTRAL);
        gripperMotorRight.setNeutralMode(Constants.GRIPPER_RIGHT_NEUTRAL);
        //set inverts
        gripperMotorLeft.setInverted(Constants.GRIPPER_LEFT_INVERT);
        gripperMotorRight.setInverted(Constants.GRIPPER_RIGHT_INVERT);
        gripperMotorLeft.follow(gripperMotorRight);
    }

    public void setPower(double power) {
        gripperMotorRight.set(ControlMode.PercentOutput, power);
    }

    public void stop() { setPower(0); }
}
