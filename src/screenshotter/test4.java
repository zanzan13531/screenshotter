package screenshotter;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class test4 implements NativeKeyListener {

	public test4() throws Exception {
		// KeyEvent.getExtendedKeyCodeForChar('1');
	}

	public void nativeKeyPressed(NativeKeyEvent e) {

		if (e.getKeyCode() == NativeKeyEvent.VC_BACKQUOTE) { 
			//backquote is the (`) key, next to the number 1													// the number 1

			int current_number;

			String index = "C:\\Users\\s-xub\\Pictures\\screenshots\\";

			try {

				File number = new File(index + "number.txt");
				Scanner s = new Scanner(number);
				current_number = Integer.parseInt(s.nextLine());
				current_number = current_number + 1;
				s.close();

				Robot robot = new Robot();
				String format = "jpg";
				String fileName = index + "FullScreenshot" + current_number + "." + format;

				Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
				ImageIO.write(screenFullImage, format, new File(fileName));

				FileWriter w = new FileWriter(index + "number.txt");
				w.write(Integer.toString(current_number));
				w.close();

			} catch (AWTException | IOException ex) {

				System.out.println("An error occurred.");

			}

		}
	}

	public void nativeKeyReleased(NativeKeyEvent e) {

	}

	public void nativeKeyTyped(NativeKeyEvent e) {

	}

	public static void main(String[] args) throws Exception {

		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new test4());
	}
}
