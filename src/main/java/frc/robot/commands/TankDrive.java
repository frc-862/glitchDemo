// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
    Drivetrain drivetrain;
    private final DoubleSupplier left;
    private final DoubleSupplier right;

    /** Creates a new TankDrive. */
    public TankDrive(Drivetrain drivetrain, DoubleSupplier left, DoubleSupplier right) {
        addRequirements(drivetrain);
        this.drivetrain = drivetrain;
        this.left = left;
        this.right = right;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        drivetrain.setPower(left.getAsDouble(), right.getAsDouble());
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        drivetrain.setPower(left.getAsDouble(), right.getAsDouble());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        drivetrain.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
