package com.example.Recipe.Sharing.model;

import lombok.Data;

@Data 
public class Recipe {
    private int id;
    private int user_id;
    private String title;
    private String description;
    private String instruction;
    private String photo_path;
    private String created_at;
}
