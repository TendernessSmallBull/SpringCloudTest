package com.springcloud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcloud.demo.bean.Student;

/**
 * 简单的dao层只需要继承JpaRepository接口，即可，
 * 两个参数，分别表示 —— 实体类型、主键类型
 * 复杂sql语句再自己增加接口
 * @author linhongcun
 * 
 */
public interface StudentDao extends JpaRepository<Student, Integer>{
    
}
