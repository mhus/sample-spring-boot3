package de.mhus.test.SampleSpringBoot3Project;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TryAutowireBaseBean {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    private void init() {
        System.out.println("TryAutowireBaseBean: PostConstruct");
        var configurableObject = new TryAutowireConfigurable();
        applicationContext.getAutowireCapableBeanFactory().autowireBean(configurableObject);
        System.out.println("TryAutowireBaseBean: TryAutowireConfigurable autowired " + configurableObject.isAutowired());
    }


}
