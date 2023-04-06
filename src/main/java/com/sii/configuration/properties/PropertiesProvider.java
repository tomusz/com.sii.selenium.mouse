package com.sii.configuration.properties;

import com.sii.configuration.FileHandler;

import java.io.IOException;
import java.util.Properties;
import java.util.function.Function;

public class PropertiesProvider {

    private static final String PATH_TO_PROPERTIES = "properties/";
    private static final String PATH_TO_MSG_PROPERTIES = PATH_TO_PROPERTIES + "messages/";

    private static Properties msgProperties = null;

    public static Properties getInfoMsgProperties() {
        if (msgProperties == null) {
            msgProperties = getPropertiesFromFile.apply(PATH_TO_MSG_PROPERTIES + "info.properties");
        }
        return msgProperties;
    }

    private static Function<String, Properties> getPropertiesFromFile = address -> {
        try {
            return FileHandler.loadFile(address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
}