package newProject.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("newProject")
public class SpringConf {

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource hikariDatasource() {
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setUsername("hleb");
        hikariDataSource.setPassword("65orevar");
        hikariDataSource.setDriverClassName("org.postgresql.Driver");
        hikariDataSource.setMaximumPoolSize(20);
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/hleb_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        return hikariDataSource;
    }



//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/WEB-INF/jsp/**");
//    }
//
//    @Bean
//    public InternalResourceViewResolver setupViewResolver() {
//        return new InternalResourceViewResolver("/WEB-INF/jsp/", ".jsp");
//    }



}
