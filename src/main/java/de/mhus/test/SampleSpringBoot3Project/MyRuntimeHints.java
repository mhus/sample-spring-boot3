package de.mhus.test.SampleSpringBoot3Project;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class MyRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        System.out.println("MyRuntimeHints: registerHints");
        hints.reflection().registerType(TryAutowireConfigurable.class, MemberCategory.DECLARED_FIELDS, MemberCategory.INVOKE_DECLARED_METHODS,MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
    }
}
