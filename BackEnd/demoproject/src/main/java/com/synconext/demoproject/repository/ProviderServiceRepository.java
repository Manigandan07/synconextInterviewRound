package com.synconext.demoproject.repository;

import com.synconext.demoproject.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderServiceRepository extends JpaRepository<ProviderEntity,String> {

    ProviderEntity findByName(String Name);

    List<ProviderEntity> findByNameContainingIgnoreCase(String Name);

    List<ProviderEntity> findByNameLikeIgnoreCase(String Name);

}
