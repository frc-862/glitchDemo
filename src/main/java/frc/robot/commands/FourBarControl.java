package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FourBar;

public class FourBarControl extends CommandBase {
    private final DoubleSupplier power;
    FourBar fourBar;

    public FourBarControl(FourBar fourBar, DoubleSupplier power) {
        addRequirements(fourBar);
        this.fourBar = fourBar;
        this.power = power;
    }

    @Override
    public void execute() {
        fourBar.setPower(power.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        fourBar.stop();
    }
}
