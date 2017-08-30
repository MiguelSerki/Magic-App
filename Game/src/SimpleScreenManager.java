import java.awt.*;
import java.awt.Window;

import javax.swing.JFrame;

/**
 * The SimpleScreenManager class manages initializing and displaying full screen
 * graphics modes. [ Team LiB ] � Table of Contents � Index Developing Games in
 * Java� By David Brackeen, Bret Barker, Laurence Vanhelsuw� Publisher: New
 * Riders Publishing Pub Date: August 20, 2003 ISBN: 1-5927-3005-1 Pages: 1008
 * If you already have experience programming games with Java, this book is for
 * you. David Brackeen, along with co-authors Bret Barker and Lawrence
 * Vanhelsuwe, show you how to make fast, full-screen action games such as side
 * scrollers and 3D shooters. Key features covered in this book include Java 2
 * game programming techniques, including latest 2D graphics and sound
 * technologies, 3D graphics and scene management, path-finding and artificial
 * intelligence, collision detection, game scripting using BeanShell, and
 * multi-player game engine creation. [ Team LiB ]
 */
public class SimpleScreenManager {
	private GraphicsDevice device;

	/**
	 * Creates a new SimpleScreenManager object.
	 */
	public SimpleScreenManager() {
		GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		device = environment.getDefaultScreenDevice();
	}

	/**
	 * Enters full screen mode and changes the display mode.
	 */
	public void setFullScreen(DisplayMode displayMode, JFrame window) {
		window.setUndecorated(true);
		window.setResizable(false);
		device.setFullScreenWindow(window);
		if (displayMode != null && device.isDisplayChangeSupported()) {
			try {
				device.setDisplayMode(displayMode);
			} catch (IllegalArgumentException ex) {
				// ignore - illegal mode for this device
			}
		}
	}

	/**
	 * Returns the window currently used in full screen mode.
	 */
	public Window getFullScreenWindow() {
		return device.getFullScreenWindow();
	}

	/**
	 * Restores the screen's display mode.
	 */
	public void restoreScreen() {
		Window window = device.getFullScreenWindow();
		if (window != null) {
			window.dispose();
		}
		device.setFullScreenWindow(null);
	}
}