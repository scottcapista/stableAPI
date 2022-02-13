package com.mongodb.corpsa.pov.controller.airbnb;

import com.mongodb.corpsa.pov.model.airbnb.aggregations.ListingsByLocation;
import com.mongodb.corpsa.pov.model.airbnb.listingsandreviews.ListingsAndReviews;
import com.mongodb.corpsa.pov.repositories.airbnb.AirbnbRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/airbnb")
public class AirbnbRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AirbnbRestController.class);
    private final AirbnbRepository airbnbRepository;

    public AirbnbRestController(AirbnbRepository airbnbRepository) {
        this.airbnbRepository = airbnbRepository;
    }

    @GetMapping(value = "/listings/")
    public ListingsAndReviews getOneListing(){
        LOGGER.info("Method -> " + stackWalker() + " : no id given");
        return airbnbRepository.getOneListing();
    }

    @GetMapping(value = "/listings/{id}")
    public ListingsAndReviews getOneListing(@PathVariable(value = "id") String id){
        LOGGER.info("Method -> " + stackWalker() + " : id given");
        return airbnbRepository.getOneListing(id);
    }

    @GetMapping(value = "/listings/location")
    public ArrayList<ListingsByLocation> getListings(){
        LOGGER.info("Method -> " + stackWalker() + " : id given");
        return airbnbRepository.getListings(0,20,10000);
    }


    private String stackWalker(){
        StackWalker walker = StackWalker.getInstance();
        Optional<String> methodName = walker.walk(frames -> frames
                .skip(1)
                .findFirst()
                .map(StackWalker.StackFrame::getMethodName));
        return methodName.get();
    }
}
