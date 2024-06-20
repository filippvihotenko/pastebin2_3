package by.viho.pastebin2_3.dataAccessModule.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig
{
    @Bean
    public Flyway setFlyway(){
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5433/pastebin", "zefir", "zefir1234")
                .load();

        flyway.baseline();

        flyway.migrate();
        return flyway;
    }
}
