package bmstu;

public class StringSplitter {
    public static String[] split(String input) {
        String[] splitted = input.split(",");
        for (int i = 0; i < splitted.length; i++) {
            splitted[i] = splitted[i].replaceAll("\"", "");
        }
        return splitted;
    }
}
