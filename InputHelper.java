package customer;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);
    private static final Pattern EMAIL_REGEX = Pattern.compile(
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
        "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
    );
    private static final Pattern PHONE_REGEX = Pattern.compile("^\\d{10}$");
    private static final Pattern NAME_REGEX = Pattern.compile("^[A-Za-z ]+$");

    public static String readName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("⚠️ Name cannot be empty.");
            } else if (!NAME_REGEX.matcher(s).matches()) {
                System.out.println("⚠️ Name must contain only letters and spaces.");
            } else return s;
        }
    }

    public static String readEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("⚠️ Email cannot be empty.");
            } else if (!EMAIL_REGEX.matcher(s).matches()) {
                System.out.println("⚠️ Invalid email format.");
            } else return s;
        }
    }

    public static String readPhone(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!PHONE_REGEX.matcher(s).matches()) {
                System.out.println("⚠️ Phone must be exactly 10 digits (numbers only).");
            } else return s;
        }
    }

    public static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("⚠️ Value cannot be empty.");
            } else return s;
        }
    }

    public static int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String t = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(t);
                if (v > 0) return v;
                System.out.println("⚠️ Enter a number greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Enter a valid integer.");
            }
        }
    }

    public static double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String t = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(t);
                if (v > 0) return v;
                System.out.println("⚠️ Enter a number greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Enter a valid number (e.g., 99.99).");
            }
        }
    }

}
