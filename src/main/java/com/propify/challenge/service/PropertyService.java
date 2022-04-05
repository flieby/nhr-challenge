package com.propify.challenge.service;

import com.propify.challenge.dto.PropertyDTO;
import com.propify.challenge.mapper.AddressMapper;
import com.propify.challenge.mapper.PropertyMapper;
import com.propify.challenge.dto.PropertyReport;
import com.propify.challenge.entity.Property;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class PropertyService {

    @Autowired
    PropertyMapper propertyMapper; //Implementatoin pending

    @Autowired
    AddressMapper addressMapper; //Implementatoin pending

    @Autowired
    AlertService alertService;

    public Collection<PropertyDTO> search(String minRentPrice, String maxRentPrice) {
        Set<Property> search = propertyMapper.search(minRentPrice, maxRentPrice);
        Set<PropertyDTO> searchDTOs = new HashSet<>();
        search.stream().forEachOrdered(property -> {
            PropertyDTO dto = new PropertyDTO();
            BeanUtils.copyProperties(property, dto);
            searchDTOs.add(dto);
        });
        return searchDTOs;
    }

    public PropertyDTO findById(int id) {
        Property byId = propertyMapper.findById(id);
        PropertyDTO dto = new PropertyDTO();
        BeanUtils.copyProperties(byId, dto);
        return dto;
    }

    public void insert(PropertyDTO dto) {
        Property property = new Property();
        BeanUtils.copyProperties(dto,property);
        propertyMapper.insert(property);
        System.out.println("CREATED: " + property.getId());
    }

    public void update(PropertyDTO dto) {
        Property property = new Property();
        BeanUtils.copyProperties(dto,property);
        propertyMapper.update(property);
        System.out.println("UPDATED: " + property.getId());
    }

    public void delete(int id) {
        propertyMapper.delete(id);
        System.out.println("DELETED: " + id);

        alertService.sendPropertyDeletedAlert(id);
        // TODO: Sending the alert should be non-blocking (asynchronous)
        //  Extra points for only sending the alert when/if the transaction is committed
    }

    public PropertyReport propertyReport() {
        var allProperties = propertyMapper.search(null, null);
        var propertyReport = new PropertyReport();

        // Calculate total quantity
        // propertyReport.totalQuantity =

        // Calculate the quantity of each type, 0 if there is no properties.
        // propertyReport.quantityPerType =

        // Calculate the average rent price (exclude the properties without rent price or with rent price = 0)
        // propertyReport.averageRentPrice =

        // Calculate the quantity of properties in the state of Illinois (IL)
        // propertyReport.illinoisQuantity =

        return propertyReport;
    }
}
