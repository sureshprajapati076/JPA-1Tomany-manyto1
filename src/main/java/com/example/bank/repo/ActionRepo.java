package com.example.bank.repo;

import com.example.bank.domain.EmployeeAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepo extends JpaRepository<EmployeeAction, Long> {
}
