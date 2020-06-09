package pl.sdacademy.springtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringtasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringtasksApplication.class, args);
	}

}
