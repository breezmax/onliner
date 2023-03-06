package onliner.tests;

import framework.BaseTest;
import onliner.pageObject.pages.CatalogPage;
import onliner.pageObject.pages.MainPage;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void NavigationMenuOnlinerTest() {
        MainPage mainPage = new MainPage();
        mainPage.navigateHeaderMenu("Каталог");

        CatalogPage catalogPage = new CatalogPage();
        catalogPage.navigateToMainMenuItems();
        catalogPage.navigateToSubMenuItems("Ноутбуки, компьютеры, мониторы");
        catalogPage.navigateToSubMenuCategory("Игровые ноутбуки");
    }
}
/*
 * 1. Перейти на вкладку Каталог
 * 2. Выбрать Компьютеры и сети в меню навигации
 * 3.  В подменю навести на  Ноутбуки, компьютеры, мониторы
 * 4. Перйти на страницу Игровые ноутбуки*/