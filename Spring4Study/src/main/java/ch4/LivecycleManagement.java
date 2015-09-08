package ch4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;

public class LivecycleManagement implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware {
    
    public void setSomeProperty(String val) {
        System.out.println("setSomeProperty: " + val);
    }
    
    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName: " + name);
    }
    
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        System.out.println("setApplicationContext: " + ctx);
    }

    @PostConstruct
    public void annotationInit() {
        System.out.println("@PostConstruct");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet");
    }
    
    public void initMethod() {
        System.out.println("initMethod");
    }
    
    @PreDestroy
    public void annotationDestroy() {
        System.out.println("@PreDestroy");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy");
    }
    
    public void destroyMethod() {
        System.out.println("destroyMethod");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("ch4/livecycleManagement.xml");
        ctx.registerShutdownHook();//1 необязательно если есть 2 или выполняется в контейнере сервлетов
        ctx.refresh();
        ctx.destroy();//2 необязательно если есть 1
    }
}
