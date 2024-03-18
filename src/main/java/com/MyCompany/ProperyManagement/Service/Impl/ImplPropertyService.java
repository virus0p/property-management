package com.MyCompany.ProperyManagement.Service.Impl;

import com.MyCompany.ProperyManagement.Entity.PropertyEntity;
import com.MyCompany.ProperyManagement.PropertyRespository.PropertyRespository;
import com.MyCompany.ProperyManagement.Service.PropertyService;
import com.MyCompany.ProperyManagement.converter.PropertyConverter;
import com.MyCompany.ProperyManagement.dto.PropertyDto;
import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
@Service
public class ImplPropertyService implements PropertyService {

    @Autowired
    private PropertyConverter propertyConverter;
    @Autowired
    private PropertyRespository propertyRespository;
    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto)
    {
        PropertyEntity pe = propertyConverter.DTOtoEntityConverter(propertyDto);
        pe = propertyRespository.save(pe);
        propertyDto = propertyConverter.EntityToDTO(pe);
        return propertyDto;
    }

    @Override
    public List<PropertyDto> getAllProperties()
    {
        List<PropertyEntity> pe = (List<PropertyEntity> )propertyRespository.findAll();
        List<PropertyDto> propertyDto = new ArrayList<PropertyDto>();
        for(PropertyEntity p : pe)
        {
            PropertyDto dto = propertyConverter.EntityToDTO(p);
            propertyDto.add(dto);
        }
        return propertyDto;
    }

    @Override
    public PropertyDto updateProperties(PropertyDto propertyDto, Long propertyId)
    {
        Optional<PropertyEntity> optionalPropertyEntity =  propertyRespository.findById(propertyId);
        PropertyDto dto = null;
        if (optionalPropertyEntity.isPresent())
        {
            PropertyEntity pe = optionalPropertyEntity.get();

            pe.setTitle(propertyDto.getTitle());
            pe.setDescription(propertyDto.getDescription());
            pe.setPrice(propertyDto.getPrice());
            pe.setOwnerName(propertyDto.getOwnerName());
            pe.setOwnerEmail(propertyDto.getOwnerEmail());

            dto = propertyConverter.EntityToDTO(pe);
            propertyRespository.save(pe);
        }

        return dto;
    }

    @Override
    public PropertyDto updateDesciption(PropertyDto propertyDto, Long propertyId) {
        Optional<PropertyEntity> optEnt = propertyRespository.findById(propertyId);
        PropertyDto dto = null ;

        if(optEnt.isPresent())
        {
            PropertyEntity pe = optEnt.get();
            pe.setDescription(propertyDto.getDescription());
            dto = propertyConverter.EntityToDTO(pe);
            propertyRespository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyID) {
        propertyRespository.deleteById(propertyID);
    }
}
