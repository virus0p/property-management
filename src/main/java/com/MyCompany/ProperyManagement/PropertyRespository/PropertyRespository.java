package com.MyCompany.ProperyManagement.PropertyRespository;

import com.MyCompany.ProperyManagement.Entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRespository extends CrudRepository<PropertyEntity, Long> {

}
