package screenshotter;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class test2 {

	public static void main(String[] args){
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);
		ImageIO.write(capture, "bmp", new File(args[0]));
	}

}
