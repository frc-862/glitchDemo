//WARNING: this file is super long because I want to keep useless clutter out of subsystems
//It also pretends that glitch's elevator is angled for like gridlock
package frc.robot.commands;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import java.awt.Polygon;

public class SetLiftPositionXY extends CommandBase {
    Supplier<Translation2d> desiredPose;

    Elevator elevator;
    FourBar fourBar;

    private static final class XYConstants {
        public static final double BAR_RADIUS = 30; //Bar length in inches
        public static final Rotation2d ELEVATOR_ANGLE = new Rotation2d(Math.toRadians(55)); //Acute Elevator mount angle in degrees
        public static final Translation2d ELEVATOR_OFFSET = new Translation2d(-9, 12); //horiz/vert offset from ground (See below)
        //X = distance from arm pivot point to front of bot at bottom limit (negative)
        //Y = height of arm pivot point from ground at bottom limit
        public static final Translation2d COLLECTOR_OFFSET = new Translation2d(6, new Rotation2d(Math.toRadians(0)));
        public static final Polygon BOUNDING_BOX = new Polygon(new int[] {0, 0, 0, 0}, new int[] {0, 0, 0, 0}, 4);
    }

    /* 
     * @param x The x position of the lift in inches
     * @param y The y position of the lift in inches
     */
    public SetLiftPositionXY(Elevator elevator, FourBar fourBar, DoubleSupplier x, DoubleSupplier y) {
        this.elevator = elevator;
        this.fourBar = fourBar;
        this.desiredPose = () -> new Translation2d(x.getAsDouble(), y.getAsDouble());
    }

    public SetLiftPositionXY(Elevator elevator, FourBar fourBar, Supplier<Translation2d> pose) {
        this.elevator = elevator;
        this.fourBar = fourBar;
        this.desiredPose = pose;
    }

    public Translation2d getElevatorXY() {
        return new Translation2d(elevator.getHeight(), XYConstants.ELEVATOR_ANGLE);
    }

    public Translation2d getBarXY() {
        return new Translation2d(XYConstants.BAR_RADIUS, new Rotation2d(Math.toRadians(fourBar.getAngle())));
    }

    public Translation2d getOverallXY() {
        return XYConstants.ELEVATOR_OFFSET.plus(getElevatorXY()).plus(getBarXY().plus(XYConstants.COLLECTOR_OFFSET));
    }

    public Boolean isReachable(Translation2d pose) {
        return XYConstants.BOUNDING_BOX.contains(pose.getX(), pose.getY());
    }

    @Override
    public void initialize() {
        //Abandon all hope, ye who enter here
        //Tiebreaker for multiple solutions:
        //Keep Elevator as low as possible

        Translation2d currentPose = getOverallXY();
        Translation2d desiredPose = this.desiredPose.get();

        Translation2d delta = desiredPose.minus(currentPose);

        Rotation2d barAngle = delta.getAngle().minus(XYConstants.ELEVATOR_ANGLE);
        double elevatorHeight = delta.getNorm() * Math.cos(barAngle.getRadians());

        elevator.setHeight(elevatorHeight);
        fourBar.setAngle(barAngle);

    }

    @Override
    public boolean isFinished() {
        return (elevator.onTarget() && fourBar.onTarget()) | !isReachable(desiredPose.get());
    }
}
