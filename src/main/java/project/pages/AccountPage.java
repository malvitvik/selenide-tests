package project.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {
	
	public void shouldBe(Condition... conditions) {
		//unique element
		$("img[src$='user.png']").shouldBe(conditions);
	}
}
