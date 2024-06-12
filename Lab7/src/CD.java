import java.io.Serializable;

public class CD implements Serializable {
    private String title;
    private String collection;
    private String type;
    private int price;

    public CD() {

    }

    public CD(String title, String collection, String type, int price) {
        this.title = title;
        this.collection = collection;
        this.type = type;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
