package capm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author deepak.jayaprakash
 */
@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
public class CAPMApplication {
    public static void main(String[] args) {
        SpringApplication.run(CAPMApplication.class, args);
    }
}
