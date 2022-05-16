package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.lightningrobotics.common.util.filter.JoystickFilter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDrive extends CommandBase {
    Drivetrain drivetrain;
    private final DoubleSupplier left;
    private final DoubleSupplier right;

    private JoystickFilter filter = new JoystickFilter(0.15, 0.1, 1, JoystickFilter.Mode.CUBED);

    public TankDrive(Drivetrain drivetrain, DoubleSupplier left, DoubleSupplier right, JoystickFilter filter) {
        this.drivetrain = drivetrain;
        this.left = left;
        this.right = right;
        addRequirements(drivetrain);
        this.filter = filter;
    }

    public TankDrive(Drivetrain drivetrain, DoubleSupplier left, DoubleSupplier right) {
        this.drivetrain = drivetrain;
        this.left = left;
        this.right = right;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        double leftPwr = filter.filter(left.getAsDouble());
        double rightPwr = filter.filter(right.getAsDouble());

        drivetrain.setPower(leftPwr, rightPwr);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        drivetrain.stop();
    }
}
