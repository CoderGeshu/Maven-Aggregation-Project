package com.eric.pojo;

/**
 * @Date: 2020/7/21 15:02
 * @author: Eric
 */
public class User {
    private Integer id;
    private String name;
    private String gender;
    private String birth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
