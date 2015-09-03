package ch3.mi;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class NoCheckFormatMessageReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object bean, Method method, Object[] args) throws Throwable {
        String msg = (String) args[0];
        return "<h3>" + msg + "</h3>";
    }
}
