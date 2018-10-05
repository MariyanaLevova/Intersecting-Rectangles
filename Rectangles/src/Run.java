import org.json.simple.JSONArray;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the file name and hit \"Enter\":");
        String fileName = scanner.nextLine();
        try {
            JSONArray rectanglesInput = JsonSimpleReader.readFile(fileName);
            System.out.println("Input:");
            ArrayList<Rectangle> rectangleList = IntersectingRectangles.createRectangles(rectanglesInput);
            System.out.println();
            System.out.println("Intersections:");
            ArrayList<Rectangle> oneIntersectionList = IntersectingRectangles.checkIntersections(rectangleList);
            ArrayList<Rectangle> twoIntersectionsList = IntersectingRectangles.checkMultipleIntersections(rectangleList, oneIntersectionList);
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found =/");
            System.out.println("Please check your file path and try again.");
        }
        catch (Exception e) {
            System.out.println("Something went wrong.");
            e.getCause();
        }
    }
}
