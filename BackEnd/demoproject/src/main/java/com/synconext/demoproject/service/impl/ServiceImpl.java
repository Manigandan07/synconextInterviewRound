package com.synconext.demoproject.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.synconext.demoproject.Response.AutoCompleteResponse;
import com.synconext.demoproject.Response.HomePageRsponse;
import com.synconext.demoproject.Response.Response;
import com.synconext.demoproject.dto.ProviderDTO;
import com.synconext.demoproject.entity.ProviderEntity;
import com.synconext.demoproject.repository.ProviderServiceRepository;
import com.synconext.demoproject.service.ServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl implements ServiceInterface {

    @Autowired
    ProviderServiceRepository providerServiceRepository;

    public boolean addProviderDetails(ProviderDTO providerDTO){
        boolean result = false;
        ProviderEntity providerEntity = new ProviderEntity();
        BeanUtils.copyProperties(providerDTO,providerEntity);
        providerServiceRepository.save(providerEntity);
        if(providerEntity!=null){
            result = true;
        }
        return  result;

    }

    public HomePageRsponse getHomePageResponse(){
        List<ProviderEntity> providerEntityList = providerServiceRepository.findAll();
        List<ProviderDTO> responseList = new ArrayList<>();
        providerEntityList.stream().forEach(provider ->{
//            Response response = new Response();
//            response.setName(provider.getName());
//            response.setLowestPrice(provider.getLowestPrice());
//            responseList.add(response);
                ProviderDTO providerDTO = new ProviderDTO();
                BeanUtils.copyProperties(provider,providerDTO);
                responseList.add(providerDTO);

                }

        );
        HomePageRsponse homePageRsponse = new HomePageRsponse();
        homePageRsponse.setHomePageRsponsesList(responseList);
        return homePageRsponse;
    }

    public ProviderDTO getParticularProvider(String name){
        ProviderEntity providerEntity = providerServiceRepository.findByName(name);
        ProviderDTO providerDTO = new ProviderDTO();
        BeanUtils.copyProperties(providerEntity,providerDTO);
        return providerDTO;
    }

    public AutoCompleteResponse getAutoComplete(String name){
        List<ProviderEntity> providerEntityList = providerServiceRepository.findByNameContainingIgnoreCase(name);
        List<String> stringList = new ArrayList<>();
        providerEntityList.stream().forEach(provider -> {
            stringList.add(provider.getName());

        });
        AutoCompleteResponse autoCompleteResponse = new AutoCompleteResponse();
        autoCompleteResponse.setAutoCompleteWord(stringList);
        return autoCompleteResponse;
    }
}
