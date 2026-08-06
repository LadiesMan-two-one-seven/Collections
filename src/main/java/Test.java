import properties.EncryptedProperty;
import static properties.EncryptedPropertyKt.encode;

public class Test {

    public static void main(String[] args) {
        EncryptedProperty encryptedProperty = new EncryptedProperty();

        String s = "hello";
        String encode = encode(s);
        System.out.println(encode);
    }
}
