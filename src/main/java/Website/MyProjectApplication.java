package Website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Website.Repository")
public class MyProjectApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyProjectApplication.class, args);
	}

}
