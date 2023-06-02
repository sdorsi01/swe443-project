package com.swe_project.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private char name;
    private char email;
    private char profile_pic;
    private char pw;
/*
 * ID
 */
    public void setID(){
        this.id = id;
    }
    public Integer getID(){
        return id ;
    }
/*
 *  Name 
 */
    public void setName(){
        this.name = name;
    }
    public char getName(){
        return name ;
    }
/*
 * Email
 */
    public void setEmail(){
        this.email = email;
    }
    public char getEmail(){
        return email ;
    }

    
}
