
package ohtu.miniohtu.testhelpers;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.config.DataSourceConfig;

public class UsefulMethods {

    public static HtmlUnitDriver addCitation(HtmlUnitDriver driver, String shorthand, String title) {
        return addCitation(driver, 1, shorthand, title, "asdf", "2009", "asdf", null);
    }
    
    public static HtmlUnitDriver addCitation(
            HtmlUnitDriver driver,
            int type,
            String shorthand,
            String title,
            String author,
            String year,
            String publisher,
            Map<String, String> additionalFields
    ) {
        //driver.get("http://127.0.0.1:8080/");
        //driver.findElement(By.linkText("Add citation")).click();
        
        new Select(driver.findElement(By.name("type"))).selectByIndex(type);
        
        driver.findElement(By.name("shorthand")).sendKeys(shorthand);
        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("author")).sendKeys(author);
        driver.findElement(By.name("year")).sendKeys(year);
        driver.findElement(By.name("publisher")).sendKeys(publisher);
        
        /* TODO */
        if(additionalFields != null)
            for(Entry<String, String> entry : additionalFields.entrySet());
        
        driver.findElement(By.id("add")).submit();
        return driver;
    } 
}
