import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Hash {

//this program will hash the password of a user

    public static String sha256(String s) {
        // if SHA-256 wont be found it will catch (NoSuchAlgorithmException e) and nothing will break
        try {

            //we call the hashing function  in to 'md'
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //the String will be transformed into byte's and then thay will get hased and stored into 'result'
            byte[] result = md.digest(s.getBytes(StandardCharsets.UTF_8));

            //because we need to transform byte's into String we use StringBuilder
            StringBuilder sb = new StringBuilder(result.length * 2);

            //this loop well go throu every byte and String it
            for (byte b : result) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }

    public static void main(String[] args){
        
        System.out.print(sha256("a"));
    }
}
