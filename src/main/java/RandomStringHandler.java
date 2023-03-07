import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class RandomStringHandler implements HttpHandler {

    private String generateRandomString() {
        String randomString = "";
        for(int i = 0; i < 4; i++) {
            int x = new SecureRandom().nextInt();
            randomString = randomString + Integer.toHexString(x);
        }
        return randomString;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String randomString = generateRandomString();
        exchange.sendResponseHeaders(200, randomString.length());
        OutputStream output = exchange.getResponseBody();
        output.write(randomString.getBytes(StandardCharsets.UTF_8));
        output.close();
    }
}
