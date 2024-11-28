import java.util.Scanner;

class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);


    public static Number getNumber(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                if (input.contains(".")) {
                    return Double.parseDouble(input);
                } else {
                    return Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }


    public static String getString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input; // Return valid string
            } else {
                System.out.println("Input cannot be empty. Please enter again.");
            }
        }
    }
}
