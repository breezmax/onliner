package onliner.pageObject.pages;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class AutobaraholkaPage extends BasePage {

    private static final By PAGE_LOCATOR = By.xpath("//span[@class='b-main-navigation__text'][contains(text(),'Автобарахолка')]");
    private static final String USD_CURRENCY = "//a[@class='vehicle-form__link vehicle-form__link_primary vehicle-form__link_base'][contains(text(),'%s')]";
    private static final String CURRENCY_PLACEHOLDER ="//div[@class='vehicle-form__row vehicle-form__row_condensed-alter']//input[@placeholder='%s']";
    private static final String SEDAN_CHECKBOX = "//div[@class='vehicle-form__checkbox-sign'][contains(text(),'%s')]";
    private static final String TRANSMISSION = "//div[@class='vehicle-form__checkbox-sign'][contains(text(),'%s')]";

    private static final By FILTERED_CAR_PRICE = By.xpath("//div[@class='button-style button-style_primary button-style_base button-style_noreflex vehicle-form__button vehicle-form__button_price']");

    public AutobaraholkaPage() {
        super(PAGE_LOCATOR, "'Autobaraholka' page");
        assertIsOpened();
    }

    @Step("Выбор валюты")
    public void selectCurrency(String setCurrency){
        Button setCurrencyButton = new Button(By.xpath(String.format(USD_CURRENCY, setCurrency)));
        setCurrencyButton.scrollToElementViaJS();
        setCurrencyButton.click();
    }

    @Step("Заполнение фильтра по цене")
    public void setFilterByPrice(String selectFieldFromOrTill, String setPriceValue) {
        TextBox currencyPlaceholder = new TextBox(By.xpath(String.format(CURRENCY_PLACEHOLDER, selectFieldFromOrTill)));
        currencyPlaceholder.moveAndClickByAction();
        currencyPlaceholder.sendKeys(setPriceValue);
    }

    @Step("Выбор фильтра по кузову: Седан")
    public void setFilterByKuzov(String setCarBody) {
        Button sedanCheckbox = new Button(By.xpath(String.format(SEDAN_CHECKBOX, setCarBody)));
        sedanCheckbox.moveToElement();
        sedanCheckbox.clickAndWait();
    }

    @Step("Выбор фильтра по коробке передач: Автоматическая")
    public void setFilterByTransmission(String setCarTransmission){
        Button transmissionButton = new Button(By.xpath(String.format(TRANSMISSION, setCarTransmission)));
        transmissionButton.moveToElement();
        transmissionButton.clickAndWait();
    }

/*    @Step("Проверка результатов поиска по выбранным фильтрам: 100.000$ && Седан && Автоматическая коробка передач")
    public void checkCarFilteringResults() {
        TRANSMISSION.moveToElement();
        TRANSMISSION.clickAndWait();
    }*/



}
