package project;

import javax.inject.Inject;

import com.codeborne.selenide.testng.ScreenShooter;
import com.google.inject.Provider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import project.guice.SelenideModule;
import project.models.UserInfo;
import project.pages.AccountPage;
import project.pages.FooterPage;
import project.pages.HeaderPage;
import project.pages.LogInPage;
import project.pages.SignUpPage;
import project.utils.Email;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

@Guice(modules = SelenideModule.class)
@Listeners({ScreenShooter.class})
public class TravelsTest {

 	@Inject HeaderPage header;
 	@Inject FooterPage footer;
 	@Inject SignUpPage signUpPage;
 	@Inject LogInPage logInPage;
 	@Inject AccountPage accountPage;
 	
 	@Inject @Email Provider<String> emailProvider;

    @BeforeMethod
    public void startBrowser(){
        open("https://www.phptravels.net/en");
    }

    @DataProvider(parallel = true)
    private Object[][] languageIds() {
    	return new Object[][] {
    			{"ar"}, {"tr"}, {"de"}, {"en"}, {"fr"} 
    	};
    }


    @Test(dataProvider = "languageIds")
    public void userCanSelectDifferentLanguage(String languageId) {
		String languageDisplayName = header.changeLanguage(languageId);
		header.verifySelectedLanguage(languageDisplayName);
	}


	@Test
	public void registerNewUser() {
		String email = emailProvider.get();
		String password = "111111";
		
		registerUser(email, password);

		accountPage.shouldBe(visible);
	}


	@Test
	public void userCanLogIn() {
		String email = emailProvider.get();
		String password = "111111";
    	
		registerUser(email, password); //user is saved for a short time, no registration via api
		accountPage.shouldBe(visible);
		
		header.accountMenu().logOut();

		logInPage.login(email, password);
		accountPage.shouldBe(visible);
	}


	protected void registerUser(String email, String password) {
		header.accountMenu().openSignUpPage();
		signUpPage.registerUser(new UserInfo("firstName", "lastName", "0321 1234 123 123",
		                                     email, password));
	}
	
	
	@DataProvider(parallel = true)
	private Object[][] subscriptions(){
    	return new Object[][] { 
			{ emailProvider.get(), "Subscribed Successfully" },
			{ "", "The Email field is required." },
			{ "@invalid@email.at", "Kindly Enter a Valid Email Address." }
    	};
    }
	
	
	@Test(dataProvider = "subscriptions")
	public void emailSubscription(String email, String message) {
		footer.emailSubscription().subscribe(email);
		footer.emailSubscription().verifySubscriptionResponse(message);
	}
}
