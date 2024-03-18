package com.MyCompany.ProperyManagement.Service;

import com.MyCompany.ProperyManagement.Entity.PropertyEntity;
import com.MyCompany.ProperyManagement.dto.PropertyDto;

import java.util.List;

public interface PropertyService {
    PropertyDto saveProperty(PropertyDto propertyDto);
    List<PropertyDto> getAllProperties();
    PropertyDto updateProperties(PropertyDto propertyDto, Long propertyId);
    PropertyDto updateDesciption(PropertyDto propertyDto, Long propertyId);
    void deleteProperty(Long propertyID);
}
