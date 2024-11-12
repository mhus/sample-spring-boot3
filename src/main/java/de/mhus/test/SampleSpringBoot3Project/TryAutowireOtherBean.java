package de.mhus.test.SampleSpringBoot3Project;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class TryAutowireOtherBean {

    @PostConstruct
    public void init() {
        System.out.println("--- TryAutowireOtherBean: PostConstruct");
    }
}
