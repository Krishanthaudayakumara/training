import java.util.InputMismatchException;
import java.util.Scanner;

interface Shape {
    double calculateArea();

    double calculatePerimeter();

    void displayProperties();
}

class Square implements Shape {
    private final double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * sideLength;
    }

    @Override
    public void displayProperties() {
        System.out.println("Side Length=" + (int)sideLength);
    }
}

class Rectangle implements Shape {
    private final double height;
    private final double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return height * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (height + width);
    }

    @Override
    public void displayProperties() {
        System.out.println("Height=" + (int)height);
        System.out.println("Width=" + (int)width);
    }
}

class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void displayProperties() {
        System.out.println("Radius=" + (int)radius);
    }
}

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
