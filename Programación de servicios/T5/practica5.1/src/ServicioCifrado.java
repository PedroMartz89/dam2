import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ServicioCifrado {
    public static SecretKeySpec generarClave(String password) {
        byte[] keyBytes = Arrays.copyOf(password.getBytes(StandardCharsets.UTF_8), 16);
        return new SecretKeySpec(keyBytes, "AES");
    }
    public static String calcularHash(Path archivo) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(Files.readAllBytes(archivo));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static byte[] procesarAES(byte[] datos, SecretKeySpec key, int modo) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(modo, key);
        return cipher.doFinal(datos);
    }

}
