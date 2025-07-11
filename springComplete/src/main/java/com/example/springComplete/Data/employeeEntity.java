package com.example.springComplete.Data;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

public class employeeEntity {
//    private long empID;
////@NotNull(message = "name can not be empty")
//    //@NotEmpty
//    //@NotBlank
////    @Size()
//    private String empName;
//    @Min(value = 5)
//    @Max(value = 86)
//    private int empAge;
//
//    private Date empBOD;
//    @JsonProperty("isExist")
//    private boolean isExist;
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
private long empID;
    private String empName;
    private int empAge;
    private Date empBOD;
    @JsonProperty("isExist")
    private boolean isExist;
    employeeEntity(){

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

    public employeeEntity(long empID, String empName, int empAge, Date empBOD, boolean isExist) {
        this.empID = empID;
        this.empName = empName;
        this.empAge = empAge;
        this.empBOD = empBOD;
        this.isExist = isExist;
    }
}