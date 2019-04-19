package screenshotter;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class test3 {

	public static void main(String[] args) {
		
		int current_number;

		String index = "C:\\Users\\s-xub\\Pictures\\screenshots\\";

		while (true) {

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
	
}