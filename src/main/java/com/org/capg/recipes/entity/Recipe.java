package com.org.capg.recipes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    /*@Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date datetime;*/

    @Column(name = "dish_type")
    private String dish_type;

    @Column(name = "num_of_people")
    private Long num_of_people;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "cooking_instruction")
    private String cooking_instruction;

}
