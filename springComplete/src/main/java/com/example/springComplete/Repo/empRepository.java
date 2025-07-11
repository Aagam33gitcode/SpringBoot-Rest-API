package com.example.springComplete.Repo;

import com.example.springComplete.Data.employeeDTO;
import com.example.springComplete.Data.employeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface empRepository extends JpaRepository<employeeDTO,Long> {

    List<employeeDTO> findByEmpNameContainingIgnoreCase(String keyword);

    employeeDTO findByEmpNameAndEmpAgeAndEmpBODAndIsExist(String empName, int empAge, Date empBOD, boolean isExist);
//    List<employeeEntity> findByempNameContainingOrempAgeContaing(String empName, int empAge);
//    List<employeeEntity> findByNameContainingOrAgeContaining(String empName,int empAge);

}