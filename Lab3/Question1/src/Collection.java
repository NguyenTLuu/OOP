

public class Collection {
    private String collectionName;

    public Collection(String collectionName) {
        this.collectionName = collectionName;
    }

    public Collection() {

    }

    public String toString(){
        return collectionName;
    }

    public int compareTo(Collection collection) {
        return this.collectionName.compareTo(collection.collectionName);
    }
    public String getCollectionName() {
        return collectionName;
    }
}
