package com.MyCompany.ProperyManagement.converter;

import com.MyCompany.ProperyManagement.Entity.PropertyEntity;
import com.MyCompany.ProperyManagement.dto.PropertyDto;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {
    public PropertyEntity DTOtoEntityConverter(PropertyDto propertyDto)
    {
        PropertyEntity pe = new PropertyEntity();

        pe.setTitle(propertyDto.getTitle());
        pe.setDescription(propertyDto.getDescription());
        pe.setPrice(propertyDto.getPrice());
        pe.setOwnerName(propertyDto.getOwnerName());
        pe.setOwnerEmail(propertyDto.getOwnerEmail());

        return pe;
    }

    public PropertyDto EntityToDTO(PropertyEntity propertyEntity)
    {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setId(propertyEntity.getId());
        propertyDto.setTitle(propertyEntity.getTitle());
        propertyDto.setDescription(propertyEntity.getDescription());
        propertyDto.setPrice(propertyEntity.getPrice());
        propertyDto.setOwnerName(propertyEntity.getOwnerName());
        propertyDto.setOwnerEmail(propertyEntity.getOwnerEmail());

        return propertyDto;
    }

    public PropertyDto EntityToDTOWithoutId(PropertyEntity propertyEntity)
    {
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setTitle(propertyEntity.getTitle());
        propertyDto.setDescription(propertyEntity.getDescription());
        propertyDto.setPrice(propertyEntity.getPrice());
        propertyDto.setOwnerName(propertyEntity.getOwnerName());
        propertyDto.setOwnerEmail(propertyEntity.getOwnerEmail());

        return propertyDto;
    }
}
