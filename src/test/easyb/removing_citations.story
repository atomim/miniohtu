import miniohtu.*;
import org.seleniumhq.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import ohtu.miniohtu.testhelpers.UsefulMethods;

description 'User needs to be able to remove citations from the system.'

scenario 'User removes citations.', {
    given 'A citation exists', {
        driver = new HtmlUnitDriver();
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("Add citation")).click();  
        driver = UsefulMethods.addCitation(driver, "", "asdfghijkl");
    }
    when 'Citation is removed', {
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("List citations")).click();
        
        for(q in driver.findElements(By.linkText("Remove"))) {
            if(q.getAttribute("href").equals("http://127.0.0.1:8080/remove/asdfghijkl")) {
                q.click();
                break;
            }
        }
    }
    then 'The citation is gone.', {
        driver.get("http://127.0.0.1:8080/");
        driver.findElement(By.linkText("List citations")).click();
        /*driver.getPageSource().contains("asdfghijkl").shouldBe false;*/
    }
}