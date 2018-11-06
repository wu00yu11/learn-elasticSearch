package com.learn.code.elasticsearch.service.impl;

import com.learn.code.elasticsearch.dao.EmployeeRepository;
import com.learn.code.elasticsearch.model.Employee;
import com.learn.code.elasticsearch.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author zjj
 * @date 2018/11/6 0006
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository er;

    @Autowired
    private ElasticsearchTemplate template;

    @Override
    public void save(Employee employee) {
        er.save(employee);
    }

    @Override
    public void update(Employee employee) {
        er.save(employee);
    }

    @Override
    public void deleteById(String id) {
        er.deleteById(id);
    }

    @Override
    public Employee queryEmployeeById(String id) {
        return er.queryEmployeeById(id);
    }
}
