package test_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class test_01 {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/Nabory3_wer1/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("cookies before delete: "+driver.manage().getCookies());
	    driver.manage().deleteAllCookies(); //
	    System.out.println("cookies after delete: "+driver.manage().getCookies());
	}
	
//	@SuppressWarnings("deprecation")
	@Test
	public void testRecording() throws Exception {
		driver.get(baseUrl);
		
		// Wybór Osi
		WebElement strzalka1 = driver.findElement(By.id("zk_comp_13-btn"));
		strzalka1.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("zk_comp_13-cave")));
				
		driver.findElement(By.id("zk_comp_75")).click();
		
		// Wybór Dzia³ania
		WebElement strzalka2 = driver.findElement(By.id("zk_comp_16-btn"));
		strzalka2.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("zk_comp_16-cave")));
		
		driver.findElement(By.id("zk_comp_61")).click();
		
		// Wybór podDzia³ania
		WebElement strzalka3 = driver.findElement(By.id("zk_comp_19-btn"));
		strzalka3.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("zk_comp_19-cave")));
		
		driver.findElement(By.id("zk_comp_63")).click();

/*     To nie zapisywa³o do Bazy danych wartoœci, chocia¿ daty pojawia³y siê w formularzu     		
		Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
		selenium.type("//input[contains(@id,'zk_comp_22-real')]", "2015-06-23 00:00:00.000"); 
		
		Thread.sleep(2000);
		
		selenium.type("//input[contains(@id,'zk_comp_25-real')]", "2015-08-15 00:00:00.000"); 
		
		Thread.sleep(1000);
*/
		
		// Data og³oszenia naboru
		driver.findElement(By.id("zk_comp_22-btn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("_z_0")));
		driver.findElement(By.id("_z_0-right")).click();

//		Thread.sleep(2000);
		// Czekamy na wykonanie sie skryptu javascript
		String miesiac = driver.findElement(By.id("_z_0-tm")).getText();
		System.out.println("Miesiac to " + miesiac);
				
		for(int second = 0;; second++) {
	        if (second >= 30) break;
	        try { 
	            if (driver.findElement(By.id("_z_0-tm")).getText().equals("cze")) 
	                break; 
	            } catch (Exception e) {}
	        Thread.sleep(1000);
	    }
		
		String miesiacPO = driver.findElement(By.id("_z_0-tm")).getText();
		System.out.println("Miesiac po petli for to " + miesiacPO);
					
		WebElement dateWidget = driver.findElement(By.id("_z_0-mid"));  
        List<WebElement> dniMiesiaca = dateWidget.findElements(By.tagName("td"));
        String dzien1 = dniMiesiaca.get(19).getText();
        System.out.println("Pocz¹tek " + dzien1);
        dniMiesiaca.get(19).click();
        Thread.sleep(2000);

     // Data zakoñczenia naboru
     	driver.findElement(By.id("zk_comp_25-btn")).click();
     	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("_z_2")));
     	driver.findElement(By.id("_z_2-right")).click();
     	Thread.sleep(1000);
		driver.findElement(By.id("_z_2-right")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("_z_2-right")).click();
		Thread.sleep(1000);
		
		// Czekamy na wykonanie sie skryptu javascript
		for (int second = 0;; second++) {
			if (second >= 30)
				break;
			try {
				if (driver.findElement(By.id("_z_2-tm")).getText()
						.equals("sie"))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		WebElement dateWidget2 = driver.findElement(By.id("_z_2-mid"));
		List<WebElement> dniMiesiaca2 = dateWidget2.findElements(By.tagName("td"));
		String dzien2 = dniMiesiaca2.get(19).getText();
        System.out.println("Koniec " + dzien2);
        dniMiesiaca2.get(19).click();
        Thread.sleep(2000);

		
		
		// Budzet naboru
        WebElement budzetNaboru = driver.findElement(By.id("zk_comp_28"));
        budzetNaboru.click();
        budzetNaboru.clear();
		CharSequence[] budzet = { "1500000" };
		budzetNaboru.sendKeys(budzet);
		Thread.sleep(1000);

		// Status naboru
		// przycisk przy wyborze statusów
		driver.findElement(By.id("zk_comp_31-btn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.id("zk_comp_31-cave")));

		// wybor statusu
		driver.findElement(By.id("zk_comp_88")).click();
		Thread.sleep(1000);

		// Instytucja og³aszaj¹ca nabór
		// przycisk przy polu
		driver.findElement(By.id("zk_comp_34-btn")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.id("zk_comp_34-cave")));

		// wybor instytucji
		driver.findElement(By.id("zk_comp_97")).click();
		Thread.sleep(1000);
		
		// Opcja na TAK NIE lub NIE WIEM
		WebElement radio = driver.findElement(By.id("zk_comp_42-real"));
		if(radio.isSelected()) {
			System.out.println("Opcja TAK zaznaczona");
		} else {
			System.out.println("Opcja TAK NIE jest zaznaczona");
		};

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", radio);
				
		if(driver.findElement(By.id("zk_comp_42-real")).getAttribute("checked") != null) {
			System.out.println("Zaznaczona opcja TAK");
		}
		
		Thread.sleep(1000);
		
		// Przycisk zapisu do Bazy Danych
		driver.findElement(By.id("zk_comp_49")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ciemnozolty")));
		
		driver.findElement(By.className("ciemnozolty")).click();
	
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
}
