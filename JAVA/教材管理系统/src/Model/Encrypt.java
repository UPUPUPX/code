package Model;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Encrypt {
    private static final String key = "~!@#$%^&*()<>?/.,";
    private static final Charset charset = StandardCharsets.UTF_8;
    private static final byte[] bytes = key.getBytes(charset);

    public String encode(String enc) {
        byte[] encBytes = enc.getBytes(charset);
        for (int i = 0, size = encBytes.length; i < size; i++) {
            for (byte keyBytes0 : bytes) {
                encBytes[i] = (byte) (encBytes[i] ^ keyBytes0);
            }
        }
        return new String(encBytes);
    }
}

