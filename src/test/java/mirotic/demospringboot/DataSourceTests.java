package mirotic.demospringboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@RunWith(SpringRunner.class)
public class DataSourceTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void H2Config() throws Exception{
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        log.debug("Database URL[{}]", metaData.getURL());
        log.debug("Database DriverName[{}]", metaData.getDriverName());
        log.debug("Database DriverVersion[{}]", metaData.getDriverVersion());

        assertThat(metaData.getDriverName()).isEqualTo("H2 JDBC Driver");
    }
}
