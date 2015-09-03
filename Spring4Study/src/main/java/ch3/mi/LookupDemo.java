package ch3.mi;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext c = new GenericXmlApplicationContext();
        c.load("classpath:ch3/lookup.xml");
        c.refresh();
        
        displayInfo(c.getBean("standard", DemoBean.class));
        displayInfo(c.getBean("abstract", DemoBean.class));
    }
    
    private static void displayInfo(DemoBean demoBean) {
        MyHelper helper1 = demoBean.getMyHelper();
        MyHelper helper2 = demoBean.getMyHelper();
        System.out.println("helper1 == helper2: " + (helper1 == helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 1000000; i++) {
            demoBean.getMyHelper().doSomething();
        }
        stopWatch.stop();
        System.out.println("Time(ms): " + stopWatch.getTotalTimeMillis());
    }
}
