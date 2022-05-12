package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    final TalonSRX left1 = new TalonSRX(1);
    final VictorSPX left2 = new VictorSPX(2);
    final VictorSPX left3 = new VictorSPX(3);

    final TalonSRX right1 = new TalonSRX(4);
    final VictorSPX right2 = new VictorSPX(5);
    final VictorSPX right3 = new VictorSPX(6);

    public Drivetrain() {
        left1.configFactoryDefault();
        left2.configFactoryDefault();
        left3.configFactoryDefault();

        right1.configFactoryDefault();
        right2.configFactoryDefault();
        right3.configFactoryDefault();

        left1.setInverted(true);
        left2.setInverted(false);
        left3.setInverted(true);

        right1.setInverted(false);
        right2.setInverted(true);
        right3.setInverted(false);

        left2.follow(left1);
        left3.follow(left1);

        right2.follow(right1);
        right3.follow(right1);

        //coast mode to ease tipping when we stop
        left1.setNeutralMode(NeutralMode.Coast);
        left2.setNeutralMode(NeutralMode.Coast);
        left3.setNeutralMode(NeutralMode.Coast);

        right1.setNeutralMode(NeutralMode.Coast);
        right2.setNeutralMode(NeutralMode.Coast);
        right3.setNeutralMode(NeutralMode.Coast);
    }

    public void setPower(double left, double right) {
        left1.set(ControlMode.PercentOutput, left);
        right1.set(ControlMode.PercentOutput, right);
    }

    public void stop(){ setPower(0, 0); }
}
