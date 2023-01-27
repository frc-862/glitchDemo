package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ElevatorControl;
import frc.robot.commands.FourBarControl;
import frc.robot.commands.IntakeControl;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FourBar;
import frc.robot.subsystems.Intake;

public class RobotContainer {
    private static final Drivetrain drivetrain = new Drivetrain();
    private static final Elevator elevator = new Elevator();
    private static final FourBar fourBar = new FourBar();
    private static final Intake intake = new Intake();

    private static final XboxController driver  = new XboxController(0);
    public static final XboxController operator = new XboxController(1);

    public RobotContainer() {
        configureButtonBindings();
        //Standard Tank Drive Controls
        drivetrain.setDefaultCommand(new TankDrive(drivetrain, () -> driver.getLeftY(), () -> driver.getRightY()));

        //Left Stick to move elevator
        elevator.setDefaultCommand(new ElevatorControl(elevator, () -> operator.getLeftY()));

        //Right Stick to move fourbar
        fourBar.setDefaultCommand(new FourBarControl(fourBar, () ->  operator.getRightY()));

        //RT/LT to collect/eject
        intake.setDefaultCommand(new IntakeControl(intake, () -> operator.getRightTriggerAxis(), () -> operator.getLeftTriggerAxis()));
    }

    private void configureButtonBindings() {}
    
    public Command getAutonomousCommand() { return null; }
}
