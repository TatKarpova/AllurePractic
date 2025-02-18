package org.example;

import Pages.LoginPage;
import Pages.ProductsPage;
import com.codeborne.selenide.Selenide;


import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Epic("Web interface")
public class AppTest {
    String userLogin ="standard_user";
    String password ="secret_sauce";

    String nameFirstItem ="Sauce Labs Backpack";

    @BeforeAll
    public static void setUp(){
        Selenide.open("https://www.saucedemo.com");
    }

    @Test
    @Description("Тест проверяет авторизацию")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Tatyana Karpova")
    @TmsLink("jira-123")
    public void loginTest(){
        //Проверяем, что зашли на страницу
        LoginPage.pageIsLoaded();
        //вводим данные для входа
        LoginPage.inputLogin(userLogin);
        LoginPage.enterPassword(password);
        LoginPage.loginButtonClick();
        //Проверяем переход на страницу
        ProductsPage.pageLoaded();
    }

    @Test
    @Description("Тест проверяет добавление в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Tatyana Karpova")
    @TmsLink("jira-1234")
    public void addToCard(){
        ProductsPage.pageLoaded();
        //Находи 1 карточку
        ProductsPage.itemLoaded();
        //Проверяем имя карточки
        ProductsPage.checkName(nameFirstItem);
        //Добывляем товар в корзину
        ProductsPage.addProduct();
        //Проверяем, что товар добавился
        ProductsPage.checkShoppingCart();
    }
}

