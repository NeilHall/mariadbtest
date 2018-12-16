package com.mariadbtest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestTableRepository extends JpaRepository<TestTableEntity, Integer> {
    TestTableEntity findByName(String name);
}
