package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Grippers extends SubsystemBase {
    final VictorSPX gripperMotorRight = new VictorSPX(20);
    final VictorSPX gripperMotorLeft = new VictorSPX(21);

    public Grippers() {
        gripperMotorLeft.configFactoryDefault();
        gripperMotorRight.configFactoryDefault();
        gripperMotorRight.setInverted(true);
        gripperMotorLeft.follow(gripperMotorRight);
    }

    public void setPower(double power) {
        if (power > 0) {
            gripperMotorRight.set(ControlMode.PercentOutput, power*0.5);
        } else if (power < 0) {
            gripperMotorRight.set(ControlMode.PercentOutput, power);
        } else {
            gripperMotorRight.set(ControlMode.PercentOutput, 0);
        }
    }

    public void stop() { setPower(0); }
}
