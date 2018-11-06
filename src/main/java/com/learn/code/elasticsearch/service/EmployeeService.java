package com.learn.code.elasticsearch.service;

import com.learn.code.elasticsearch.model.Employee;

/**
 * @author zjj
 * @date 2018/11/1
 */
public interface EmployeeService {
    void save(Employee employee);

    void update(Employee employee);

    void deleteById(String id);

    Employee queryEmployeeById(String id);

}
