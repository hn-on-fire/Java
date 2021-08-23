/**
 *
 * @author Harsh
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AccessFile {

    BufferedReader bw;
    String retty = "";

    public String getLine() {
        try {
            bw = new BufferedReader(new FileReader("/home/pi/Desktop/print.txt"));
            String temp;
            while ((temp = bw.readLine()) != null) {
                retty += temp;
            }
            bw.close();
            return retty;

        } catch (IOException ex) {
            //ex.printStackTrace();
            return "A System File was Deleted.Please Reinstall the Software.";
        }
    }
