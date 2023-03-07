package reverseString;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {

        String reversedWord = "";

        System.out.print("Please enter word: ");

        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        for(int i = word.length() - 1; i >= 0; i--){
            reversedWord = reversedWord + word.charAt(i);
        }

        System.out.println("The reverse of \"" + word + "\" is \"" + reversedWord + "\".");

        if(word.equals(reversedWord)){
            System.out.println("The word you entered is a palindrome word!");
        }
    }
}
