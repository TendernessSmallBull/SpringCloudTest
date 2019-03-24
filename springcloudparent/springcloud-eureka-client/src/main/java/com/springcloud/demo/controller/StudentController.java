package com.springcloud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.demo.bean.Student;
import com.springcloud.demo.service.StudentService;
/**
 * Description: restful测试controller
 * @author zx  
 * @date 2019年3月24日
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentservice;

    /**
              * 显示所有
     * url:"http://localhost/student/findall"
     * @return
     */
    @RequestMapping(value = "/findall")
    public List<Student> findAllStudent() {
        return studentservice.findAllStudent();
    }
    
    /**
              * 删除 restful 风格
     * url:"http://localhost/student/deleteone/4"
              * 注意无法通过浏览器的链接来模拟检验,可以通过 jquery的 $.ajax方法，并type="delete"
     * @RequestMapping(value = "/deleteone/{id}", method = RequestMethod.DELETE)
     * @param id
     */
    @DeleteMapping("/deleteone/{id}")
    public void deleteStudentRestful(@PathVariable("id") Integer id) {
        studentservice.deleteStudent(id);
    }
    
    /**
              * 增加 restful 风格
     * url:"http://localhost/student/addone"
               * 通过<form>表单模拟验证
     * @RequestMapping(value="/addone",method=RequestMethod.POST)
     * @param student
     */
    @PostMapping("/addone")
    public void addStudentRestful(Student student) {
        studentservice.addStudent(student);
    }
    
    /**
              * 修改 restful 风格
     * url:"http://localhost/student/updateone"
              * 验证：可以通过 jquery的 $.ajax方法，并type="put",同时注意data形式——A=a&B=b&C=c
     * @RequestMapping(value="/updateone",method=RequestMethod.PUT)
     * @param student
     */
    @PutMapping("/updateone")
    public void updateStudentRestful(Student student) {
        studentservice.updateStudent(student);
    }
    
}
