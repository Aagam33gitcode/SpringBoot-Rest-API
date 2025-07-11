package com.example.springComplete.Data;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name="Employee")
public class employeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empID;
    private String empName;
    private int empAge;
    private Date empBOD;
    @JsonProperty("isExist")
    private boolean isExist;
    employeeDTO(){
        super();
    }

    public employeeDTO(long empID, String empName, int empAge, Date empBOD, boolean isExist) {
        this.empID = empID;
        this.empName = empName;
        this.empAge = empAge;
        this.empBOD = empBOD;
        this.isExist = isExist;
    }

    public long getEmpID() {
        return empID;
    }

    public void setEmpID(long empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public Date getEmpBOD() {
        return empBOD;
    }

    public void setEmpBOD(Date empBOD) {
        this.empBOD = empBOD;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}