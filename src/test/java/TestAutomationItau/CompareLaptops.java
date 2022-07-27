package TestAutomationItau;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilitarios.IniciarConexion;

import java.util.List;

public class CompareLaptops {

    static WebDriver driver;
    static String laptop_1 = "Lenovo E41-80";
    static String laptop_2 = "Lenovo B40-80";
    public static void main(String[] args) throws InterruptedException {
        cargarPagina();
        clickCompareLaptops();
        extraerDetalleSummary();
    }

    public static void cargarPagina(){
        driver = IniciarConexion.driverConexion("Chrome");
        driver.get("https://www.gadgetsnow.com/compare-laptops");
    }

    public static void clickCompareLaptops() throws InterruptedException {
        for (int i = 1; i <=2; i++){
            WebElement selectLaptops = driver.findElement(By.xpath("(//span[contains(@class, '_1WJ4c')])["+i+"]"));
            selectLaptops.click();
            Thread.sleep(2000);
            WebElement buscarLaptop = driver.findElement(By.xpath("//input[contains(@placeholder, 'Search Laptops')]"));
            if(i ==1){
                buscarLaptop.sendKeys(laptop_1);
                Thread.sleep(2000);
                WebElement laptopLenovo1 = driver.findElement(By.xpath("(//mark[text()= 'Lenovo E41-80'])[1]"));
                laptopLenovo1.click();
            }else {
                Thread.sleep(2000);
                buscarLaptop.sendKeys(laptop_2);
                Thread.sleep(5000);
                WebElement laptopLenovo2 = driver.findElement(By.xpath("(//mark[text() = 'Lenovo B40-80'])[1]"));
                laptopLenovo2.click();
            }
            Thread.sleep(3000);
        }
        WebElement buttonCompare = driver.findElement(By.xpath("//button[contains(text(),'compare')]"));
        buttonCompare.click();

    }

    public static void extraerDetalleSummary() throws InterruptedException {
        Thread.sleep(5000);
        WebElement tabla = driver.findElement(By.xpath("//div[contains(@class,'UMZaM _2BFOx')]/table"));
        //WebElement casillas = driver.findElement(By.xpath("//div[contains(@class,'UMZaM _2BFOx')]/table//tr"));
        List<WebElement> casillas = (List<WebElement>) tabla.findElement(By.xpath("//div[contains(@class,'UMZaM _2BFOx')]/table//tr"));
        int cantRegistros = casillas.size();
        System.out.println("Cantidad de registros: " +cantRegistros);
    }
        
}
