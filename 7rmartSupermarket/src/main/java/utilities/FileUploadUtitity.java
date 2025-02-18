package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;


public class FileUploadUtitity {
		
	public void FileUploadUsingSendKeys(WebElement element ,String imageuploadpath){
				element.sendKeys(imageuploadpath);
				}
			
	public void fileuploadUsingRobotClass(WebElement element ,String imageuploadpath) throws AWTException{
		
				element.click();
				StringSelection stringselection = new StringSelection(imageuploadpath);	
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				}

}
