package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Leds extends SubsystemBase {
    final int LED_LENGTH = 123; //TODO: get actual length
    final AddressableLED ledStrip = new AddressableLED(1);
    final AddressableLEDBuffer buffer = new AddressableLEDBuffer(LED_LENGTH);

    public Leds() {
        ledStrip.start();
        ledStrip.setLength(LED_LENGTH);
    }

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
        setRGB(rgb, LED_LENGTH);
    }

    public void setGradient(int[] startRgb, int[] endRgb, int length, boolean show, int offset) {
        int i,r,g,b;
        for (i=offset; i<length; i++) {
            //this formula for gradients that i wrote is super cool
            //I have no memory of how it works but it looks pretty smart so im just gonna leave it
            r = (int) (((endRgb[0]-startRgb[0])*(i/length))+startRgb[0]);
            g = (int) (((endRgb[1]-startRgb[1])*(i/length))+startRgb[1]);
            b = (int) (((endRgb[2]-startRgb[2])*(i/length))+startRgb[2]);
            buffer.setRGB(i, r, g, b);
        }
        if (show) {
            writeBuffer();
        }
    }

    public void setGradient(int[] startRgb, int[] endRgb) {
        setGradient(startRgb, endRgb, LED_LENGTH, false, 0);
    }

    public void doubleGradient(int[] startingRgb, int[] middleRgb, int[] endingRgb) {
        setGradient(startingRgb, middleRgb, Math.round(LED_LENGTH/2), false, 0);
        setGradient(middleRgb, endingRgb, Math.round(LED_LENGTH-(LED_LENGTH/2)), true, Math.round(LED_LENGTH/2));
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
