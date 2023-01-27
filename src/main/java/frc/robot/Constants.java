package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

public final class Constants {

    public static final double INTAKE_POWER_CAP = 0.5;
    public static final double DRIVE_POWER_CAP = 1d;
    public static final int CAN_TIMEOUT = 10; // ms

    public static final class RobotMap {
        public static final int LEFT_1 = 1;
        public static final int LEFT_2 = 2;
        public static final int LEFT_3 = 3;

        public final static int RIGHT_1 = 4;
        public final static int RIGHT_2 = 5;
        public final static int RIGHT_3 = 6;

        public final static int ELEVATOR = 28;

        public final static int FOUR_BAR = 29;

        public final static int INTAKE_LEFT = 21;
        public final static int INTAKE_RIGHT = 20;
    }

    public final static class DrivetrainConstants {
        public final static boolean LEFT_1_INVERT = true;
        public final static boolean LEFT_2_INVERT = false;
        public final static boolean LEFT_3_INVERT = true;

        public final static boolean RIGHT_1_INVERT = false;
        public final static boolean RIGHT_2_INVERT = true;
        public final static boolean RIGHT_3_INVERT = false;

        public final static NeutralMode NEUTRAL_MODE = NeutralMode.Coast;
    }

    public final static class ElevatorConstants {
        public final static NeutralMode NEUTRAL_MODE = NeutralMode.Brake;
        public final static boolean INVERT = true;

        //Uses a US Digital Quad Encoder
        public final static int ENCODER_TICKS_PER_REV = 360;
        public final static FeedbackDevice FEEDBACK_DEVICE = FeedbackDevice.QuadEncoder;
        //no gear ratio since encoder is on the output shaft

        public final static double P = 0.1; //TODO: tune
        public final static double I = 0;
        public final static double D = 0;
        public final static double F = 0;

        public final static int ALLOWABLE_ERROR = 1; //inch

        public final static double MAX_HEIGHT = 0d; //inches //TODO: find max height
        public final static double SPROCKET_DIAMETER = 0d; //inches //TODO: find sprocket diameter
    }

    public final static class FourBarConstants {
        public final static NeutralMode NEUTRAL_MODE = NeutralMode.Brake;

        public final static boolean INVERT = true;

        //Uses a US Digital MA3 Encoder
        public final static int ENCODER_TICKS_PER_REV = 4096;
        public final static FeedbackDevice FEEDBACK_DEVICE = FeedbackDevice.Analog;
        //no gear ratio since encoder is on the output shaft

        public final static double P = 0.1; //TODO: tune
        public final static double I = 0;
        public final static double D = 0;
        public final static double F = 0;

        public final static int ALLOWABLE_ERROR = 4; //degrees

        //funny numbers straight from 2018 code
        public final static double MAX_REVERSE_POWER = 0.254;
        public final static double MAX_FORWARD_POWER = 0.862;
    }
}
