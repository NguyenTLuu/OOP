import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question6 {
    private String str;

    public Question6(String str) {
        this.str = str;
    }


    public int length() {
        return str.length();
    }

    public void wordsCounter() {
        int spaceCounter = 0;
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                spaceCounter++;
            }
        }
        int wordsCounter = spaceCounter + 1;
        System.out.println(wordsCounter);
    }

    public void concatenateString(String a){
        System.out.println(str.concat(a));
    }
    public void palindromeCheck(){
        ArrayList<Character> charList = new ArrayList<Character>();
        for (char c : str.toCharArray()) {
            charList.add(c);
        }
        ArrayList<Character> duplicatedList = new ArrayList<>(charList);
        Collections.reverse(charList);
        if (charList.equals(duplicatedList)){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
}
