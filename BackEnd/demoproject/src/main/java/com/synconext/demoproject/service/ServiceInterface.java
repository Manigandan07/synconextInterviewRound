package com.synconext.demoproject.service;

import com.synconext.demoproject.Response.AutoCompleteResponse;
import com.synconext.demoproject.Response.HomePageRsponse;
import com.synconext.demoproject.dto.ProviderDTO;
import org.springframework.stereotype.Service;


public interface ServiceInterface {

     boolean addProviderDetails(ProviderDTO providerDTO);

     HomePageRsponse getHomePageResponse();

    public ProviderDTO getParticularProvider(String name);

    public AutoCompleteResponse getAutoComplete(String name);
}
