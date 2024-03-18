package com.MyCompany.ProperyManagement.Controller;

import com.MyCompany.ProperyManagement.Service.PropertyService;
import com.MyCompany.ProperyManagement.dto.PropertyDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/property")
public class PropertyController {

    @Value("${pms.dummy:}")
    private String dummy;
    @Autowired
    private PropertyService propertyService;
    @PostMapping("/save")
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto)
    {
        propertyDto = propertyService.saveProperty(propertyDto);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.CREATED);
        return  responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> getAllProperties()
    {
        System.out.println(dummy);
        List<PropertyDto> propertyDto = propertyService.getAllProperties();
        ResponseEntity<List<PropertyDto>> responseEntity = new ResponseEntity<>(propertyDto,HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/properties/update/{propertyId}")
    public ResponseEntity<PropertyDto> updateProperties(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId)
    {
        propertyDto = propertyService.updateProperties(propertyDto, propertyId);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDto> updateDescription(@RequestBody PropertyDto propertyDto, @PathVariable Long propertyId)
    {
        propertyDto = propertyService.updateDesciption(propertyDto,propertyId);
        ResponseEntity<PropertyDto> responseEntity = new ResponseEntity<>(propertyDto, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/properties/delete-properties/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId)
    {
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}
