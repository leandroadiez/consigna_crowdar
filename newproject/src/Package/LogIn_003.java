package Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn_003 extends CommonData {
	WebDriver driver;
	String expectedUrl;
	User user;
	
	public LogIn_003 (User user) {
		this.driver = new ChromeDriver();
		this.user = user;
		this.expectedUrl = url;
	}
	
	public void execute() throws Exception {
		System.out.println("Caso de prueba: LOG IN - 003 \n");
		open_website();
		type_credentials();
		enter_credentials();
		verification();
		System.out.println("Execution has been finalized");
		driver.quit();
	}
	public void open_website() {
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Website has been opened and maximized");
	}
	public void type_credentials() {
		WebElement username_input = driver.findElement(By.id("user-name"));
		username_input.sendKeys(user.getUsername());
		WebElement password_input = driver.findElement(By.id("password"));
		password_input.sendKeys(user.getPassword());
	}
	public void enter_credentials() {
		WebElement login_button = driver.findElement(By.name("login-button"));
		login_button.submit();
	}
	public void verification() throws Exception {
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals(this.expectedUrl) && driver.findElements(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).size() != 0) {
			System.out.println("Test status: Passed");
			System.out.println("User isn't logged in");
			String errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
			System.out.println(errorMessage);
		}
		else {
			takeSnapShot(driver);
			System.out.println("Test status: Failed");
			System.out.println("User isn't on the expected page");
			if(driver.getCurrentUrl().equals(urlHome)) {
				System.out.println("User is logged");
			}
			
		}
	}
	
}
