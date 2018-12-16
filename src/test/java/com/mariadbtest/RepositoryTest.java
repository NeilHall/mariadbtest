package com.mariadbtest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    private TestTableRepository testTableRepository;
    @Before
    public void setUp() throws Exception {
        TestTableEntity Test1= new TestTableEntity("Shorty", 83);
        TestTableEntity Test2= new TestTableEntity("Dave", 27);
        //save Test, verify has ID value after save
        assertNull(Test1.getId());
        assertNull(Test2.getId());//null before save
        testTableRepository.save(Test1);
        testTableRepository.save(Test2);
        assertNotNull(Test1.getId());
        assertNotNull(Test2.getId());
    }

    @Test
    public void testFetchData(){
        TestTableEntity test1 = testTableRepository.findByName("Dave");
        assertNotNull(test1);
        assertEquals(27, test1.getAge());
        List<TestTableEntity> Tests = testTableRepository.findAll();
        int count = (int) Tests.stream().count();
        assertEquals(count, 2);
    }
}
