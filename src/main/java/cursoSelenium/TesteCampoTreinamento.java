package cursoSelenium;



import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver(); 
		 driver.manage().window().maximize();
		 driver.get("file:///" +  System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		 dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testeTextField() {
		 
		 dsl.escreve("elementosForm:nome", "Texto escrito");
		 Assert.assertEquals("Texto escrito",dsl.obterValorCampo("elementosForm:nome"));
		 
	}
	
	@Test
	public void testeTextArea() {
		
		 driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		Assert.assertEquals("teste",  driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		 
		 
	}
	
	
	@Test
	public void testeRadioButton() {

		 driver.findElement(By.id("elementosForm:sexo:0")).click();
		 Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		 
	}
	
	@Test
	public void testeCheckBox() {
	
		 driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		 Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		 
	}
	
	
	
	
	@Test
	public void testeComboBox() {

		 WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		 Select combo = new Select(element);
		//combo.selectByIndex(2);
	    //combo.selectByValue("superior");
		 
		 combo.selectByVisibleText("2o grau completo");
		 
		Assert.assertEquals("2o grau completo",  combo.getFirstSelectedOption().getText());
		
		 
	}
	
	
	
	
	@Test
	public void testeVerificarCombo() {

		 WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		 Select combo = new Select(element);
		 
		 List<WebElement> options = combo.getOptions();
		 Assert.assertEquals(8, options.size());
		 
		 
		 boolean encontrou = false;
		 for(WebElement option: options) {
			 if(option.getText().equals("Mestrado")) {
				 encontrou = true;
				 break;
			 }
		 }
		 
		 Assert.assertTrue(encontrou);
		 
		 
		 
	}
	
	
	@Test
	public void testeVerificarComboMultipla() {

		 WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		 Select combo = new Select(element);
		 
		 combo.selectByVisibleText("Natacao");
		 combo.selectByVisibleText("Corrida");
		 combo.selectByVisibleText("O que eh esporte?");
		 
		 
		 List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		 
		 Assert.assertEquals(3,allSelectedOptions.size());
		 
	}
	
	
	@Test
	public void testeBotao() {

		 
		 WebElement botao = driver.findElement(By.id("buttonSimple"));
		 
		 botao.click();
		 
		 Assert.assertEquals("Obrigado!",botao.getAttribute("value"));
	}
	
	
	
	@Test
	public void testeLink() {

		 driver.findElement(By.linkText("Voltar")).click();
		// Assert.fail();
		 
		 Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		 
		 
	}
	
	
	
	@Test
	public void testeBuscaText() {
		// Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		 Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
		 
		 
		 Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
	}
}






