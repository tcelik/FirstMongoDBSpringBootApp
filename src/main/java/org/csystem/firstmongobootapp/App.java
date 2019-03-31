package org.csystem.firstmongobootapp;

import org.csystem.firstmongobootapp.entity.ItemInfo;
import org.csystem.firstmongobootapp.entity.SearchView;
import org.csystem.firstmongobootapp.entity.SensorInfo;
import org.csystem.firstmongobootapp.repository.ISensorRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("items")
public class App {
    @Autowired
    private ISensorRepository m_sensorRepository;

    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }

    @GetMapping("hello")
    public String sensors()
    {
        return "hello from sensors";
    }

    @GetMapping("index")
    @ResponseBody
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @GetMapping("mongo-kayit") //get ile geldi buraya
    public ModelAndView a()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item", new ItemInfo());
        modelAndView.setViewName("a.html");
        return modelAndView; //html olarak bu a.html döndük.
    }

    @PostMapping("mongo-kayit") //post ile geldi buraya daha önce get ile oraya boş model gönderdik form datasıyla doldu.
    //sensor form datasıyla oto doldu.
    //modellerin oradan oraya savrulması spring bootun sorunu her defasında ekle gönder demek gerekmiyor.
    public String post(@ModelAttribute ItemInfo item)
    {
        //System.out.println(item.getName());

        m_sensorRepository.insert(item); //kayıt et mongoya.22

        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("sensor", sensorInfo);
        //return new ModelAndView("result.html");
        return "ok";
    }

    public ApplicationRunner run(ISensorRepository DAO)
    {
        return args -> {

            //insert just getting the object orm. Object relational model.
            //DAO.insert(new SensorInfo("tugberk-senso", 10.0, "sarıyer"));

            //getAll from repo, dao, IoC. Elemanları SensorInfo olan bir liste tarzı collection.
            //DAO.findAll().forEach(sensorInfo -> System.out.println(sensorInfo.getName()));

            // ver bana id verim sana nesneyi.
            //SensorInfo si = new SensorInfo("yasin", 10, "denizli");


            //DAO.insert(si);

            //SensorInfo u = DAO.findById("5c9a1080a98904313d8b1200").get();
            //u.setName("yasinditugberk");

            //DAO.save(u);



            //DAO.save(si);
            //DAO.deleteById("5c96c70202de7b5eba1f8134");
            System.out.println(DAO.count());

            //System.out.printf("***%s****", si.getName());

        };
    }






    @GetMapping("search")
    public ModelAndView itemSearch()
    {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("itemName", new SearchView());

        modelAndView.setViewName("search.html");

        return modelAndView; //html olarak bu a.html döndük.
    }



    @PostMapping("search")
    public ModelAndView itemSearch(@ModelAttribute SearchView searchView)
    {

        ItemInfo info = m_sensorRepository.findById("5ca098595666a218ab43670b").get();

        List<ItemInfo> list = m_sensorRepository.findAll();

        ItemInfo result = null;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getName().equalsIgnoreCase(searchView.getItemName())) {
                result = list.get(i);
                break;
            }
        }


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result", result);
        modelAndView.setViewName("result.html");
        return modelAndView; //html olarak bu a.html döndük.


        /*
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("itemName", new SearchView());

        modelAndView.setViewName("search.html");*/
    }
}

// how to remove _class column : Document'a böyle birşey ekliyordu.
@Configuration
class MongoDBConfig implements InitializingBean {

    @Autowired
    @Lazy
    private MappingMongoConverter mappingMongoConverter;

    @Override
    public void afterPropertiesSet() throws Exception {
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }
}



