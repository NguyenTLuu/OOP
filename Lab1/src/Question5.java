import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Question5 {
    private ArrayList<Integer> array;
    private ArrayList<Integer> array1 = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public Question5() {

    }

    public Question5(ArrayList<Integer> array) {
        this.array = array;
    }


    public void input() {
        array = new ArrayList<>();
        int n;
        System.out.print("Length of Array: ");
        n = sc.nextInt();
        int m;
        for (int i = 1; i <= n; i++) {
            m = sc.nextInt();
            array.add(m);
        }
    }

    public boolean remove() {
        System.out.print("Remove number: ");
        int removeNum = sc.nextInt();
        if (array.contains(removeNum)) {
            array.remove(Integer.valueOf(removeNum));
            return true;
        } else
            return false;
    }

    public void output() {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }

    public void insert() {
        System.out.print("Insert position: ");
        int pos = sc.nextInt();
        System.out.print("Insert value: ");
        int val = sc.nextInt();
        for (int i = 0; i < pos; i++) {
            array1.add(array.get(i));
        }
        array1.add(val);

        for (int i = pos; i < array.size() - 1; i++) {
            array1.add(array.get(i));
        }

    }

    public void output1() {
        for (int i = 0; i < array1.size(); i++) {
            System.out.print(array1.get(i) + " ");
        }
    }

    public void duplicateCheck() {
        for (int i = 0; i < array.size() - 1; i++)
            for (int j = i + 1; j < array.size(); j++)
                if (array.get(i) == array.get(j) && (i != j))
                    System.out.print(array.get(i) + " ");
    }

    public void removeDulicate() {
        for (int i = 0; i < array.size() - 1; i++)
            for (int j = i + 1; j < array.size(); j++)
                if (array.get(i) == array.get(j) && (i != j)) {
                    array.remove(i);
                    j--;
                }
    }
}
