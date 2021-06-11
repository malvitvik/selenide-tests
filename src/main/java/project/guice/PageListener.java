package project.guice;

import java.lang.reflect.Field;

import javax.inject.Inject;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.ProvisionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import project.pages.BasePage;

public class PageListener implements TypeListener {

	@Override
	public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
		Class<?> clazz = typeLiteral.getRawType();

		while (clazz != null) {
			for (Field field : clazz.getDeclaredFields()) {
				if (field.getType().isAssignableFrom(BasePage.class)  &&
				    field.isAnnotationPresent(Inject.class)) {
					typeEncounter.register(new PageMembersInjector<I>(field));
				}
			}
			clazz = clazz.getSuperclass();
		}
		
	}
}
