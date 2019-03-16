package app.my_app;

import org.testng.annotations.Test;

public class AppTestCase extends AppUtility{
	
	@Test(enabled = true, priority = 0)
	public void Taxi2Airport() {
		openBrowser("Chrome");
		emailLoginId();
		processWait();
		
	}

}
