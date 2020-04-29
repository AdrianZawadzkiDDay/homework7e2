package pl.bykowski.homework7_2.repository;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

        @Bean
        public DataSource getDataSource(){
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url("jdbc:mysql://localhost:3306/articles");
            // ?serverTimezone=UTC&useLegacyDatetimeCode=false  <--- and it to url when timezone error
            dataSourceBuilder.username("root");
            dataSourceBuilder.password("");
            dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
            return dataSourceBuilder.build();
        }

//        @EventListener(ApplicationEvent.class)
//        public void init() {
//            String sql = "CREATE TABLE articles (article_id int NOT NULL AUTO_INCREMENT," +
//                    " author varchar(50)," +
//                    " title varchar(250)," +
//                    "content varchar(1000)," +
//                    " PRIMARY KEY (article_id))";
//            getJdbcTemplate().update(sql);
//        }

        @Bean
        public JdbcTemplate getJdbcTemplate(){
            return new JdbcTemplate(getDataSource());
        }

}
