package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

public final class Constants {

    public static final double INTAKE_POWER_CAP = 0.5;
    public static final double DRIVE_POWER_CAP = 1d;

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
    }

    public final static class FourBarConstants {
        public final static NeutralMode NEUTRAL_MODE = NeutralMode.Brake;

        public final static boolean INVERT = true;
    }
}
