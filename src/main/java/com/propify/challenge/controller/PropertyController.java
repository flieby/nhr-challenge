package com.propify.challenge.controller;

import com.propify.challenge.dto.PropertyDTO;
import com.propify.challenge.dto.PropertyReport;
import com.propify.challenge.entity.Property;
import com.propify.challenge.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    // API endpoints for CRUD operations on entities of type Property

    public Collection<Property> search(String minRentPrice, String maxRentPrice) {
        return propertyService.search(minRentPrice, maxRentPrice);
    }

    public Property findById(int id) {
        return propertyService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insert(@RequestBody PropertyDTO dto) {
        // TODO: Property attributes must be validated
        if(dto==null)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        propertyService.insert(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    public void update(Property property) {
        // TODO: Property attributes must be validated
        propertyService.update(property);
    }

    public void delete(int id) {
        propertyService.delete(id);
    }

    public PropertyReport report() {
        return propertyService.propertyReport();
    }
}
