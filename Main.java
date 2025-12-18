import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        double sum = 0;
        Drawable[] arr = null;
 try (Scanner sc = new Scanner(new File("input.txt"))) {
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                arr = new Drawable[n];

                for (int i = 0; i < n; i++) {
                    String type = sc.next();
                    double value = sc.nextDouble();

                    if (type.equalsIgnoreCase("circle")) {
                        arr[i] = new Circle(value);
                    } else if (type.equalsIgnoreCase("cube")) {
                        arr[i] = new Cube(value);
                    }

                    if (arr[i] instanceof Shape) {
                        sum += ((Shape)arr[i]).getArea();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter("sumAreas.txt"))) {
            pw.println("--- Shapes Report ---");
            if (arr != null) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != null) {

                        String shapeName = arr[i].getClass().getSimpleName();
                        pw.printf("%d. %s Area: %.2f%n", (i + 1), shapeName, ((Shape)arr[i]).getArea());
                    }
                }
            }
            pw.println("---------------------");
            pw.printf("Total Area Sum = %.2f%n", sum);
            pw.println("---------------------");
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }

        if (arr != null) {
            new DrawFrame(arr);
        }
    }
}