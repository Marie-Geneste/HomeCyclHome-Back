package com.homecyclhome.service;

import com.homecyclhome.model.Business;
import java.util.List;
import java.util.Optional;

public interface BusinessService {
    List<Business> getAllBusiness();
    Business getBusinessById(long id);
}
