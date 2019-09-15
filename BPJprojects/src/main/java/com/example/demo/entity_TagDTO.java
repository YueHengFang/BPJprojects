package com.example.demo;

import java.util.List;

import lombok.Data;

@Data
public class entity_TagDTO {
    private String Categoryname;
    private List<String> ShowTags;
    private List<String> valueTags;
    
}
