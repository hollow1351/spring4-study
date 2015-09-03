package ch3.annotaion;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectSimple")
public class InjectSimple {

    @Value("#{injectConfig.name}")
    private String name;
    @Value("#{injectConfig.age - 2}")
    private int age;
    @Value("#{injectConfig.heigth}")
    private float heigth;
    @Value("#{injectConfig.programmer}")
    private boolean programmer;
    @Value("#{injectConfig.ageInSeconds}")
    private long ageInSeconds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeigth() {
        return heigth;
    }

    public void setHeigth(float heigth) {
        this.heigth = heigth;
    }

    public boolean isProgrammer() {
        return programmer;
    }

    public void setProgrammer(boolean programmer) {
        this.programmer = programmer;
    }

    public long getAgeInSeconds() {
        return ageInSeconds;
    }

    public void setAgeInSeconds(long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
    }

    @Override
    public String toString() {
        return "InjectSimple{" + "name=" + name + ", age=" + age + ", heigth=" + heigth + ", programmer=" + programmer + ", ageInSeconds=" + ageInSeconds + '}';
    }
    
    public static void main(String[] args) {
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:ch3/parent.xml");
        parent.refresh();
        
        GenericXmlApplicationContext c = new GenericXmlApplicationContext();
        c.load("classpath:ch3/app-context-xml.xml");
        c.setParent(parent);
        c.refresh();

        System.out.println(c.getBean("injectSimple"));
    }
}
