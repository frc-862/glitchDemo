package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.RobotMap;

public class Intake extends SubsystemBase {
    final VictorSPX IntakeRight = new VictorSPX(RobotMap.INTAKE_RIGHT);
    final VictorSPX IntakeLeft = new VictorSPX(RobotMap.INTAKE_LEFT);

    public Intake() {
        IntakeLeft.configFactoryDefault();
        IntakeRight.configFactoryDefault();
        IntakeRight.setInverted(true);
        IntakeLeft.follow(IntakeRight);
        IntakeLeft.configPeakOutputForward(Constants.INTAKE_POWER_CAP);
        IntakeRight.configPeakOutputForward(Constants.INTAKE_POWER_CAP);
        //Note: No power cap on reverse for faster eject

    }

    public void setPower(double power) {
        IntakeRight.set(ControlMode.PercentOutput, power);
    }

    public void stop() { setPower(0); }
}
