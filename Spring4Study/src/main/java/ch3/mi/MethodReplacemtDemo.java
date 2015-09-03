package ch3.mi;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacemtDemo {

    public static void main(String[] args) {
        GenericXmlApplicationContext c = new GenericXmlApplicationContext();
        c.load("classpath:ch3/replacement.xml");
        c.refresh();
        
        ReplacementTarget replacementTarget = c.getBean("replacementTarget", ReplacementTarget.class);
        ReplacementTarget noCheckReplacementTarget = c.getBean("noCheckReplacementTarget", ReplacementTarget.class);
        ReplacementTarget standardTarget = c.getBean("standardTarget", ReplacementTarget.class);
        
        displayInfo(replacementTarget);
        displayInfo(noCheckReplacementTarget);
        displayInfo(standardTarget);
        
        System.out.println(noCheckReplacementTarget.formatMessage(1L));
    }
    
    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));
        
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        
        for (int i = 0; i < 1000000; i++) {
            target.formatMessage("foo");
        }
        stopWatch.stop();
        
        System.out.println("Time(ms): " + stopWatch.getTotalTimeMillis());
    }
}
