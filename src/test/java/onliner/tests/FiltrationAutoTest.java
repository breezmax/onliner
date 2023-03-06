package onliner.tests;

import framework.BaseTest;
import onliner.pageObject.pages.AutobaraholkaPage;
import onliner.pageObject.pages.MainPage;
import org.testng.annotations.Test;

/*
!!!1. Переход на вкладку Автобарахолка
  !2. Фильтрование авто до 100.000 USD
!!!3. Фильтрование авто по типу кухова: Седан
!!!4. Фильрование авто по типу коробки передач: Автоматическая
!!!5. Проверка что фильтрация работает корректна
 */
public class FiltrationAutoTest extends BaseTest {

    @Test
    public void FilteringCarsTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenuCar("Автобарахолка");

        AutobaraholkaPage carPage = new AutobaraholkaPage();
        carPage.selectCurrency("USD");
        carPage.setFilterByPrice("до", "100000");
        carPage.setFilterByKuzov("Седан");
        carPage.setFilterByTransmission("Автоматическая");
    }
}
