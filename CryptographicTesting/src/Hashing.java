import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Hashing {
    private final String secret ="yopierreyouwannacomeouthereinnewyorkmagicjohnsonianiamtrynahitthis";
    public String getHmac(String message) throws Exception {
        byte[] byteArr = secret.getBytes();
        System.out.println(byteArr);
        SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(keySpec);
        byte[] hmacBytes = mac.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(hmacBytes);
    }
}
