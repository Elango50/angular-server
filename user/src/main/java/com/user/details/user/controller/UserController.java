package com.user.details.user.controller;


import com.user.details.user.model.UserDetails;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @GetMapping("/users/{name}")
    public List<UserDetails> getUserDetails(@PathVariable String name) {
        System.out.println("get User called.....");
        return getRepoDetails(name);
    }

    public List<UserDetails> getRepoDetails(String name) {

        try {

            URL url = new URL("https://api.github.com/users/" + name + "/repos");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            StringBuffer output = new StringBuffer();
            String str;
            System.out.println("Output from Server .... \n");
            while ((str = br.readLine()) != null) {
                output.append(str);
            }
            System.out.println(output);

            ArrayList<JSONObject> stringArray = new ArrayList<>();

            List<UserDetails> userDetail = new ArrayList<>();


            JSONArray jsonArray = new JSONArray(output.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                stringArray.add(jsonArray.getJSONObject(i));
            }

            for (int i = 0; i < stringArray.size(); i++) {
                userDetail.add(new UserDetails(stringArray.get(i).getInt("id"),
                        stringArray.get(i).getString("name"),
                        stringArray.get(i).getString("full_name"),
                        stringArray.get(i).getInt("open_issues")));
            }

            System.out.println(stringArray);
            System.out.println(userDetail);

            conn.disconnect();

            return userDetail;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

}
