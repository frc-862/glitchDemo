// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Grippers;

public class GripperControl extends CommandBase {
    DoubleSupplier collectPower;
    DoubleSupplier ejectPower;
    Grippers grippers;

    public GripperControl(Grippers grippers, DoubleSupplier collectPower, DoubleSupplier ejectPower) {
        addRequirements(grippers);
        this.grippers = grippers;
        this.collectPower = collectPower;
        this.ejectPower = ejectPower;
    }

    @Override
    public void initialize() {
        grippers.setPower(collectPower.getAsDouble() - ejectPower.getAsDouble());
    }

    @Override
    public void execute() {
        grippers.setPower(collectPower.getAsDouble() - ejectPower.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        grippers.stop();
    }

    @Override
    public boolean isFinished() { return false; }
}
