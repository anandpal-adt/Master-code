package com.amazin.nayra.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.amazin.nayra.common.CommonFields;

@Entity
@Table(name = "roles")
public class Role implements Serializable{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String roleName;
	    private String roleDesc;
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
		public String getRoleNme() {
			return roleName;
		}
		public void setRoleNme(String roleNme) {
			this.roleName = roleNme;
		}
		public String getRoleDesc() {
			return roleDesc;
		}
		public void setRoleDesc(String roleDesc) {
			this.roleDesc = roleDesc;
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
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((roleDesc == null) ? 0 : roleDesc.hashCode());
			result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
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
			Role other = (Role) obj;
			if (id != other.id)
				return false;
			if (roleDesc == null) {
				if (other.roleDesc != null)
					return false;
			} else if (!roleDesc.equals(other.roleDesc))
				return false;
			if (roleName == null) {
				if (other.roleName != null)
					return false;
			} else if (!roleName.equals(other.roleName))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Role [id=" + id + ", roleNme=" + roleName + ", roleDesc=" + roleDesc + ", status=" + status
					+ ", commonFields=" + commonFields + ", commonUserId=" + commonUserId + "]";
		}
	    
	    
		
	    
	    

}
