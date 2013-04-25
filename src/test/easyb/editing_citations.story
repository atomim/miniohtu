import miniohtu.*;
import org.seleniumhq.selenium.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import ohtu.miniohtu.testhelpers.UsefulMethods;

description 'User is able to edit existing citations.'

scenario 'User changes the information of a citation.', {
	given 'User is at the editing form.', {
	    driver = new HtmlUnitDriver();
        driver.get("http://localhost:8080/");
        driver.findElement(By.linkText("Add citation")).click();
        driver = UsefulMethods.addCitation(driver, "cs101", "Computer Science 101");
        driver.findElement(By.linkText("Edit")).click();
	}
	when 'Citation is updated.', {
        driver.findElement(By.name("title")).sendKeys("test123");
        driver.findElement(By.id("add")).click();
	}
	then 'The citation\'s information is changed to match the typed information.', {
		driver.getPageSource().contains("test123").shouldBe true
	}
}