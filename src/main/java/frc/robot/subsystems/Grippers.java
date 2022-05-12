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
        gripperMotorRight.set(ControlMode.PercentOutput, power);
    }

    public void stop() { setPower(0); }
}
