package onliner;


import framework.BaseTest;
import onliner.pageObject.AutobaraholkaPage;
import onliner.pageObject.MainPage;
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
        mainPage.navigateHeaderMenuCar();

        AutobaraholkaPage carPage = new AutobaraholkaPage();
        carPage.selectUSDCurrency();
        carPage.setFilterByPrice();
        carPage.setFilterByKuzov();
        carPage.setFilterByPeredachi();

    }

}
