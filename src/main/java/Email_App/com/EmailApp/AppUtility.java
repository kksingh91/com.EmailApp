package Email_App.com.EmailApp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppUtility {

	public static WebDriver driver = null;

	public static void openBrowser(String browserName) {

		browserName = browserName.toLowerCase();
		if (browserName.startsWith("c")) {

			System.setProperty("webdriver.chrome.driver", "../my-app/Browser/chromedriver");
			driver = new ChromeDriver();
		}

	}

	public static void processWait() {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public static void openUrl(String url) {
		driver.get(url);
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}



	public static void acceptEnquiry() {

		driver.findElement(By.linkText("ACCEPT")).click();

	}

	public static void closeDriver() {

		driver.close();

	}

	public static void readEmailList() {

		WebElement table = driver.findElement(By.className("Cp"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		String expectedText = "New booking in the rides list - 508329";

		int len = allRows.size();

		System.out.println("Lenght : " + len);

		// for (int i = 0; i < allRows.size(); i++) {
		for (int i = 0; i < 8; i++) {

			// System.out.println("Rows :" + i);

			List<WebElement> alltd = allRows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < alltd.size(); j++) {
				WebElement td = alltd.get(j);
				String tdValue = td.getText();
				tdValue = tdValue;
				System.out.println("tdValue  : " + tdValue);
				if (tdValue.startsWith("New booking in the rides list")) {
					System.out.println("Hello New booking in the rides.................................");
					td.click();
					processWait();
					processWait();
					acceptEnquiry();
					break;

				}

			}
		}
	}

	public static void emailLoginByXpath() {
		windowMaximize();
		// processWait();
		openUrl("https://mail.google.com/mail/u/1/#inbox");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("taxi2airport.hmc@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
		processWait();
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("taxi2@4hmc8");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content")).click();
		processWait();
		readEmailList();
	}

	public static void emailLoginId() {
		windowMaximize();
		// processWait();
		openUrl("https://mail.google.com/mail/u/1/#inbox");
		driver.findElement(By.id("identifierId")).sendKeys("taxi2airport.hmc@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		processWait();
		driver.findElement(By.name("password")).sendKeys("taxi2@4hmc8");
		driver.findElement(By.id("passwordNext")).click();
		processWait();
		readEmailList();
	}
}
