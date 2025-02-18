package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsPage {
    private static final SelenideElement title = $(".title");
    private static final SelenideElement item=$x("(//div[@class='inventory_item'])[1]");
    private static final SelenideElement itemName=$("#item_4_title_link");
    private static final SelenideElement shoppingCart=$(".shopping_cart_link");

    public static void pageLoaded(){
        title.shouldBe(visible).shouldHave(text("Products"));
        //Assert.assertEquals(title.shouldBe(visible), "Page title is not displayed");
        //Assert.assertEquals(title.text() ,"Swag Labs","Page title is incorrect");
    }
    //Находи 1 карточку
    public static void itemLoaded(){
          item.shouldBe(visible);
        //Assert.assertEquals(item.isDisplayed(), "Item is not displayed");
    }
    public static void checkName(String heading){
        itemName.$(".inventory_item_name")
                .shouldHave(text(heading));
           }
    //Добывляем товар в корзину
    public static void addProduct(){

        item.$("#add-to-cart-sauce-labs-backpack").click();
    }
    //Проверяем, что товар добавился
    public static void checkShoppingCart(){
        item.$("#remove-sauce-labs-backpack").shouldBe(visible);
        shoppingCart.$(".shopping_cart_badge")
                .shouldHave(text("1"));

    }


}
