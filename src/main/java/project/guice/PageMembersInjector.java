package project.guice;

import java.lang.reflect.Field;

import com.codeborne.selenide.Selenide;
import com.google.inject.MembersInjector;
import com.google.inject.spi.InjectionListener;

public class PageMembersInjector<I>
		implements MembersInjector<I> {

	private final Field field;

	public PageMembersInjector(Field field) {
		this.field = field;
	}


	@Override
	public void injectMembers(I type) {
		try {
			field.set(type, Selenide.page(field.getType()));
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
