// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Grippers extends SubsystemBase {
    final VictorSPX gripperMotorRight = new VictorSPX(20);
    final VictorSPX gripperMotorLeft = new VictorSPX(21);
    /** Creates a new Elevator. */
    public Grippers() {
        gripperMotorRight.setInverted(true);
        gripperMotorLeft.follow(gripperMotorRight);
    }

    public void periodic() {}

    public void setPower(double power) {
        gripperMotorRight.set(ControlMode.PercentOutput, power);
    }

    public void stop() {
        setPower(0);
    }
}
