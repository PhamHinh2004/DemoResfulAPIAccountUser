package Website.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigValidator {
		
	@Bean
	public UserValidatr userValidatr() {
		return new  UserValidatr();
	}
}
