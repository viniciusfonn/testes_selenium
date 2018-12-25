package cursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;


public class TesteGoogle {
	
	@Test
	public void teste() {
		//WebDriver driver = new InternetExplorerDriver();  
		 //WebDriver driverFire = new FirefoxDriver(); 
		 WebDriver driver = new ChromeDriver(); 
		 driver.manage().window().setPosition(new Point(20,30));
		// driver.manage().window().setSize(new Dimension(300,300));
		 driver.manage().window().maximize();
		
		 driver.get("https://www.google.com");
		 //driverFire.get("https://www.google.com");
		 
		 
		 Assert.assertEquals("Google",driver.getTitle());
		 //Assert.assertEquals("Google",driverFire.getTitle());
		 
		 driver.quit();
		 
	}

}
