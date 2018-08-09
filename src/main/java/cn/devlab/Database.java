package cn.devlab;

import java.util.List;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;

/**
 *
 */
public class Database {

  public static void main(String[] args) throws Exception {
    Configurations configurations = new Configurations();

    FileBasedConfigurationBuilder<PropertiesConfiguration> builder = configurations.propertiesBuilder("db.properties");
    //Configuration configuration = configurations.properties(new File("db.properties"));
    Configuration configuration = builder.getConfiguration();
    String host = configuration.getString("db.host");
    int port = configuration.getInt("db.port");
    System.out.println(host + ":" + port);


    //xml

    XMLConfiguration xmlConfiguration = configurations.xml("paths.xml");

    String stage = xmlConfiguration.getString("processing[@stage]");
    System.out.println(stage);

    List<String> pathList = xmlConfiguration.getList(String.class, "processing.paths.path");

    System.out.println(pathList);


    //update

    configuration.addProperty("db.type","production");


    builder.save();
  }
}
