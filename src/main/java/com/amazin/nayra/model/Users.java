package com.amazin.nayra.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.amazin.nayra.common.CommonFields;
import com.amazin.nayra.util.DateFormatMapping;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "users")
public class Users implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//private String unique_id;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private String passwordhash;
	private String passwordsalt;
	private String plant_name;
	private String email;
	private String contact;
	private String manager_name;
	private String address;
	private String city;
	private String otp;

	@OneToOne(targetEntity = Role.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Role role;

	@ManyToOne(targetEntity = Department.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
	private Department department;
	@Column(name="department_id")
	public Integer departmentId;
	@Column(name="role_id")
	public Integer roleId;

	private String remarks;
	private Integer is_sso_enabled;
	@JsonFormat(pattern = DateFormatMapping.defaultDateTimeFormat, timezone = DateFormatMapping.defaultTimezone)
	private Date user_lastlogin_datetime;
	private String access_token;

	@JsonFormat(pattern = DateFormatMapping.defaultDateTimeFormat, timezone = DateFormatMapping.defaultTimezone)
	private Date access_token_expiry_datetime;
	private int is_superadmin;
	private Integer invalid_login_attempts;
	private String last_five_pwds;
	private String api_access_token;

	private Integer reset_password_count;
	private Integer change_password_count;
	@JsonFormat(pattern = DateFormatMapping.defaultDateTimeFormat)
	private Date reset_password_date;
	@JsonFormat(pattern = DateFormatMapping.defaultDateTimeFormat)
	private Date change_password_date;
	private Integer status;
	
//	@ManyToOne
//	@JoinColumn(name = "map_roles_departments_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
//	private DepartmentRoleMap departmentsRolesMap;

//	@OneToMany(fetch = FetchType.LAZY)
//	@JoinColumn(name = "map_roles_departments_id", referencedColumnName = "map_roles_departments_id", nullable = false, insertable = false, updatable = false)
//	private List<MenuSubPagesRolesMap> menuSubPagesRolesMap;

//	@Embedded
//	private CommonFields commonFields;
	

	public Users(Users users) {

	}

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public String getUnique_id() {
//		return unique_id;
//	}
//
//	public void setUnique_id(String unique_id) {
//		this.unique_id = unique_id;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordhash() {
		return passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

	public String getPasswordsalt() {
		return passwordsalt;
	}

	public void setPasswordsalt(String passwordsalt) {
		this.passwordsalt = passwordsalt;
	}

	public String getPlant_name() {
		return plant_name;
	}

	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getIs_sso_enabled() {
		return is_sso_enabled;
	}

	public void setIs_sso_enabled(Integer is_sso_enabled) {
		this.is_sso_enabled = is_sso_enabled;
	}

	public Date getUser_lastlogin_datetime() {
		return user_lastlogin_datetime;
	}

	public void setUser_lastlogin_datetime(Date user_lastlogin_datetime) {
		this.user_lastlogin_datetime = user_lastlogin_datetime;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Date getAccess_token_expiry_datetime() {
		return access_token_expiry_datetime;
	}

	public void setAccess_token_expiry_datetime(Date access_token_expiry_datetime) {
		this.access_token_expiry_datetime = access_token_expiry_datetime;
	}

	public int getIs_superadmin() {
		return is_superadmin;
	}

	public void setIs_superadmin(int is_superadmin) {
		this.is_superadmin = is_superadmin;
	}

	public Integer getInvalid_login_attempts() {
		return invalid_login_attempts;
	}

	public void setInvalid_login_attempts(Integer invalid_login_attempts) {
		this.invalid_login_attempts = invalid_login_attempts;
	}

	public String getLast_five_pwds() {
		return last_five_pwds;
	}

	public void setLast_five_pwds(String last_five_pwds) {
		this.last_five_pwds = last_five_pwds;
	}

	public String getApi_access_token() {
		return api_access_token;
	}

	public void setApi_access_token(String api_access_token) {
		this.api_access_token = api_access_token;
	}

	public Integer getReset_password_count() {
		return reset_password_count;
	}

	public void setReset_password_count(Integer reset_password_count) {
		this.reset_password_count = reset_password_count;
	}

	public Integer getChange_password_count() {
		return change_password_count;
	}

	public void setChange_password_count(Integer change_password_count) {
		this.change_password_count = change_password_count;
	}

	public Date getReset_password_date() {
		return reset_password_date;
	}

	public void setReset_password_date(Date reset_password_date) {
		this.reset_password_date = reset_password_date;
	}

	public Date getChange_password_date() {
		return change_password_date;
	}

	public void setChange_password_date(Date change_password_date) {
		this.change_password_date = change_password_date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	

	



}
