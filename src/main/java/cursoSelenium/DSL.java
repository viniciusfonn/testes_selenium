package cursoSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void escreve(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
}
