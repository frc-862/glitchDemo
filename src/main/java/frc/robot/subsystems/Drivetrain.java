package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.lightningrobotics.common.controller.FeedForwardController;
import com.lightningrobotics.common.controller.PIDFController;
import com.lightningrobotics.common.subsystem.core.LightningIMU;
import com.lightningrobotics.common.subsystem.drivetrain.differential.DifferentialDrivetrain;
import com.lightningrobotics.common.subsystem.drivetrain.differential.DifferentialGains;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class Drivetrain extends DifferentialDrivetrain {

    private static final MotorController[] LEFT_MOTORS = new MotorController[]{
        new WPI_TalonSRX(1),
        new WPI_VictorSPX(2),
        new WPI_VictorSPX(3)
    };

    private static final MotorController[] RIGHT_MOTORS = new MotorController[]{
        new WPI_TalonSRX(4),
        new WPI_VictorSPX(5),
        new WPI_VictorSPX(6)
    };

    private static final DifferentialGains GAINS = new DifferentialGains(
        0, 0, 0, 
        new boolean[]{false, true, false}, 
        new boolean[]{true, false, true}, 
        new PIDFController(0, 0, 0),
        new FeedForwardController(0, 0)
    );

    public Drivetrain() {
        super(
            GAINS,
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
        setNeutralMode(NeutralMode.Coast);
    }

    public void setNeutralMode(NeutralMode neutralMode) {
        this.withEachMotor(m -> ((BaseMotorController) m).setNeutralMode(neutralMode));
    }
}
