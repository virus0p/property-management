package com.MyCompany.ProperyManagement.dto;

// DTO = Data Transfer Object or we can say it model in another word
// You can generate Getter and setter by right clicking and selected generate option or using lombok tool
/* Example
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDto {
    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private double price;
}
