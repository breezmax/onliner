package onliner;

import framework.BaseTest;
import onliner.pageObject.CatalogPage;
import onliner.pageObject.MainPage;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {





    @Test
    public void NavigationMenuOnlinerTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu();

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateToComputers();
        catalogPage.navigateToSubMenuItems();
        catalogPage.navigateToSubMenuCategory();

    }


}
/*
 * 1. Перейти на вкладку Каталог
 * 2. Выбрать Компьютеры и сети в меню навигации
 * 3.  В подменю навести на  Ноутбуки, компьютеры, мониторы
 * 4. Перйти на страницу Игровые ноутбуки*/