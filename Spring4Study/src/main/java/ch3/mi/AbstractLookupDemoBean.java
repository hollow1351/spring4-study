package ch3.mi;

public abstract class AbstractLookupDemoBean implements DemoBean {

    @Override
    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomething();
    }
}
