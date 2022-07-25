package com.testvagrant.TestScripts;

import com.testvagrant.apimethods.ReadJSONFromFile;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ValidateForiengPlayersTest {
    @Test
    public void testForeigenPlayer() throws IOException {
        String filePath="src/test/resources/JSONFolder/TeamRcb.json";
        JSONObject teamRcbJsonObject= ReadJSONFromFile.readJSONObject(filePath);
        int countOfForiegnPlayer =0;

        if(teamRcbJsonObject.getString("name").equals("Royal Challengers Bangalore")){
            JSONArray playerArray=teamRcbJsonObject.getJSONArray("player");
            for (int i = 0; i < playerArray.length(); i++) {
                JSONObject playerDetailsObject=playerArray.getJSONObject(i);
                if(!(playerDetailsObject.getString("country").equals("India"))){
                  countOfForiegnPlayer++;
                }
            }

        }else{
            Assert.assertEquals(teamRcbJsonObject.getString("name").equals("Royal Challengers Bangalore"),false,"Team is not bangalore");
        }

        Assert.assertEquals(countOfForiegnPlayer,4,"forieng player are not equal to 4");


    }
}
