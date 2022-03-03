package Codigo.Actividad1BackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Actividad1BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(Actividad1BackEndApplication.class, args);
	}

}
