package cursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {

	@Test
	public void teste() {
		 WebDriver driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		// driver.quit();
	}
}
