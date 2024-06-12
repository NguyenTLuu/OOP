import java.io.*;
import java.util.ArrayList;

public final class CD_Store implements Serializable {
    private static CD_Store instance;
    private ArrayList<CD> cdList = new ArrayList<>();
    private ArrayList<CD> cdResultList = new ArrayList<>();
    private String filePath;

    private CD_Store() {

    }

    public static CD_Store getInstance() {
        if (instance == null) {
            instance = new CD_Store();
        }
        return instance;
    }

    public void getFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void searchCD(String keyword) {
        cdResultList.clear();
        for (CD cd : cdList) {
            if (cd.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                cdResultList.add(cd);
            }
        }
    }

    public boolean addCD(CD cd) {
        for (CD c : cdList) {
            if (cd.getTitle().equalsIgnoreCase(c.getTitle()))
                return false;
        }
        cdList.add(cd);
        return true;
    }

    public void deleteCD(String title) {
        for (CD c : cdList) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                cdList.remove(c);
                break;
            }
        }
        if (filePath != null) {
            outputToFile(filePath);
        } else {
            System.out.println("filePath is not set. Cannot update file.");
        }
    }

    public ArrayList<CD> getCdList() {
        return cdList;
    }

    public ArrayList<CD> getCdResultList() {
        return cdResultList;
    }

    public void outputResultToFile(String location) {
        try {
            FileOutputStream fos = new FileOutputStream(location);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cdResultList);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
            e.printStackTrace();
        }
    }

    public void outputToFile(String location) {
        try {
            FileOutputStream fos = new FileOutputStream(location);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cdList);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
            e.printStackTrace();
        }
    }

    public void readFromFile(String location) {
        try {
            FileInputStream fis = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(fis);
            cdList = (ArrayList<CD>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
