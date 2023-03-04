package com.amazin.nayra.entity;


import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amazin.nayra.common.CommonFields;

@Entity
@Table(name = "common_constants")
public class CommonConstants {

    private int id;
    private String code;
    private String description;
    private String value;
    private Integer commonUserId;
	/*
	 * private Integer departmentid; private Departments departmentById;
	 */
    @Embedded
    private CommonFields commonFields;
    public CommonFields getCommonFields() { return commonFields; }
    public void setCommonFields(CommonFields commonFields) { this.commonFields =
            commonFields; }



    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonConstants that = (CommonConstants) o;
        return id == that.id &&
                Objects.equals(code, that.code) &&
                Objects.equals(description, that.description) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, description, value,id);
    }
    @Override
    public String toString() {
        return "CommonConstants{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", value='" + value + '\'' +
                ", id=" + id +
                '}';
    }

    @Transient
    public Integer getCommonUserId() {
        return commonUserId;
    }

    public void setCommonUserId(Integer commonUserId) {
        this.commonUserId = commonUserId;
    }
	
    
    
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "departmentid",referencedColumnName = "id",insertable =
	 * false,updatable = false) public Departments getDepartmentById() { return
	 * departmentById; } public void setDepartmentById(Departments departmentById) {
	 * this.departmentById = departmentById; } public Integer getDepartmentid() {
	 * return departmentid; } public void setDepartmentid(Integer departmentid) {
	 * this.departmentid = departmentid; }
	 */
    
    
    
    
}
