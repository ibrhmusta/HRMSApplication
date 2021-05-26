package casper.hrmsApp.core.utilities.email;

import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.stereotype.Component;

@Component
public class EmailSender implements EmailSenderService{

    @Override
    public void send(String body) {
        System.out.println(body);
    }
}
