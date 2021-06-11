package project.pages;

import javax.inject.Inject;

import com.codeborne.selenide.SelenideElement;
import project.pages.widgets.AccountMenuWidget;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class HeaderPage extends BasePage {
	
	@Inject protected AccountMenuWidget accountMenuWidget;
	
	public AccountMenuWidget accountMenu() {
		return accountMenuWidget;
	}


	/**
	 * 
	 * @param languageId two letter id for language
	 * @return text for languageId
	 */
	public String changeLanguage(String languageId) {
		$(".dropdown-language > a").click();
		SelenideElement languageOption = $(String.format(".dropdown-language a#%s", languageId));
		String result = languageOption.text();
		languageOption.click();
		return result;
	}


	public void verifySelectedLanguage(String languageDisplayName) {
		$(".dropdown-language > a").shouldHave(text(languageDisplayName));
	}
}
