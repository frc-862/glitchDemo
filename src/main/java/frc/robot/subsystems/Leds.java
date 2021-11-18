// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Leds extends SubsystemBase {
    final int ledLength = 123; //TODO: get actual length
    final AddressableLED ledStrip = new AddressableLED(1);
    final AddressableLEDBuffer buffer = new AddressableLEDBuffer(ledLength);

    public Leds() {
        ledStrip.start();
        ledStrip.setLength(ledLength);
    }

    public void periodic() {}

    public void writeBuffer() {
        ledStrip.setData(buffer);
    }

    public void setRGB(int[] rgb, int length) {
        int i;
        for (i=0; i<length; i++) {
            buffer.setRGB(i, rgb[0], rgb[1], rgb[2]);
        }
        ledStrip.setData(buffer);
    }

    public void setRGB(int[] rgb) {
        setRGB(rgb, ledLength);
    }

    public void setGradient(int[] startRgb, int[] endRgb, int length, boolean show, int offset) {
        int i,r,g,b;
        for (i=offset; i<length; i++) {
            r = (int) (((endRgb[0]-startRgb[0])*(i/length))+startRgb[0]);
            g = (int) (((endRgb[1]-startRgb[1])*(i/length))+startRgb[1]);
            b = (int) (((endRgb[2]-startRgb[2])*(i/length))+startRgb[2]);
            buffer.setRGB(i, r, g, b);
        }
        if (show) {
            ledStrip.setData(buffer);
        }
    }

    public void setGradient(int[] startRgb, int[] endRgb) {
        setGradient(startRgb, endRgb, ledLength, false, 0);
    }

    public void doubleGradient(int[] startingRgb, int[] middleRgb, int[] endingRgb) {
        setGradient(startingRgb, middleRgb, Math.round(ledLength/2), false, 0);
        setGradient(middleRgb, endingRgb, Math.round(ledLength-(ledLength/2)), true, Math.round(ledLength/2));
    }

    //Premade effects:
    public void orangeAndBlue() {
        //lightning robotics orange is ff9900 (255, 153, 0)
        int[] blue = {0, 0, 255};
        int[] orange = {255, 153, 0};
        doubleGradient(blue, orange, blue);
    }

    public void stop() {
        ledStrip.stop();
        ledStrip.close();
    }
}
