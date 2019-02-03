package cursoSelenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	
	@Test
	public void testeCadastro() {
		 WebDriver driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		 
		 driver.findElement(By.id("elementosForm:nome")).sendKeys("Vinicius");
		 driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Fonseca");
		 driver.findElement(By.id("elementosForm:sexo:0")).click();
		 driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		 new Select(driver.findElement(By.id("elementosForm:escolaridade"))).selectByVisibleText("Mestrado");
		 new Select(driver.findElement(By.id("elementosForm:esportes"))).selectByVisibleText("Natacao");
		 driver.findElement(By.id("elementosForm:cadastrar")).click();
		 
		 Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		 Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Vinicius"));
		 Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Fonseca"));
		 
		 driver.quit();
	}
	
}
