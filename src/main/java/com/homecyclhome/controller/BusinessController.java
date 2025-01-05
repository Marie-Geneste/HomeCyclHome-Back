package com.homecyclhome.controller;

import com.homecyclhome.model.Business;
import com.homecyclhome.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/business")

public class BusinessController {
    @Autowired
    private BusinessService businessService;

    //GetAll Business
    @GetMapping
    public @ResponseBody List<Business> getAllBusiness(){
        return businessService.getAllBusiness();
    }

    //GetOne Business
    @GetMapping("/{id}")
    public ResponseEntity<Business> getBusinessById(@PathVariable("id") long businessID) {
        return new ResponseEntity<Business>(businessService.getBusinessById(businessID), HttpStatus.OK);
    }

}
