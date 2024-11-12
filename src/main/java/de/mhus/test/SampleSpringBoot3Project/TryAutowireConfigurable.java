package de.mhus.test.SampleSpringBoot3Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class TryAutowireConfigurable {

//    @Autowired
    private TryAutowireOtherBean tryAutowireOtherBean;

    @Autowired
    public void setTryAutowireOtherBean(TryAutowireOtherBean tryAutowireOtherBean) {
        System.out.println("--- TryAutowireConfigurable: setTryAutowireOtherBean");
        this.tryAutowireOtherBean = tryAutowireOtherBean;
    }

    public boolean isAutowired() {
        return tryAutowireOtherBean != null;
    }
}
