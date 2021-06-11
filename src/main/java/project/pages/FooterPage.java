package project.pages;

import javax.inject.Inject;

import project.pages.widgets.SubscriptionWidget;

public class FooterPage extends BasePage {
	
	@Inject SubscriptionWidget subscriptionWidget;
	
	public SubscriptionWidget emailSubscription() {
		return subscriptionWidget;
	}
}
