import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/** JsonSimpleReader
 *     A utility class that reads
 *     files containing JSON data.
 *     The JSON data contains parameters
 *     to construct rectangle objects.
 **/
public final class JsonSimpleReader {

    /** readFile method
     * @param fileName containing a file path
     * @return JSONArray rectangles containing
     *      rectangle object parameters
     **/
    public static JSONArray readFile(String fileName) throws IOException, FileNotFoundException {
        JSONArray rectangles = new JSONArray();
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader(fileName);
        try {
            Object obj = parser.parse(reader);
            JSONObject jsnObj = (JSONObject) obj;
            rectangles = (JSONArray) jsnObj.get("rects");
        }
        catch(FileNotFoundException e) {
            e.getStackTrace();
        }
        catch (Exception e) {
            e.getMessage();
        }
        reader.close();
        return rectangles;
    }
}
