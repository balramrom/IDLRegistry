package es.us.idlRegistry.web3j.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Sergio Segura
 */
public class PropertyManager {

    private static Properties web3jProperties = null;
    private static final Logger log = LoggerFactory.getLogger(PropertyManager.class);

    public static String readWeb3jProperty(String name) {

        if (web3jProperties==null) {
            web3jProperties = new Properties();
            try {
                web3jProperties.load(new FileInputStream("src/main/resources/web3j.properties"));
            } catch (IOException e) {
                log.error("Error reading property file: " + e.getMessage());
            }
        }

        return web3jProperties.getProperty(name);

    }
}