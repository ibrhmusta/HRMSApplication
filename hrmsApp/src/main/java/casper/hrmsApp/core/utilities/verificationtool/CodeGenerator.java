package casper.hrmsApp.core.utilities.verificationtool;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CodeGenerator {
    public static String generateUuidCode() {
        return UUID.randomUUID().toString();
    }
}
