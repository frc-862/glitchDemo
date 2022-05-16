package frc.robot.constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.lightningrobotics.common.controller.FeedForwardController;
import com.lightningrobotics.common.controller.PIDFController;
import com.lightningrobotics.common.subsystem.drivetrain.differential.DifferentialGains;

public final class Constants {
    //Drivetrain
    public static final NeutralMode DRIVE_NEUTRAL = NeutralMode.Coast;

    //Drivetrain Gains
    public static final double MAX_SPEED = 0d;
    public static final double MAX_ACCEL = 0d;
    public static final double TRACK_WIDTH = 0d;

    //Drivetrainf pid values
    public static final double DRIVE_KP = 0d;
    public static final double DRIVE_KI = 0d;
    public static final double DRIVE_KD = 0d;
    public static final double DRIVE_KF = 0d;

    //drivetrain ff values
    public static final double DRIVE_KS = 0d;
    public static final double DRIVE_KV = 0d;

    public static final DifferentialGains GAINS = new DifferentialGains(
        MAX_SPEED, MAX_ACCEL, TRACK_WIDTH,
        new boolean[]{false, true, false},
        new boolean[]{true, false, true},
        new PIDFController(DRIVE_KP, DRIVE_KI, DRIVE_KD, DRIVE_KF),
        new FeedForwardController(DRIVE_KS, DRIVE_KV)
    );

    //Elevator
    public static final NeutralMode ELEVATOR_NEUTRAL = NeutralMode.Brake;
    public static final boolean ELEVATOR_INVERT = false;

    //Fourbar
    public static final NeutralMode FOURBAR_NEUTRAL = NeutralMode.Brake;
    public static final boolean FOURBAR_INVERT = false;

    //Grippers
    public static final NeutralMode GRIPPER_LEFT_NEUTRAL = NeutralMode.Brake;
    public static final NeutralMode GRIPPER_RIGHT_NEUTRAL = NeutralMode.Brake;
    public static final boolean GRIPPER_LEFT_INVERT = false;
    public static final boolean GRIPPER_RIGHT_INVERT = true;

    //LEDs
    public static final int LED_LENGTH = 123; //TODO: get actual length
    public static final int[] LR_ORANGE = {255, 153, 0}; //lightning robotics orange is ff9900 (255, 153, 0)

    //Joystick Filters
    public static final double CODRIVER_DEADBAND = 0.13;
}
