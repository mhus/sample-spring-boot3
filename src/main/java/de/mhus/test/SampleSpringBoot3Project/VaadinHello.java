package de.mhus.test.SampleSpringBoot3Project;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Route(value = "/hello")
public class VaadinHello extends VerticalLayout {

    public VaadinHello() {
        add(new Text("Hello, World!"));
        add(new Button("Click me", e -> {
            LOGGER.info("Click {}", e);
            add(new Text("Clicked! "));
        }));
    }

}
