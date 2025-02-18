package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final SelenideElement title=$(".login_logo");
    private static final SelenideElement inputLogin=$("#user-name");
    private static final SelenideElement inputPassword = $("#password");
    private static final SelenideElement inputButton= $("#login-button");

    public static void pageIsLoaded(){
        title.shouldBe(visible).shouldHave(text("Swag Labs"));
        // Assert.assertTrue("Page title is not displayed",title.isDisplayed());
        // Assert.assertEquals("Page title is incorrect", "Swag Labs", title.getText());
    }

    public static void inputLogin(String login){
        inputLogin.setValue(login);
    }
    public static void enterPassword(String password){
        inputPassword.setValue(password);
    }
    public static void loginButtonClick(){
        inputButton.click();
    }

}
