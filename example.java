package requestPackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class example {

    public static void main(String args[]) throws Exception {
      
      URL url = new URL("https://api.textgears.com/check.php?text=I+is+an+engeneer!&key=DEMO_KEY");
      
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
      
    	try {
        con.setRequestMethod("GET");
      
        //Read request status
        int status = con.getResponseCode();
        
        //Status code : 200, implies success
        System.out.println("Status code : "+status);
        
        BufferedReader in = new BufferedReader(
              new InputStreamReader(con.getInputStream()));
            String inputLine;
            
            //Converting JSON response to String
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            
            //Print the response
            System.out.println("Response : "+ response);

            in.close();
            
      } catch (ProtocolException e) {
        e.printStackTrace();
      }
    }

}
