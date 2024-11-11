package de.mhus.test.SampleSpringBoot3Project;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@RegisterReflectionForBinding(TryAutowireConfigurable.class)
public class TryAutowireConfigurable {

    @Autowired
    private TryAutowireOtherBean tryAutowireOtherBean;

    public boolean isAutowired() {
        return tryAutowireOtherBean != null;
    }
}
