package com.learn.code.elasticsearch.controller;

import com.alibaba.fastjson.JSON;
import com.learn.code.elasticsearch.model.Employee;
import com.learn.code.elasticsearch.dao.EmployeeRepository;
import com.learn.code.elasticsearch.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjj
 * @date 2018/10/22
 */
@RestController
@RequestMapping("/el")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/add")
    public String add() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setFirstName("xuxu");
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        employeeService.save(employee);

        System.err.println("add a obj");

        return "success";
    }

    @RequestMapping("/delete")
    public String delete() {
        employeeService.deleteById("1");
        return "success";
    }

    @RequestMapping("/update")
    public String update() {

        Employee employee = employeeService.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        employeeService.save(employee);

        System.err.println("update a obj");

        return "success";
    }

    @RequestMapping("/updateSyn")
    public String updateSyn() {

        Employee employee = employeeService.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        employeeService.save(employee);

        System.err.println("update a obj");

        return "success";
    }

    @RequestMapping("/query")
    public Employee query() {

        Employee accountInfo = employeeService.queryEmployeeById("1");
        System.err.println(JSON.toJSONString(accountInfo));

        return accountInfo;
    }

}
