package com.springcloud.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description: 学生实体类对应数据库
 * @author zx  
 * @date 2019年3月24日
 */
@Entity 
@Table(name = "STUDENT") 
public class Student {
    /**
                 * 主键
                 * 自增
     */
    @Id 
    private Integer id;
    @Column(length = 20) 
    private String name;
    @Column(length = 20) 
    private String adress;

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", adress=" + adress + "]";
    }

    
}
