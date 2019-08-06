package mirotic.demospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class PostgreSqlRunner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try (Connection connection = dataSource.getConnection()) {
            System.out.println(dataSource.getClass());
            System.out.println(dataSource.getConnection().getMetaData().getURL());
            System.out.println(dataSource.getConnection().getMetaData().getDriverName());

            Statement statement = connection.createStatement();
            String createSql = "CREATE TABLE Account(id INTEGER NOT NULL, name VARCHAR(50), PRIMARY KEY (id))";
            statement.executeUpdate(createSql);
        }

        String insertSql = "INSERT INTO Account VALUES(1, 'jupark')";
        jdbcTemplate.execute(insertSql);
    }
}
