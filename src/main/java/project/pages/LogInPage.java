package project.pages;

import static com.codeborne.selenide.Selenide.*;

public class LogInPage {
	
	public void login(String email, String password) {
		$("input[name='username']").val(email);
		$("input[name='password']").val(password);
		
		$("button[type='submit']").click();
	}
}
