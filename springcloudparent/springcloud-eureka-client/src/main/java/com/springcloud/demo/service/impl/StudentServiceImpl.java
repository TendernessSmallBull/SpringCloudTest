package com.springcloud.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.demo.bean.Student;
import com.springcloud.demo.dao.StudentDao;
import com.springcloud.demo.service.StudentService;
/**
 * Description: restful测试service实现类
 * @author zx  
 * @date 2019年3月24日
 */
@Service 
public class StudentServiceImpl implements StudentService {

    @Autowired  
    private StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        // TODO Auto-generated method stub
        studentDao.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        // TODO Auto-generated method stub
        studentDao.deleteById(id);

    }

    @Override
    public void updateStudent(Student student) {
        // TODO Auto-generated method stub
        studentDao.save(student);
    }

    @Override
    public List<Student> findAllStudent() {
        // TODO Auto-generated method stub
        return studentDao.findAll();
        
    }

}
