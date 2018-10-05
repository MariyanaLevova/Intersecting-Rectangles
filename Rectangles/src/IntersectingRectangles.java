import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/** IntersectingRectangles
 *     A utility class that creates
 *     rectangles and can check for
 *     intersections between them.
 **/
public final class IntersectingRectangles {
    private static int counter = 1;

    /** readFile method; creates rectangles
     * @param rectangles a set of parameters to create rectangles
     * @return ArrayList<Rectangle> listOfRectangles containing
     *      rectangle objects
     **/
    public static ArrayList<Rectangle> createRectangles(JSONArray rectangles) {
        ArrayList<Rectangle> listOfRectangles = new ArrayList<>();
        int k = 1;
        for (Object r : rectangles) {
            long x, y, w, h;
            try {
                JSONObject R = (JSONObject) r;
                x = (Long) R.get("x");
                y = (Long) R.get("y");
                w = (Long) R.get("w");
                h = (Long) R.get("h");
                int X = (int) x;
                int Y = (int) y;
                int W = (int) w;
                int H = (int) h;
                Rectangle validRectangle = new Rectangle(X, Y, W, H);
                System.out.println(k++ + ": " + "Rectangle at (" + validRectangle.x +"," + validRectangle.y + "), w=" +
                        (int) validRectangle.getWidth() + ", h=" + (int) validRectangle.getHeight() + ".");

                listOfRectangles.add(validRectangle);
            }
            catch (Exception e) {
                e.getMessage();
            }
        }
        return listOfRectangles;
    }

    /** checkIntersections method; checks for a single intersection between two rectangles
     * @param rectangles a set of rectangle objects
     * @return  ArrayList<Rectangle> validIntersections containing
     *       Rectangle objects that depict intersections between
     *       rectangle objects from the input parameter
     **/
    public static ArrayList<Rectangle> checkIntersections(ArrayList<Rectangle> rectangles) {
        ArrayList<Rectangle> validIntersections = new ArrayList<>();
        for(int i = 0; i < rectangles.size() && i < 10; i++) {
            for(int j = i + 1; j < rectangles.size() && j < 10; j++){
                Rectangle intersection = new Rectangle(rectangles.get(i).intersection(rectangles.get(j)));
                if(intersection.getHeight() > 0 && intersection.getWidth() > 0) {
                    System.out.println(counter++ + ": Between rectangle " + (i + 1) + " and " + (j + 1) + " at (" + intersection.x +
                            ","+ intersection.y + "), " + "w=" + (int) intersection.getWidth() + ", h=" +
                            (int) intersection.getHeight() + ".");
                    validIntersections.add(intersection);
                }
            }
        }
        return validIntersections;
    }

    /** checkMultipleIntersections method; checks for multiple intersections between rectangles
     * @param originalRectangles a set of rectangle objects
     * @param intersections a set of rectangle objects
     * @return  ArrayList<Rectangle> collisions containing
     *       Rectangle objects that depict intersections between
     *       rectangle objects from the input parameters
     **/
    public static ArrayList<Rectangle> checkMultipleIntersections(ArrayList<Rectangle> originalRectangles, ArrayList<Rectangle> intersections) {
        ArrayList<Rectangle> multipleIntersections = new ArrayList<>();
        for(int i = 0; i < intersections.size(); i++) {
            for(int j = i + 1; j < intersections.size(); j++){
                Rectangle intersection = new Rectangle(intersections.get(i).intersection(intersections.get(j)));
                if(intersection.getHeight() > 0 && intersection.getWidth() > 0) {
                    multipleIntersections.add(intersection);
                }
            }
        }
        Set<Rectangle> set = new HashSet<>();
        for (Rectangle r : multipleIntersections) {
            set.add(r);
        }
        ArrayList<Rectangle> collisions = new ArrayList<Rectangle>(set);
        if(collisions.size() > 0) {
            int k;
            for(k = 0; k < collisions.size(); k++){
                ArrayList<Integer> matched = new ArrayList<>();
                for(int j = 0; j < originalRectangles.size(); j++) {
                    if(originalRectangles.get(j).contains(collisions.get(k))) {
                        matched.add((j+1));
                    }
                }
                System.out.println(counter++ + ": Between " + matched.toString().replace("[","").replace("]","") + " at (" + collisions.get(k).x +
                        "," + collisions.get(k).y + "), " + "w=" + (int) collisions.get(k).getWidth() + ", h=" +
                        (int) collisions.get(k).getHeight() + ".");
            }
        }
        return collisions;
    }
}

