
package randompassword;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class RandomPassword {
    
    private static SecureRandom sr = new SecureRandom();
    public static void main(String[] args) {
        
        String bc = "QWERTYUIOPÐÜÝÞLKJHGFDSAZXCVBNMÖÇ"; //lowercase
        String lc = "qwertyuýopðüiþlkjhgfdsazxcvbnmöç"; //uppercase
        String symbols = "!@#$%^&*()-_=+[]{}|';:,.<>?";
        String digits = "0123456789";
        int pl = sr.nextInt(12, 16);         //passwordlenght (min: 12, max: 15)
        
        ArrayList<Character> ar = new ArrayList<>();
        
        //Her tür karakterden en az 1 tane alýyoruz.
        ar.add(randomchar(bc));
        ar.add(randomchar(lc));
        ar.add(randomchar(symbols));
        ar.add(randomchar(digits));
        
        for (int i = 0; i < pl - 4; i++) {
            int r = sr.nextInt(4);
                if (r == 0)
                    ar.add(randomchar(bc));
                if (r == 1)
                    ar.add(randomchar(lc));
                if (r == 2)
                    ar.add(randomchar(symbols));
                if (r == 3)
                    ar.add(randomchar(digits));
        }
        
        System.out.println("Password: " + passwordcreater(ar));  //print password
        
    }
    
    private static Character randomchar(String s){
        int i = sr.nextInt(s.length());
        Character c = s.charAt(i);
        return c;
    }
    
    private static String passwordcreater (ArrayList<Character> ar){
        Collections.shuffle(ar);
        String password = "";
        for (Character c : ar) {
            password += c;
        }
        return password;
    }
}
