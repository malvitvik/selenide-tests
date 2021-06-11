package project.pages;

import com.codeborne.selenide.SelenideElement;
import project.models.UserInfo;

import static com.codeborne.selenide.Selenide.*;

public class SignUpPage {
	
	SelenideElement edtFirstName = $("input[name='firstname']");
	SelenideElement edtLastName = $("input[name='lastname']");
	SelenideElement edtPhoneNumber = $("input[name='phone']");
	SelenideElement edtEmail = $("input[name='email']");
	SelenideElement edtPassword = $("input[name='password']");
	SelenideElement edtConfirmPassword = $("input[name='confirmpassword']");
	SelenideElement ctaSignUp = $("button.signupbtn");
	
	public void registerUser(UserInfo userInfo) {

		fillForm(userInfo);

		ctaSignUp.scrollTo()
		         .click();
	}


	protected void fillForm(UserInfo userInfo) {
		edtFirstName.val(userInfo.firstName());
		edtLastName.val(userInfo.lastName());
		edtPhoneNumber.val(userInfo.phoneNumber());
		edtEmail.val(userInfo.email());
		edtPassword.val(userInfo.password());
		edtConfirmPassword.val(userInfo.password());
		screenshot("filled registration form");
	}
}
