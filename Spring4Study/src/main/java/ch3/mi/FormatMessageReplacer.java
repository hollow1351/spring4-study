package ch3.mi;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

public class FormatMessageReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object bean, Method method, Object[] args) throws Throwable {
        if (isFormatMessageMethod(method)) {
            String msg = (String) args[0];
            return "<h2>" + msg + "</h2>";
        } else {
            throw new IllegalArgumentException("Unable to reimplement " + method.getName());
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        return method.getParameterTypes().length == 1
                && "formatMessage".equals(method.getName())
                && method.getReturnType() == String.class
                && method.getParameterTypes()[0] == String.class;
    }
}
