package bmstu;

public class StringSplitter {
    private String[] splitted;

    public StringSplitter(String str) {
        splitted = str.split(",");
    }

    public String[] getSplitted() {
        return splitted;
    }
}
