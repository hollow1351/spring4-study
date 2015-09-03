package ch3.annotaion;

import ch3.MessageProvider;
import ch3.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;

//@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    @Autowired
    private MessageProvider messageProvider;

    @Override
    public void render() {
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
