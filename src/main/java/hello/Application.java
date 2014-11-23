package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        RowMapper<Person> rowMapper = new RowMapper<Person>() {
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Person(rs.getString(1), rs.getString(2));
			}
		};
            
        List<Person> results = ctx.getBean(JdbcTemplate.class).query("SELECT first_name, last_name FROM people", rowMapper);

        //Changes for master branch additional change
        //List out all the persons in database feature 1 change additional change
        //testing commit from nov 22nd branch
        for (Person person : results) {
            System.out.println("Found <" + person + "> in the database.");
        }
    }

}
