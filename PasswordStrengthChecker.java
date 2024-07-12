import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecial = true;
            }
        }

        if (length >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecial) {
            System.out.println("Password strength: Strong");
        } else if (length >= 6 && (hasUppercase || hasLowercase) && (hasDigit || hasSpecial)) {
            System.out.println("Password strength: Medium");
        } else {
            System.out.println("Password strength: Weak");
        }

        scanner.close();
    }
}
