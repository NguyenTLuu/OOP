import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
    private String word;
    private String meaning;
    private TreeMap<String, String> dictionary = new TreeMap<>();

    public Dictionary(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public Dictionary() {
    }

    static Scanner sc = new Scanner(System.in);

    public void input10words() {
        dictionary.put("tall", "cao");
        dictionary.put("short", "thấp");
        dictionary.put("thin", "ốm");
        dictionary.put("fat", "mập");
        dictionary.put("handsome", "đẹp trai");
        dictionary.put("pretty", "xinh đẹp");
        dictionary.put("ugly", "xấu");
        dictionary.put("weak", "yếu");
        dictionary.put("strong", "mạnh");
        dictionary.put("annihilate", "xóa sổ");
    }

    public void checkKey() {
        System.out.print("Enter the word want to check: ");
        String checkKey = sc.nextLine();
        if (dictionary.containsKey(checkKey))
            System.out.println(checkKey + " is exist in the dictionary");
        else
            System.out.println(checkKey + " is not exist in the dictionary");
    }

    public void findMeaning() {
        System.out.print("Enter the word want to find meaning: ");
        String findMeaning = sc.nextLine();
        if (dictionary.containsKey(findMeaning))
            System.out.println(findMeaning + ": " + dictionary.get(findMeaning));
        else
            System.out.println(findMeaning + " is not exist in the dictionary");
    }

    public void lookupWords() {
        System.out.print("Enter the number of words want to look up: ");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> lookupWords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the word want to look up: ");
            String word = sc.nextLine();
            lookupWords.add(word);
        }
        for (String word : lookupWords)
            if (dictionary.containsKey(word))
                System.out.println(word + ": " + dictionary.get(word));
            else
                System.out.println(word + " is not exist in the dictionary");

    }
}
