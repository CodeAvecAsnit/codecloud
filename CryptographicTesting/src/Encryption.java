import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encryption {
    private static final String SECRET_KEY = "HelloWorld120967";//16 chars in total innit
    private static final String INIT_VECTOR = "RandomVectorInit";//same 16 chars is 128 bits

    public static String encrypt(String plainText) throws Exception{
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));//can change to UTF-16 more rounds
        SecretKeySpec spec = new SecretKeySpec((SECRET_KEY.getBytes(StandardCharsets.UTF_8)),"AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE,spec,iv);
        byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String cipherText) throws Exception{
        IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec spec = new SecretKeySpec((SECRET_KEY.getBytes(StandardCharsets.UTF_8)),"AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE,spec,iv);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(decrypted);
    }

}
