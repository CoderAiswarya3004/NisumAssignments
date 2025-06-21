interface StringUtils {
    static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    static String capitalize(String s) {
        if (isNullOrEmpty(s)) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}

public class StringUtilsTest {
    public static void main(String[] args) {
        System.out.println(StringUtils.isNullOrEmpty("")); // true
        System.out.println(StringUtils.capitalize("java")); // Java
    }
}
