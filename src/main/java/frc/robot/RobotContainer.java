package frc.robot;

import com.lightningrobotics.common.util.filter.JoystickFilter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ElevatorControl;
import frc.robot.commands.FourBarControl;
import frc.robot.commands.GripperControl;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.FourBar;
import frc.robot.subsystems.Grippers;

public class RobotContainer {
    private static final Drivetrain drivetrain = new Drivetrain();
    private static final Elevator elevator = new Elevator();
    private static final FourBar fourBar = new FourBar();
    private static final Grippers grippers = new Grippers();

    private static final Joystick driverLeft = new Joystick(0);
    private static final Joystick driverRight = new Joystick(1);

    public final XboxController operator = new XboxController(2);

    private JoystickFilter filter = new JoystickFilter(0.13, 0.1, 1, JoystickFilter.Mode.CUBED);

    public RobotContainer() {
        configureButtonBindings();
        //Standard Tank Drive Controls
        drivetrain.setDefaultCommand(new TankDrive(drivetrain, () -> driverLeft.getY(), () -> driverRight.getY()));

        //Left Stick to move elevator
        elevator.setDefaultCommand(new ElevatorControl(elevator, () -> filter.filter(operator.getLeftY())));

        //Right Stick to move elevator
        fourBar.setDefaultCommand(new FourBarControl(fourBar, () ->  filter.filter(operator.getRightY())));

        //RT/LT to collect/eject
        grippers.setDefaultCommand(new GripperControl(grippers, () -> operator.getRightTriggerAxis(), () -> operator.getLeftTriggerAxis()));
    }

    private void configureButtonBindings() {}
    
    public Command getAutonomousCommand() { return null; }
}
