package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ElevatorControl extends CommandBase {
    private final DoubleSupplier power;
    Elevator elevator;

    public ElevatorControl(Elevator elevator, DoubleSupplier power) {
        addRequirements(elevator);
        this.elevator = elevator;
        this.power = power;
    }

    @Override
    public void execute() {
        elevator.setPower(power.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        elevator.stop();
    }
}
