// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FourBar;

public class FourBarControl extends CommandBase {
    private final DoubleSupplier power;
    FourBar fourBar;
    /** Creates a new ElevatorControl. */
    public FourBarControl(FourBar fourBar, DoubleSupplier power) {
        addRequirements(fourBar);
        this.fourBar = fourBar;
        this.power = power;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        fourBar.setPower(power.getAsDouble());
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        fourBar.setPower(power.getAsDouble());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        fourBar.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
