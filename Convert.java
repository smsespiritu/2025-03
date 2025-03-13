import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

public class Convert{
        public static void main(String[] args){
    
        /*Open a connection to api and read the result*/
        try {
            URL url = new URL("https://api.spacexdata.com/v3/capsules");
            InputStreamReader stream = new InputStreamReader(url.openStream());
            BufferedReader in = new BufferedReader(stream);
            String str = "";
            String temp = "";
            while ((temp = in.readLine()) != null) {
                str = str + temp;
            }
            System.out.println(str);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
