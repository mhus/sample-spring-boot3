package de.mhus.test.SampleSpringBoot3Project;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class MyRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        System.out.println("MyRuntimeHints: registerHints");
        hints.reflection().registerType(TryAutowireConfigurable.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INVOKE_DECLARED_METHODS,MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DefaultListableBeanFactory.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INVOKE_DECLARED_METHODS,MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(AutowiredAnnotationBeanPostProcessor.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INVOKE_DECLARED_METHODS,MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(AbstractBeanFactory.class, MemberCategory.DECLARED_CLASSES, MemberCategory.DECLARED_FIELDS, MemberCategory.INVOKE_DECLARED_METHODS,MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
    }
}
