package ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimple {

    private String name;
    private int age;
    private float heigth;
    private boolean programmer;
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
        GenericXmlApplicationContext c = new GenericXmlApplicationContext();
        c.load("classpath:app-context-annotation.xml");
        c.refresh();

        System.out.println(c.getBean("injectSimple"));
    }
}
