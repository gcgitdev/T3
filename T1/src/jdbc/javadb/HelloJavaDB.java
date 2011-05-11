package jdbc.javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*------------------------------------------------------------------------------
 * COPYRIGHT Sample 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Sample Inc. The programs may be used and/or copied only with written
 * permission from Sample Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
public class HelloJavaDB {
    public static String embedDriver = "org.apache.derby.jdbc.EmbeddedDriver"; //in derby.jar
    public static String embedProtocol = "jdbc:derby:";
    public static String clientDriver = "org.apache.derby.jdbc.ClientDriver"; // in derbyclient.jar
    public static String clientProtocol = "jdbc:derby://localhost:1527/";

    public static void main(String[] args) throws Exception {
        //        boolean embedMode = true;
        boolean embedMode = false;
        String driver = embedDriver;
        String protocol = embedProtocol;

        if (!embedMode) {
            driver = clientDriver;
            protocol = clientProtocol;
        }

        System.out.println("Loading the driver, with driver name: " + driver);
        //Class.forName(driver).newInstance(); // this is new feature of jdbc4.0 under jdk 6, old version must have this specific load

        System.out.println("Creating connection, with protocol name: " + protocol);
        Properties props = new Properties();
        props.put("user", "user1");
        props.put("password", "user1");
        Connection conn = DriverManager.getConnection(protocol + "helloDB;create=true", props); // create=true will create "helloDB" DB/dir if not exist 
        System.out.println("create and connect to helloDB");
        conn.setAutoCommit(false);

        System.out.println("Creating table hellotable");
        Statement s = conn.createStatement();
        s.execute("create table hellotable(name varchar(40), score int)");
        s.execute("insert into hellotable values ('Ruth Cao', 86)");
        s.execute("insert into hellotable values ('Flora Shi', 92)");

        System.out.println("name------------------score");
        ResultSet rs = s.executeQuery("SELECT name, score FROM hellotable ORDER BY score");
        while (rs.next()) {
            StringBuilder builder = new StringBuilder(rs.getString(1));
            builder.append("------------------");
            builder.append(rs.getInt(2));
            System.out.println(builder.toString());
        }

        System.out.println("Droping table hellotable");
        s.execute("drop table hellotable");

        System.out.println("Closing result set and statement");
        rs.close();
        s.close();

        System.out.println("Commiting transaction and closed connection");
        conn.commit();
        conn.close();

        System.out.println("Seems will always throw a exception when shutdown, suppress it.");
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true"); // shutdown all DB
            //DriverManager.getConnection("jdbc:derby:helloDB;shutdown=true"); // shutdown helloDB
        } catch (SQLException se) {
            System.out.println("Database shutdown normally");
        }
    }
}