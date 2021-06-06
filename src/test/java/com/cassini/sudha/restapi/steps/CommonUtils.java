package com.cassini.sudha.restapi.steps;

import io.restassured.internal.util.IOUtils;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonUtils {

    public static String readPayload(String fileName)  {
        String payload = null;
        try{
            payload= new String(Files.readAllBytes(Paths.get(CommonUtils.class.getClassLoader().getResource(fileName).toURI())),
                    Charset.defaultCharset());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return payload;
    }

    public static String getFileName(String fileName){
        return String.format("payloads/%s.json", fileName);
    }


}
