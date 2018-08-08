package cn.devlab;

import java.io.File;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

/**
 * Hello world!
 */
public class Database {

  public static void main(String[] args) throws Exception {
    Configurations configurations = new Configurations();

    Configuration configuration = configurations.properties(new File("db.properties"));
    String host = configuration.getString("db.host");
    System.out.println(host);
  }
}
