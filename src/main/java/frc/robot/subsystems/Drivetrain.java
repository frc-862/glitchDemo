// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

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

    /** Creates a new DriveTrain. */
    public Drivetrain() {
        left1.setInverted(false);
        left2.setInverted(true);
        left3.setInverted(false);

        right1.setInverted(true);
        right2.setInverted(false);
        right3.setInverted(true);

        left2.follow(left1);
        left3.follow(left1);

        right2.follow(right1);
        right3.follow(right1);

        left1.setNeutralMode(NeutralMode.Coast);
        left2.setNeutralMode(NeutralMode.Coast);
        left3.setNeutralMode(NeutralMode.Coast);

        right1.setNeutralMode(NeutralMode.Coast);
        right2.setNeutralMode(NeutralMode.Coast);
        right3.setNeutralMode(NeutralMode.Coast);
    }

    public void periodic() {}

    public void setPower(double left, double right) {
        left1.set(ControlMode.PercentOutput, left);
        right1.set(ControlMode.PercentOutput, right);
    }

    public void stop(){
        setPower(0, 0);
    }
}
