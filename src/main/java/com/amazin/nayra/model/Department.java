package com.amazin.nayra.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "departments")
public class Department implements Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String department;
	    private String department_desc;
	    private Integer status;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getDepartment_desc() {
			return department_desc;
		}
		public void setDepartment_desc(String department_desc) {
			this.department_desc = department_desc;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Department [id=" + id + ", department=" + department + ", department_desc=" + department_desc
					+ ", status=" + status + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((department == null) ? 0 : department.hashCode());
			result = prime * result + ((department_desc == null) ? 0 : department_desc.hashCode());
			result = prime * result + id;
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Department other = (Department) obj;
			if (department == null) {
				if (other.department != null)
					return false;
			} else if (!department.equals(other.department))
				return false;
			if (department_desc == null) {
				if (other.department_desc != null)
					return false;
			} else if (!department_desc.equals(other.department_desc))
				return false;
			if (id != other.id)
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			return true;
		}
	    
	    
	   
}
