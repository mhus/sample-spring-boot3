package de.mhus.test.SampleSpringBoot3Project;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class TryAutowireBaseBean {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init() {
        System.out.println(">>> TryAutowireBaseBean: PostConstruct");
        var configurableObject = new TryAutowireConfigurable();

        applicationContext.getAutowireCapableBeanFactory().autowireBean(configurableObject);
        System.out.println("*** TryAutowireBaseBean: TryAutowireConfigurable autowired " + configurableObject.isAutowired());

        System.out.println("<<< TryAutowireBaseBean: PostConstruct");
        proveReflectionIsActive(configurableObject);
    }

    private void proveReflectionIsActive(TryAutowireConfigurable configurableObject) {
        System.out.println(">>> TryAutowireBaseBean: proveReflectionIsActive");
        try {
            var m = ReflectionUtils.findMethod(TryAutowireConfigurable.class, "setTryAutowireOtherBean", TryAutowireOtherBean.class);
            m.setAccessible(true);
            m.invoke(configurableObject, applicationContext.getBean(TryAutowireOtherBean.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*** TryAutowireBaseBean: TryAutowireConfigurable autowired " + configurableObject.isAutowired());
        System.out.println("<<< TryAutowireBaseBean: proveReflectionIsActive");
    }


}
