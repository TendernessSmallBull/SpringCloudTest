package com.springcloud.demo.service;

import java.util.List;

import com.springcloud.demo.bean.Student;
/**
 * Description: service接口
 * @author zx  
 * @date 2019年3月24日
 */
public interface StudentService {

    /**
     * Description: 描述 
     * @param student
     */
    public void addStudent(Student student);
    /**
     * Description: 描述 
     * @param student
     */
    public void deleteStudent(Integer id);
    /**
     * Description: 描述 
     * @param student
     */
    public void updateStudent(Student student);
    /**
     * Description: 描述 
     * @param student
     */
    public List<Student> findAllStudent();
}
