import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static void calculateAndPrintOutput(Shape shape) {
        System.out.println("\n\nShape: " + shape.getClass().getSimpleName() + "\n\nProperties:");
        shape.displayProperties();
        System.out.println("\nArea: " + (int)shape.calculateArea());
        System.out.println("Perimeter: " + (int)shape.calculatePerimeter());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a shape:");
        System.out.println("1. Square");
        System.out.println("2. Rectangle");
        System.out.println("3. Circle");

        try {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // Square
                    try {
                        System.out.print("Enter side length: ");
                        double squareSide = scanner.nextDouble();
                        Square square = new Square(squareSide);
                        calculateAndPrintOutput(square);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number for side length.");
                    }
                    break;

                case 2: // Rectangle
                    try {
                        System.out.print("Enter height: ");
                        double rectangleHeight = scanner.nextDouble();
                        System.out.print("Enter width: ");
                        double rectangleWidth = scanner.nextDouble();
                        Rectangle rectangle = new Rectangle(rectangleHeight, rectangleWidth);
                        calculateAndPrintOutput(rectangle);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter valid numbers for height and width.");
                    }
                    break;

                case 3: // Circle
                    try {
                        System.out.print("Enter radius: ");
                        double circleRadius = scanner.nextDouble();
                        Circle circle = new Circle(circleRadius);
                        calculateAndPrintOutput(circle);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number for radius.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid shape.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number for choice.");
        }

        scanner.close();
    }
}
