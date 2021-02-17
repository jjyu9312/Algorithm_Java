import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

public class PhoneBook {

    public static boolean solution(String[] phoneBook) {
        boolean answer = true;
        for(int i=0; i<phoneBook.length-1; i++) {
            for(int j=i+1; j<phoneBook.length; j++) {
                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
            }
        }
        return answer;
    }


    public boolean solution2(String[] phone_book) {
        String text = String.format(" %s", String.join(" ", phone_book));
        return !Arrays.stream(phone_book)
                .anyMatch(s -> text.split(String.format(" %s", s)).length > 2);
    }


    public static void main(String[] args) throws Exception {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        boolean result = solution(phoneBook);
        System.out.println(result);
    }
}
