package com.amazin.nayra.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amazin.nayra.common.CommonFields;

@Entity
@Table(name = "departmentrolemap")
public class DepartmentRoleMap {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @ManyToOne
	    @JoinColumn(name = "departments_id", referencedColumnName = "id", nullable = true,insertable = false ,updatable = false)
	    private Department department;
	    
	    @ManyToOne
	    @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = true,insertable = false ,updatable = false)
	    private Role role;
	    private Integer status;
	    
	    @Embedded
	    private CommonFields commonFields;
	    @Transient
	    private Integer commonUserId;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
		this.role = role;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public CommonFields getCommonFields() {
			return commonFields;
		}

		public void setCommonFields(CommonFields commonFields) {
			this.commonFields = commonFields;
		}

		public Integer getCommonUserId() {
			return commonUserId;
		}

		public void setCommonUserId(Integer commonUserId) {
			this.commonUserId = commonUserId;
		}

		@Override
		public String toString() {
			return "DepartmentRoleMap [id=" + id + ", status=" + status + ", commonFields=" + commonFields
					+ ", commonUserId=" + commonUserId + "]";
		}

	
		
		
	    

}
