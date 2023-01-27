package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeControl extends CommandBase {
    DoubleSupplier collectPower;
    DoubleSupplier ejectPower;
    Intake grippers;

    public IntakeControl(Intake grippers, DoubleSupplier collectPower, DoubleSupplier ejectPower) {
        addRequirements(grippers);
        this.grippers = grippers;
        this.collectPower = collectPower;
        this.ejectPower = ejectPower;
    }

    @Override
    public void execute() {
        grippers.setPower(collectPower.getAsDouble() - ejectPower.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        grippers.stop();
    }
}
