package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
    Drivetrain drivetrain;
    private final DoubleSupplier left;
    private final DoubleSupplier right;

    public TankDrive(Drivetrain drivetrain, DoubleSupplier left, DoubleSupplier right) {
        addRequirements(drivetrain);
        this.drivetrain = drivetrain;
        this.left = left;
        this.right = right;
    }

    @Override
    public void initialize() {
        drivetrain.setPower(left.getAsDouble(), right.getAsDouble());
    }

    @Override
    public void execute() {
        drivetrain.setPower(left.getAsDouble(), right.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        drivetrain.stop();
    }

    @Override
    public boolean isFinished() { return false; }
}
