package com.springcloud.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

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
    	logger.debug("debug级别日志：查看所有学生对象");
    	logger.warn("warn级别日志：查看所有学生对象");
    	logger.info("info级别日志：查看所有学生对象");
    	logger.error("error级别日志：查看所有学生对象");
        return studentDao.findAll();
        
    }

}
