package com.learn.code.elasticsearch.dao;

import com.learn.code.elasticsearch.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author zjj
 * @date 2018/10/22
 */
@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {

    Employee queryEmployeeById(String id);

}
