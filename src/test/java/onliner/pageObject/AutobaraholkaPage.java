package onliner.pageObject;

import framework.BasePage;
import framework.elements.Button;
import framework.elements.TextBox;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class AutobaraholkaPage extends BasePage {

    private static final By PAGE_LOCATOR = By.xpath("//span[@class='b-main-navigation__text'][contains(text(),'Автобарахолка')]");

    private static final Button USD_CURRENCY = new Button(By.xpath("//a[@class='vehicle-form__link vehicle-form__link_primary vehicle-form__link_base'][contains(text(),'USD')]"));
    private static final TextBox CURRENCY_DO = new TextBox(By.xpath("//div[@class='vehicle-form__row vehicle-form__row_condensed-alter']//input[@placeholder='до']"));
    private static final Button SEDAN_CHECKBOX = new Button(By.xpath("//div[@class='vehicle-form__checkbox-sign'][contains(text(),'Седан')]"));
    private static final Button PEREDACHI = new Button(By.xpath("//div[@class='vehicle-form__checkbox-sign'][contains(text(),'Автоматическая')]"));

    private static final By FILTERED_CAR_PRICE = By.xpath("//div[@class='button-style button-style_primary button-style_base button-style_noreflex vehicle-form__button vehicle-form__button_price']");

    public AutobaraholkaPage() {
        super(PAGE_LOCATOR, "'Autobaraholka' page");
        assertIsOpened();
    }



    @Step("Выбор 'USD' валюты")
    public void selectUSDCurrency(){
        USD_CURRENCY.scrollToElementViaJS();
        USD_CURRENCY.click();
    }


    @Step("Заполнение фильтра по цене")
    public void setFilterByPrice() {
        CURRENCY_DO.moveAndClickByAction();
        CURRENCY_DO.sendKeys("100000");
    }

    @Step("Выбор фильтра по кузову: Седан")
    public void setFilterByKuzov() {
        SEDAN_CHECKBOX.moveToElement();
        SEDAN_CHECKBOX.clickAndWait();
    }

    @Step("Выбор фильтра по коробке передач: Автоматическая")
    public void setFilterByPeredachi(){
        PEREDACHI.moveToElement();
        PEREDACHI.clickAndWait();
    }


    @Step("Проверка результатов поиска по выбранным фильтрам: 100.000$ && Седан && Автоматическая коробка передач")
    public void checkCarFilteringResults() {
        PEREDACHI.moveToElement();
        PEREDACHI.clickAndWait();
    }



}
