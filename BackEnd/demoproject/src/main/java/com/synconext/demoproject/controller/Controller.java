package com.synconext.demoproject.controller;

import com.synconext.demoproject.Response.AutoCompleteResponse;
import com.synconext.demoproject.Response.HomePageRsponse;
import com.synconext.demoproject.dto.ProviderDTO;
import com.synconext.demoproject.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/service")
public class Controller {

    @Autowired
    ServiceInterface service;

    @RequestMapping(method = RequestMethod.POST, value = "/addProviderDetails")
    public ResponseEntity<Boolean> addProviderDetails(@RequestBody ProviderDTO providerDTO){
        Boolean result = service.addProviderDetails(providerDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET,value = "/getHomePageValue")
    public ResponseEntity<HomePageRsponse> getHomePageResponse(){
        HomePageRsponse homePageRsponse = service.getHomePageResponse();
        return new ResponseEntity<>(homePageRsponse,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getParticularProvider/{name}")
    public ResponseEntity<ProviderDTO> getParticularProvider(@PathVariable  String name){
        ProviderDTO providerDTO = service.getParticularProvider(name);
        return new ResponseEntity<>(providerDTO,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/autoComplete")
    public ResponseEntity<AutoCompleteResponse> getAutoComplete(@RequestParam String name){
        AutoCompleteResponse autoCompleteResponse = service.getAutoComplete(name);
        return new ResponseEntity<>(autoCompleteResponse,HttpStatus.OK);
    }

}
