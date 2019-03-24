package org.csystem.firstmongobootapp;

import org.csystem.firstmongobootapp.entity.SensorInfo;
import org.csystem.firstmongobootapp.repository.ISensorRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("sensors")
public class App {
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("hello")
    public String sensors()
    {
        return "hello from sensors";
    }

    @Bean
    public ApplicationRunner run(ISensorRepository DAO)
    {
        return args -> {

            //insert just getting the object orm. Object relational model.
            //DAO.insert(new SensorInfo("tugberk-senso", 10.0, "sarıyer"));

            //getAll from repo, dao, IoC. Elemanları SensorInfo olan bir liste tarzı collection.
            //DAO.findAll().forEach(sensorInfo -> System.out.println(sensorInfo.getName()));

            // ver bana id verim sana nesneyi.
            //SensorInfo si = DAO.findById("5c96c70202de7b5eba1f8134").get();
            //si.setName("yeniydi");
            //DAO.insert(si);
            //DAO.save(si);
            //DAO.deleteById("5c96c70202de7b5eba1f8134");
            System.out.println(DAO.count());
            //System.out.printf("***%s****", si.getName());



        };
    }
}



