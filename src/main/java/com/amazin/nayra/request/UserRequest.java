package com.amazin.nayra.request;

import java.util.Date;

public class UserRequest {
	
	private String uniqueId;
	private String username;
	private String firstname;
	private String lastname;
	private String passwordhash;
	private String passwordsalt;
	private String plantname;
	private String email;
	private String contact;
	private String managername;
	private String address;
	private String city;
	private Integer roleId;
	private Integer departmentId;
	private String remarks;
    private Integer isSsoEnabled;
    private Date userLastloginDatetime;
    private String accessToken;
    private Date accessTokenExpiryDatetime;
    private int isSuperadmin;
    private Integer invalidLoginAttempts;
    private String lastFivePwds;
    private String apiAccessToken;
    private Date pwdResetDate;
	private Integer resetPasswordCount;
	private Integer changePasswordCount;
	private Date resetPasswordDate;
	private Date changePasswordDate;
	private Integer status;
	private String role;
	private String department;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
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
	public String getPlantname() {
		return plantname;
	}
	public void setPlantname(String plantname) {
		this.plantname = plantname;
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
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
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
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getIsSsoEnabled() {
		return isSsoEnabled;
	}
	public void setIsSsoEnabled(Integer isSsoEnabled) {
		this.isSsoEnabled = isSsoEnabled;
	}
	public Date getUserLastloginDatetime() {
		return userLastloginDatetime;
	}
	public void setUserLastloginDatetime(Date userLastloginDatetime) {
		this.userLastloginDatetime = userLastloginDatetime;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Date getAccessTokenExpiryDatetime() {
		return accessTokenExpiryDatetime;
	}
	public void setAccessTokenExpiryDatetime(Date accessTokenExpiryDatetime) {
		this.accessTokenExpiryDatetime = accessTokenExpiryDatetime;
	}
	public int getIsSuperadmin() {
		return isSuperadmin;
	}
	public void setIsSuperadmin(int isSuperadmin) {
		this.isSuperadmin = isSuperadmin;
	}
	public Integer getInvalidLoginAttempts() {
		return invalidLoginAttempts;
	}
	public void setInvalidLoginAttempts(Integer invalidLoginAttempts) {
		this.invalidLoginAttempts = invalidLoginAttempts;
	}
	public String getLastFivePwds() {
		return lastFivePwds;
	}
	public void setLastFivePwds(String lastFivePwds) {
		this.lastFivePwds = lastFivePwds;
	}
	public String getApiAccessToken() {
		return apiAccessToken;
	}
	public void setApiAccessToken(String apiAccessToken) {
		this.apiAccessToken = apiAccessToken;
	}
	public Date getPwdResetDate() {
		return pwdResetDate;
	}
	public void setPwdResetDate(Date pwdResetDate) {
		this.pwdResetDate = pwdResetDate;
	}
	public Integer getResetPasswordCount() {
		return resetPasswordCount;
	}
	public void setResetPasswordCount(Integer resetPasswordCount) {
		this.resetPasswordCount = resetPasswordCount;
	}
	public Integer getChangePasswordCount() {
		return changePasswordCount;
	}
	public void setChangePasswordCount(Integer changePasswordCount) {
		this.changePasswordCount = changePasswordCount;
	}
	public Date getResetPasswordDate() {
		return resetPasswordDate;
	}
	public void setResetPasswordDate(Date resetPasswordDate) {
		this.resetPasswordDate = resetPasswordDate;
	}
	public Date getChangePasswordDate() {
		return changePasswordDate;
	}
	public void setChangePasswordDate(Date changePasswordDate) {
		this.changePasswordDate = changePasswordDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
