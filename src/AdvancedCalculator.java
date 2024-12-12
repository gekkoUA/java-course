import java.util.Scanner;

public class AdvancedCalculator {
    private CalculatorOperations operations;
    private Scanner scanner;

    public AdvancedCalculator() {
        this.operations = new CalculatorOperations();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        AdvancedCalculator calculator = new AdvancedCalculator();
        calculator.run();
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            if (choice == 6) {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }

            performOperation(choice);
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n--- Advanced Calculator ---");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }

    private int getUserChoice() {
        return scanner.nextInt();
    }

    private void performOperation(int choice) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        double result = 0;
        switch (choice) {
            case 1:
                result = operations.add(num1, num2);
                break;
            case 2:
                result = operations.subtract(num1, num2);
                break;
            case 3:
                result = operations.multiply(num1, num2);
                break;
            case 4:
                try {
                    result = operations.divide(num1, num2);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }
                break;
            case 5:
                result = operations.power(num1, num2);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.printf("Result: %.2f%n", result);
    }
}

class CalculatorOperations {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}