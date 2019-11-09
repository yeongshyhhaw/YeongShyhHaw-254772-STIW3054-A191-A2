package com.company.shyhhaw;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetResult {
    private final ArrayList<Data> result = new ArrayList<Data>();
    private static JSONObject myResponse;

    public void GetData() {

        try {
            String url = "https://api.github.com/users/zhamri/followers?per_page=100&client_id=f15103c32930df42afef&client_secret=463af9796965fa23004d752bb9e2c1a6110c9e2d";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            //Read JSON response
            JSONArray Follower = new JSONArray(response.toString());
            for(int x=0; x<Follower.length();x++)
            {
                myResponse = Follower.getJSONObject(x);
                String githubLink = myResponse.getString("html_url");
                result.add(new Data(githubLink));

            }



        }catch (Exception e) {
            System.out.println(e);
        }

    }
    public ArrayList getResult() throws JSONException {
        return result;
    }
}
