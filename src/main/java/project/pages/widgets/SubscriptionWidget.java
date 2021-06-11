package project.pages.widgets;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class SubscriptionWidget {
	
	public void subscribe(String email) {
		$("input#exampleInputEmail1").val(email);
		$("button.sub_newsletter").scrollTo()
		                          .click();
	}
	
	public void verifySubscriptionResponse(String msg) {
		$(".subscriberesponse").shouldBe(visible, text(msg));
	}
}
