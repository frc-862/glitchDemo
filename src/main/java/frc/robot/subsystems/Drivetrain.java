package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.lightningrobotics.common.subsystem.core.LightningIMU;
import com.lightningrobotics.common.subsystem.drivetrain.differential.DifferentialDrivetrain;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.constants.Constants;
import frc.robot.constants.RobotMap;

public class Drivetrain extends DifferentialDrivetrain {

    private static final MotorController[] LEFT_MOTORS = new MotorController[]{
        new WPI_TalonSRX(RobotMap.LEFT_1),
        new WPI_VictorSPX(RobotMap.LEFT_2),
        new WPI_VictorSPX(RobotMap.LEFT_3)
    };
    private static final MotorController[] RIGHT_MOTORS = new MotorController[]{
        new WPI_TalonSRX(RobotMap.RIGHT_1),
        new WPI_VictorSPX(RobotMap.RIGHT_2),
        new WPI_VictorSPX(RobotMap.RIGHT_3)
    };

    public Drivetrain() {
        super(
            Constants.GAINS,
            LEFT_MOTORS, 
            RIGHT_MOTORS,
            LightningIMU.none(), 
            () -> 0,
            () -> 0,
            () -> 0,
            () -> 0
        );

        withEachMotor(m -> ((BaseMotorController) m).configFactoryDefault());

        //coast mode to ease tipping when we stop
        setNeutralMode(Constants.DRIVE_NEUTRAL);
    }

    public void setNeutralMode(NeutralMode neutralMode) {
        this.withEachMotor(m -> ((BaseMotorController) m).setNeutralMode(neutralMode));
    }
}
