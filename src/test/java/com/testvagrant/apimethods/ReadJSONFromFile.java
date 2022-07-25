package com.testvagrant.apimethods;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadJSONFromFile {

    public static JSONObject readJSONObject(String filePath) throws IOException {
        JSONObject responseObject = new JSONObject(Files.readString(Path.of(filePath)));
        return responseObject;
    }


}
