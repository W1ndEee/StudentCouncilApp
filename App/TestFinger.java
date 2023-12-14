package App;
import com.fazecast.jSerialComm.*;
import java.util.*;
import java.io.*;

public class TestFinger {

	
	public static void main(String[] args) throws IOException {
		// List available ports
        SerialPort[] ports = SerialPort.getCommPorts();
        System.out.println("Available Ports:");
        for (SerialPort port : ports) {
            System.out.println(port.getSystemPortName());
        }

        // Open the desired port.
        SerialPort comPort = SerialPort.getCommPort("tty.usbmodem143101"); // Replace with your port name
        comPort.openPort();

        try {
            // Set port parameters (optional depending on your device)
            comPort.setComPortParameters(9600, 8, 1, SerialPort.NO_PARITY);

            // Set the timeout
            comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

            // Create a reader to read the serial data.
            InputStream in = comPort.getInputStream();

            try {
                for (int j = 0; j < 1000; ++j) { // Just an example, adjust your reading loop accordingly
                    while (in.available() > 0) {
                        System.out.print((char)in.read());
                    }
                    Thread.sleep(100); 
                }
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            comPort.closePort();
        }
	}

}
