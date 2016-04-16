package core;

//BEGIN
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class selenium {

	public String[][] a2d() throws IOException {

		String file = "./src/main/resources/123.csv";
		BufferedReader btr = null;
		String str = null;
		String[] col = null;
		int strs = 0;
		int cols = 0;
		String SplitBy = "!";
		String case_id = null;
		String url = null;
		String tit_exp = null;

		// COUNTING strs AND col
		btr = new BufferedReader(new FileReader(file));
		while ((str = btr.readLine()) != null) {
			strs++;
			col = str.split(SplitBy);
			cols = col.length;
		}
		btr.close();
		String s2d[][] = new String[strs][cols];
		btr = new BufferedReader(new FileReader(file));
		 WebDriver driver = new FirefoxDriver();
	//	WebDriver driver = new HtmlUnitDriver();
		int i = 0;
		while ((str = btr.readLine()) != null) {
			String[] csv = str.split(SplitBy);
			case_id = csv[0];
			url = csv[1];
			tit_exp = csv[2];
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String tit_real = driver.getTitle();
			s2d[i][0] = case_id;
			s2d[i][1] = tit_exp;
			s2d[i][2] = tit_real;
			i++;
		}
		driver.quit();
		btr.close();
		return s2d;
	}
	public static void main(String[] args) throws IOException {
 	selenium sel = new selenium();
		sel.a2d();
	}
}
//END
