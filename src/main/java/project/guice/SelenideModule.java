package project.guice;

import com.google.inject.AbstractModule;
import project.utils.Email;
import project.utils.EmailProvider;

public class SelenideModule extends AbstractModule {

	@Override 
	protected void configure() {
		//bindListener(Matchers.any(), new PageListener());

		bind(String.class).annotatedWith(Email.class).toProvider(EmailProvider.class);;
	}
}
