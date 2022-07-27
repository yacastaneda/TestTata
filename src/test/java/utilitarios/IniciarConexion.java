package utilitarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IniciarConexion {

     static WebDriver driver;

     public static WebDriver driverConexion (String browser){
          if(browser.equals("Chrome")){
               System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
               driver = new ChromeDriver();
          }
          return driver;
     }
}
