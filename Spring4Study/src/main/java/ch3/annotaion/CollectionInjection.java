package ch3.annotaion;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("injectCollection")
public class CollectionInjection {

    @Resource(name = "map")
    private Map<String, Object> map;
    @Resource(name = "props")
    private Properties props;
    @Resource(name = "set")
    private Set set;
    @Resource(name = "list")
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
        parent.load("classpath:ch3/parent.xml");
        parent.refresh();
        
        GenericXmlApplicationContext c = new GenericXmlApplicationContext();
        c.load("classpath:ch3/app-context-annotation.xml");
        c.setParent(parent);
        c.refresh();

        c.getBean("injectCollection", CollectionInjection.class).displayInfo();
    }
}
