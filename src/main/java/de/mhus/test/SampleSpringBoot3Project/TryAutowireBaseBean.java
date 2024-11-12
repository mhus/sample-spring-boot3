package de.mhus.test.SampleSpringBoot3Project;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
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

        inspectBeanFactory();
        autowireBean(configurableObject);
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

    private void inspectBeanFactory() {
        // inspect bean factory
        var bf = applicationContext.getAutowireCapableBeanFactory();
        System.out.println("Bean Factory Class: " +  bf.getClass());
        try {
            var m = ReflectionUtils.findMethod(DefaultListableBeanFactory.class, "getBeanPostProcessorCache");
            m.setAccessible(true);
            var cache = m.invoke(bf);
            var f = cache.getClass().getDeclaredField("instantiationAware");
            f.setAccessible(true);
            System.out.println("hasInstantiationAwareBeanPostProcessors: " + f.get(cache));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autowireBean(Object existingBean) {
        applicationContext.getAutowireCapableBeanFactory().autowireBean(existingBean);
//        var bf = new DefaultListableBeanFactory(applicationContext.getAutowireCapableBeanFactory());
//        bf.autowireBean(existingBean);
    }


}
