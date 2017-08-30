import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class Window {

	public static void main(String[] args) {

		JFrame window = new JFrame ();
		DisplayMode displayMode = new DisplayMode (800, 600, 16, 75);
		
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = environment.getDefaultScreenDevice();
		device.setFullScreenWindow(window);
		device.setDisplayMode(displayMode);
	}

}
