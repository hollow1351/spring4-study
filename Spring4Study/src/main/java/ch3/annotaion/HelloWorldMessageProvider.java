package ch3.annotaion;

import ch3.MessageProvider;
import org.springframework.stereotype.Service;

//@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "HelloWorld";
    }
}
