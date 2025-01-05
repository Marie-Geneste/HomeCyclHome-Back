package com.homecyclhome.service.impl;

import com.homecyclhome.model.Business;
import com.homecyclhome.repository.BusinessRepository;
import com.homecyclhome.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository businessRepository;

    @Autowired
    public BusinessServiceImpl(BusinessRepository businessRepository) {
        this.businessRepository = businessRepository;
    }

    @Override
    public List<Business> getAllBusiness() {
        return businessRepository.findAll(); // Utilisation de la méthode findAll() du repository
    }

    @Override
    public Business getBusinessById(long id) {
        Optional<Business> business = businessRepository.findById(id);
        if (business.isPresent()){
            return business.get();
        } else {
            throw new RuntimeException();
        }
    }
}
