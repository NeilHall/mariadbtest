package com.mariadbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestTableController {

    @Autowired
    TestTableRepository testTableRepository;

    @GetMapping("/helloworld")
    @ResponseBody
    public TestTableEntity sayHello() {
        TestTableEntity testTableEntity = new TestTableEntity();
        testTableEntity.setName("Mischa");
        testTableEntity.setAge(43);

        testTableRepository.save(testTableEntity);

        return testTableEntity;
    }
}
