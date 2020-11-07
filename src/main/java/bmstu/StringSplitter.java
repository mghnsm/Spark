package bmstu;

public class StringSplitter {
    public static String[] split(String inputString) {
        String[] splittedString = inputString.split(",");
        for (int i = 0; i < splittedString.length; i++) {
            splittedString[i] = splittedString[i].replaceAll("\"", "");
        }
        return splittedString;
    }

    public static String[] removeQuotes(String inputString) {
        
    }
}
