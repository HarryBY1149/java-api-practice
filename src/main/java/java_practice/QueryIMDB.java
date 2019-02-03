package java_practice;

import java.io.BufferedReader;
// import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
// import java.util.Arrays;

// import javax.net.ssl.HttpsURLConnection;


public class QueryIMDB {
    private final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
   
    public static void main(String[] args ) throws Exception {
        String params = String.join("%20", args);
        QueryIMDB req = new QueryIMDB();
        System.out.println("Testing GET request");
        req.sendGET(params);
    }

    private void sendGET(String args) throws Exception {
        String query = "http://www.omdbapi.com/?t="+args+"&i=tt3896198&apikey=bbc002e5";
        URL url =  new URL(query); 
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("/GET to url: "+ url);
        System.out.println("Response Code: "+ responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader (con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null){
            response.append(inputLine);
        };
        in.close();

        //print result
        System.out.println(response.toString());
    }


}