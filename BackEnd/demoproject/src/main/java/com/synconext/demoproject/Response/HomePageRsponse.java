package com.synconext.demoproject.Response;

import com.synconext.demoproject.dto.ProviderDTO;

import java.util.List;

public class HomePageRsponse {

    List<ProviderDTO> homePageRsponsesList;

    public List<ProviderDTO> getHomePageRsponsesList() {
        return homePageRsponsesList;
    }

    public void setHomePageRsponsesList(List<ProviderDTO> homePageRsponsesList) {
        this.homePageRsponsesList = homePageRsponsesList;
    }
}
