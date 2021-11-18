// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FourBar extends SubsystemBase {
    final TalonSRX fourBarMotor = new TalonSRX(29);
    
    public FourBar() {
        fourBarMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void periodic() {}

    public void setPower(double power) {
        fourBarMotor.set(ControlMode.PercentOutput, power);
    }

    public void stop() {
        setPower(0);
    }
}
