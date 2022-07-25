package com.testvagrant.TestScripts;

import com.testvagrant.apimethods.ReadJSONFromFile;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateWicketKeeperTest {
    @Test
    public void validateOneKeeperTest() throws IOException {
        String filePath = "src/test/resources/JSONFolder/TeamRcb.json";
        JSONObject teamRcbJsonObject = ReadJSONFromFile.readJSONObject(filePath);
        int countOfKeeper = 0;

        if (teamRcbJsonObject.getString("name").equals("Royal Challengers Bangalore")) {
            JSONArray playerArray = teamRcbJsonObject.getJSONArray("player");
            for (int i = 0; i < playerArray.length(); i++) {
                JSONObject playerDetailsObject = playerArray.getJSONObject(i);
                if (playerDetailsObject.getString("role").equals("Wicket-keeper")) {
                    countOfKeeper++;
                }

            }
        } else {
            Assert.assertEquals(teamRcbJsonObject.getString("name").equals("Royal Challengers Bangalore"), false, "Team is not bangalore");
        }

        Assert.assertEquals(countOfKeeper >= 1, true, "wicket keeper not present in team");


        //Another Approach......................
        //We can use boolean variable also for verification of keeper...take one boolean variable flag=false
        //
        //        if(playerDetailsObject.getString("role").equals("Wicket-keeper")){
        //            flag=true;
        //           break;
        //        }
        // verify boolean should be true


    }

}
