package ch3.mi;

public class StandardLookupDemoBean implements DemoBean {
    
    private MyHelper helper;

    @Override
    public MyHelper getMyHelper() {
        return helper;
    }

    public void setHelper(MyHelper helper) {
        this.helper = helper;
    }

    @Override
    public void someOperation() {
        helper.doSomething();
    }
}
