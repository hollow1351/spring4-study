package ch4;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PkeyFactory implements FactoryBean<Integer> {

    private int pkey = 0;
    private int offset;

    @Override
    public Integer getObject() throws Exception {
        return pkey += offset;
    }

    @Override
    public Class<Integer> getObjectType() {
        return Integer.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public static class CustomFactory {

        public int createPkey() {
            return 15;
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("ch4/factoryBeans.xml");
        ctx.refresh();

        System.out.println("int1 = " + ctx.getBean("int1"));
        System.out.println("int2 = " + ctx.getBean("int2"));
        System.out.println("int3 = " + ctx.getBean("int3"));
        System.out.println("int4 = " + ctx.getBean("int4"));

        System.out.println("&int1 = " + ctx.getBean("&int1"));
        System.out.println("&int2 = " + ctx.getBean("&int2"));
    }
}
