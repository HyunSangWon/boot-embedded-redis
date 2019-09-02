package com.example.demo.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student implements Serializable{

   private static final long serialVersionUID = 1L;
   
   private Long id;
   private String firstName;
   private String lastName;
   
}
