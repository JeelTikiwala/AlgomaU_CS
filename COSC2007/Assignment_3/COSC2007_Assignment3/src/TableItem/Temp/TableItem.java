package TableItem.Temp;

public class TableItem {
    private String key;
    private String value;

    public TableItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Key: " + key + ", Value: " + value;
    }
}
