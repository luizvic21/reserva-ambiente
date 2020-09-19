package br.edu.ifsc.aluno.victor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class App implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class)
                .web(WebApplicationType.NONE)
                .headless(false)
                .run(args);
    }

    @Autowired
    private ApplicationService applicationService;

    @Override
    public void run(String... args) throws Exception {
        applicationService.execute();
    }
}
