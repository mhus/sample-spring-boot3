package de.mhus.test.SampleSpringBoot3Project;

public class AnswerBean {
    private static final String template = "Hello hello, %s!";

    public Greeting answer(long count, String name) {
        return new Greeting(count, String.format(template, name));
    }
}
