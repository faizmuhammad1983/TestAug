package PageLibrary;

import Configuration.WebSession;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AllRecipeMainPage {
    private WebDriverWait wait;
    private WebSession driver;
    private By searchBox = By.xpath("//input[contains(@id,'search-block')] ");


    public AllRecipeMainPage(WebSession driver, int explicitWait) {
        this.driver = driver;
        wait = new WebDriverWait(driver.getDriver(), explicitWait);

    }


    public void launchURL(String URL) {
        driver.getDriver().get(URL);

    }

    public void findObjectByXpath() {
        wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
    }

    public WebElement searchRecipe(String recipe) {
        WebElement elementExist = null;
        driver.getDriver().findElement(searchBox).sendKeys(recipe);
        driver.getDriver().findElement(searchBox).sendKeys(Keys.RETURN);
        try {
            //added case insensitive xpath to avoid any search issues
            String caseInsensitiveXpath = "//div/a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'),'"+recipe.toLowerCase()+"' )]";

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(caseInsensitiveXpath)));
            elementExist = driver.getDriver().findElement(By.xpath(caseInsensitiveXpath));
        } catch (NoSuchElementException e) {

        }

        return elementExist;

    }


}
