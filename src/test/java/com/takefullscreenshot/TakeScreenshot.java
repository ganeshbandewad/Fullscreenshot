package com.takefullscreenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakeScreenshot {
	public static void main(String args[]) throws Exception{

 String url ="https://www.flux-academy.com/blog/7-website-navigation-best-practices-with-examples";

	System.setProperty("webdriver.chrome.driver", "./driver//chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.navigate().to(url);
	Thread.sleep(3000);
	driver.manage().window().maximize();
	
	Thread.sleep(3000);

    JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,500)", "");

	Thread.sleep(3000);

Screenshot screenshot=new AShot().shootingStrategy(Shootingtrategies.viewportPasting(1000)).takeScreenshot(driver);
    try {
    	final BufferedImage image = screenshot.getImage();
        ImageIO.write(screenshot.getImage(),"PNG",new File("./screenshot" +  ".png"));
    	
        
    } catch (IOException e) {
        e.printStackTrace();
    }

	System.out.println("Screenshot taken");
 
   
driver.close();
	
	
	}	
}
