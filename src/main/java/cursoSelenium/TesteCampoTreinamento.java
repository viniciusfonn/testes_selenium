package cursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCampoTreinamento {

	@Test
	public void tsteTextField() {
		 WebDriver driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		 driver.findElement(By.id("elementosForm:nome")).sendKeys("Texto escrito");
		 Assert.assertEquals("Texto escrito", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		 
		driver.quit();
	}
	
	@Test
	public void testeTextArea() {
		 WebDriver driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		 driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste",  driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		 
		 
		 driver.quit();
	}
}

