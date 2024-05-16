import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CD {
    private String id;
    private Collection collection;
    private String type;
    private String title;
    private int price;
    private int yearRelease;
    private ArrayList<CD> cdList = new ArrayList<>();

    public CD(String id, Collection collection, String type, String title, int price, int yearRelease) {
        this.id = id;
        this.collection = collection;
        this.type = type;
        this.title = title;
        this.price = price;
        this.yearRelease = yearRelease;
    }

    public CD() {

    }

    public void inputCD() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        this.id = sc.nextLine();
        System.out.print("Enter Collection: ");
        this.collection = new Collection(sc.nextLine());
        System.out.print("Enter Type: ");
        this.type = sc.nextLine();
        System.out.print("Enter Title: ");
        this.title = sc.nextLine();
        System.out.print("Enter Price: ");
        this.price = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Year Release: ");
        this.yearRelease = sc.nextInt();
        sc.nextLine();
    }

    public void inputCdlist() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of CDs: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            CD cd = new CD();
            cd.inputCD();
            cdList.add(cd);
        }
    }

    public void searchByTittle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search by Title: ");
        String searchTitle = sc.nextLine();
        for (CD cd : cdList) {
            if (cd.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                cd.displayCD();
                System.out.println();
            }
        }
    }

    public void searchByCollection() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search by Collection: ");
        String searchCollection = sc.nextLine();
        for (CD cd : cdList) {
            if (cd.collection.getCollectionName().toLowerCase().contains(searchCollection.toLowerCase())) {
                cd.displayCD();
                System.out.println();
            }
        }

    }

    public void searchByType() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Search by Type: ");
        String searchType = sc.nextLine();
        for (CD cd : cdList) {
            if (cd.getType().toLowerCase().contains(searchType.toLowerCase())) {
                cd.displayCD();
            }
        }
    }

    public void deleteCD() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID delete: ");
        String cdId = sc.nextLine();
        for (int i = 0; i < cdList.size(); i++) {
            if (cdId.equals(cdList.get(i).getId()))
                cdList.remove(i);
        }
    }

    public void editCD() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID edit: ");
        String cdId = sc.nextLine();
        for (int i = 0; i < cdList.size(); i++) {
            if (cdId.equals(cdList.get(i).getId())) {
                System.out.print("Enter new Collection: ");
                cdList.get(i).setCollection(new Collection(sc.nextLine()));
                System.out.print("Enter new Type: ");
                cdList.get(i).setType(sc.nextLine());
                System.out.print("Enter new Title: ");
                cdList.get(i).setTitle(sc.nextLine());
                System.out.print("Enter new Price: ");
                cdList.get(i).setPrice(sc.nextInt());
                System.out.print("Enter new Year Release: ");
                cdList.get(i).setYearRelease(sc.nextInt());
            }
        }
    }

    public void outputCDList() {
        for (CD cd : cdList)
            cd.displayCD();
    }

    public void sortByYearRelease() {
        Collections.sort(cdList, compareByReleaseYear);
        for (CD cd : cdList)
            cd.displayCD();
    }

//    static Comparator<CD> compareByTitle = new Comparator<CD>() {
//        public int compare(CD cd1, CD cd2) {
//            return cd1.getTitle().compareTo(cd2.getTitle());
//        }
//    };
//
//    static Comparator<CD> compareByCollection = new Comparator<CD>() {
//        public int compare(CD cd1, CD cd2) {
//            return cd1.getCollection().compareTo(cd2.getCollection());
//        }
//    };
//
//    static Comparator<CD> compareByType = new Comparator<CD>() {
//        public int compare(CD cd1, CD cd2) {
//            return cd1.getType().compareTo(cd2.getType());
//        }
//    };

    static Comparator<CD> compareByReleaseYear = new Comparator<CD>() {
        public int compare(CD cd1, CD cd2) {
            if (cd1.getYearRelease() > cd2.getYearRelease()) return 1;
            if (cd1.getYearRelease() < cd2.getYearRelease()) return -1;
            return 0;
        }
    };

    public void displayCD() {
        System.out.println("ID: " + id);
        System.out.println("Collection: " + collection);
        System.out.println("Type: " + type);
        System.out.println("Title: " + title);
        System.out.println("Year Release: " + yearRelease);
    }

    public String getTitle() {
        return title;
    }

    public Collection getCollection() {
        return collection;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public void displayMenu() {
        System.out.println("--------------------");
        System.out.println("1. Add CD");
        System.out.println("2. Search CD by title");
        System.out.println("3. Search CDs by collection (game/movie/music)");
        System.out.println("4. Search CDs by type (audio/video)");
        System.out.println("5. Delete CD by CD Id");
        System.out.println("6. Edit CD information by Id");
        System.out.println("7. Display all CDs");
        System.out.println("8. Sort the CD list ascending by year of release");
        System.out.println("9. Exit");
    }

    public void option() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (choice != 9) {
            displayMenu();
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    inputCdlist();
                    break;
                case 2:
                    searchByTittle();
                    break;
                case 3:
                    searchByCollection();
                    break;
                case 4:
                    searchByType();
                    break;
                case 5:
                    deleteCD();
                    break;
                case 6:
                    editCD();
                    break;
                case 7:
                    outputCDList();
                    break;
                case 8:
                    sortByYearRelease();
                    break;
                case 9:
                    break;
            }
        }
    }
}

