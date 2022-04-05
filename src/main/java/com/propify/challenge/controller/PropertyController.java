package com.propify.challenge.controller;

import com.propify.challenge.dto.PropertyDTO;
import com.propify.challenge.dto.PropertyReport;
import com.propify.challenge.entity.Property;
import com.propify.challenge.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    // API endpoints for CRUD operations on entities of type Property

    @RequestMapping(value = "/search", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PropertyDTO> search(@PathVariable(name = "min_rent_price") String minRentPrice, @PathVariable(name = "max_rent_price") String maxRentPrice) {
        return propertyService.search(minRentPrice, maxRentPrice);
    }

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PropertyDTO> findById(@PathVariable(name = "id") int id) {
        PropertyDTO dto = propertyService.findById(id);
        if(dto==null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity insert(@RequestBody PropertyDTO dto) {
        // TODO: Property attributes must be validated
        if(dto==null || dto.getId()!=0)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        propertyService.insert(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody PropertyDTO dto) {
        // TODO: Property attributes must be validated
        if(dto==null || dto.getId()==0)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        propertyService.update(dto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(int id) {
        propertyService.delete(id);
    }

    public PropertyReport report() {
        return propertyService.propertyReport();
    }
}
