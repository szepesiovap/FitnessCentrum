package sk.upjs.ics.paz1c.fitnesscentrum.dao.impl;

import com.ibatis.common.jdbc.ScriptRunner;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import sk.upjs.ics.paz1c.fitnesscentrum.ObjectFactory;

public class PripravaNaTestovanie {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_MENO = "testFitnesscentrum";
    private static final String DB_USER = "fitnesscentrum";
    private static final String DB_PASSWORD = "fitnesscentrum";
    private static final String DB_MENO_SUBORU = "testDBScript.sql";

    private static Connection connection;

    @BeforeClass
    public static void setUpClass() throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection("jdbc:mysql://localhost/?user=fitnesscentrum&password=fitnesscentrum");
        Statement s = connection.createStatement();

        s.executeUpdate("CREATE DATABASE " + DB_MENO);

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName(DB_MENO);
        dataSource.setUser(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        ObjectFactory.INSTANCE.setJdbcTemplate(new JdbcTemplate(dataSource));        
    }
    
    @Before
    public void setUp() throws  IOException, SQLException{
        ScriptRunner runner = new ScriptRunner(connection, false, true);
        runner.runScript(new BufferedReader(new FileReader(DB_MENO_SUBORU)));
    }

    @After
    public void tearDownClass() throws SQLException {
        Statement s = connection.createStatement();
        s.executeUpdate("DROP DATABASE " + DB_MENO);
    }
}
