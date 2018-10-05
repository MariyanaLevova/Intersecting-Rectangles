import static org.junit.Assert.*;
import java.awt.Rectangle;
import org.junit.Test;
import java.util.ArrayList;

public class UnitTest {
    @Test
    /** testCheckIntersections
     *     A test for the checkIntersections method
     *     in the IntersectingRectangles class
     **/
    public void testCheckIntersections() {
        Rectangle X = new Rectangle(1,1,2,2);
        Rectangle Y = new Rectangle(2,2,3,3);
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(X);
        rectangles.add(Y);
        ArrayList<Rectangle> output = IntersectingRectangles.checkIntersections(rectangles);
        assertTrue(output.size() == 1);
        assertTrue(output.get(0).x == 2);
        assertTrue(output.get(0).y == 2);
        assertTrue(output.get(0).getWidth() == 1);
        assertTrue(output.get(0).getHeight() == 1);
    }

    @Test
    /** testMultipleCheckIntersections
     *     A test for the checkMultipleIntersections method
     *     in the IntersectingRectangles class
     **/
    public void testMultipleCheckIntersections() {
        Rectangle X = new Rectangle(1,1,5,5);
        Rectangle Y = new Rectangle(2,2,3,3);
        Rectangle Z = new Rectangle(3,3,2,2);
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(X);
        rectangles.add(Y);
        rectangles.add(Z);
        ArrayList<Rectangle> output1 = IntersectingRectangles.checkIntersections(rectangles);
        ArrayList<Rectangle> output2 = IntersectingRectangles.checkMultipleIntersections(rectangles, output1);
        assertTrue(output2.size() == 1);
        assertTrue(output2.get(0).x == 3);
        assertTrue(output2.get(0).y == 3);
        assertTrue(output2.get(0).getWidth() == 2);
        assertTrue(output2.get(0).getHeight() == 2);
    }
}
