package by.bot.test.rest;


import by.bot.test.rest.entity.Cities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

@Autowired
    private RestTemplate restTemplate;


    public List<Cities> showAllCities() {
        return null;
    }




    public Cities getCities(int id) {
        return null;
    }



    public void saveCities(Cities cities){

    }



    public void deleteCities(int id){

    }
}
