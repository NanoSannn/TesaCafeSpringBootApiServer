package nvc.it.web_tesa_cafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class WebTesaCafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebTesaCafeApplication.class, args);
	}

}
