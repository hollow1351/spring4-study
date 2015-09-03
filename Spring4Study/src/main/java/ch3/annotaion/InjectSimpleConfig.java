package ch3.annotaion;

import org.springframework.stereotype.Component;

@Component("injectConfig")
public class InjectSimpleConfig {

    private String name = "John Smith";
    private int age = 35;
    private float heigth = 1.78F;
    private boolean programmer = true;
    private long ageInSeconds = 5151651651L;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getHeigth() {
        return heigth;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public long getAgeInSeconds() {
        return ageInSeconds;
    }
}
