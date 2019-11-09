package com.company.shyhhaw;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class GetResult2 {

    private final ArrayList<Data> result2 = new ArrayList<Data>();
    private static JSONObject myResponse;

    public void GetData2() {

        try {
            String url = "https://api.github.com/users/zhamri/followers?per_page=100&page=2&client_id=f15103c32930df42afef&client_secret=463af9796965fa23004d752bb9e2c1a6110c9e2d";
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

                result2.add(new Data(githubLink));

            }



        }catch (Exception e) {
            System.out.println(e);
        }

    }
    public ArrayList getResult2() throws JSONException {
        return result2;
    }
}
