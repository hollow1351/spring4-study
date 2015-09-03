package ch3.xml;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionInjection {

    private Map<String, Object> map;
    private Properties props;
    private Set set;
    private List list;

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }
    
    public void displayInfo() {
        System.out.println("map=" + map);
        System.out.println("props=" + props);
        System.out.println("set=" + set);
        System.out.println("list=" + list);
    }
    
    public static void main(String[] args) {
        GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
        parent.load("classpath:parent.xml");
        parent.refresh();
        
        GenericXmlApplicationContext c = new GenericXmlApplicationContext();
        c.load("classpath:app-context-xml.xml");
        c.setParent(parent);
        c.refresh();

        c.getBean("injectCollection", CollectionInjection.class).displayInfo();
    }
}
