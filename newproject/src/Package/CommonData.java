package Package;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public abstract class CommonData {
	protected String screenshotsDirectory;
	protected String url;
	protected String urlHome;
	
	public CommonData() {
		this.screenshotsDirectory = "C:\\Users\\Usuario\\Pictures\\ScreensCrowdar";
		this.url = "https://www.saucedemo.com/";
		this.urlHome = "https://www.saucedemo.com/inventory.html";
	}
	
	public void takeSnapShot(WebDriver webdriver) throws Exception{
        //Call getScreenshotAs method to create image file
        File SrcFile= ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile=new File(screenshotsDirectory);

        //Copy file at destination
        FileUtils.copyFileToDirectory(SrcFile, DestFile);
        System.out.println("Screen has been taken and saved at " + screenshotsDirectory);
    }
	
	public void logOut() {
		
	}
	
}
