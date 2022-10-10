package com.consumerservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class Employee {

    @JsonProperty("employee_id")
    private String employeeId;

    @JsonProperty("employee_name")
    private String name;

    @JsonProperty("employee_birthDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date birthDate;

    public Employee(String employeeId, String name, Date birthDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "[" +
                "employeeId='" + employeeId + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ']';
    }
}
