package project.pages.widgets;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AccountMenuWidget {

	protected SelenideElement lnkAccount = $(".dropdown-login > a");


	public void openLoginPage() {
		epand();
		$(".dropdown-login .dropdown-menu a[href$='/login']").click();
	}


	public void openSignUpPage() {
		epand();
		$(".dropdown-login .dropdown-menu a[href$='/register']").click();
	}


	public void logOut() {
		epand();
		$(".dropdown-login .dropdown-menu a[href$='/logout/']").click();
	}


	private void epand() {
		lnkAccount.click();
	}
}
