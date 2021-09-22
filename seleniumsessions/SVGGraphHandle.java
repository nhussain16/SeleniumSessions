package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGGraphHandle {

	public static void main(String[] args) throws InterruptedException {

		// button[@type='submit']//*[local-name()='svg']
		// *[local-name()='svg']//*[name()='g']

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://emicalculator.net/");

		Thread.sleep(3000);

		String rectBarXpath = "//*[local-name()='svg' and @class='highcharts-root']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
		String tootTipXpath = "//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']";
		List<WebElement> barsList = driver.findElements(By.xpath(rectBarXpath));

		System.out.println(barsList.size());

		Actions act = new Actions(driver);

		
		for(WebElement e : barsList) {
			act.moveToElement(e).perform();
			//Thread.sleep(200);
			String text = driver.findElement(By.xpath(tootTipXpath)).getText();
			System.out.println(text);
		}
		
		
		
	}

}
