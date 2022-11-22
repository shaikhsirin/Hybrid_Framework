package com.operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {

    Properties p = new Properties();

    public Properties getObjectRepository() throws IOException{

        InputStream stream = new FileInputStream(System.getProperty("C:\\Users\\HP\\eclipse-workspace\\src\\test\\java\\Selenium\\Hybrid_Driven_Framework\\src\\main\\java\\com\\object\\object.properties"));

        p.load(stream);
        return p;
    }

}
