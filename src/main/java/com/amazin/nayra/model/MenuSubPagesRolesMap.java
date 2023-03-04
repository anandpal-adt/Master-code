package com.amazin.nayra.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menusubpagesmap")
public class MenuSubPagesRolesMap {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String menuSubPages;
	//private MenuSubPages menuSubPagesByMenuSubPagesId;
	//private DepartmentRoleMap departmentsRoleMap;
	//private List<Integer> menuSubPagesIdList;
	private String status;
	private Integer commonUserId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuSubPages() {
		return menuSubPages;
	}
	public void setMenuSubPages(String menuSubPages) {
		this.menuSubPages = menuSubPages;
	}
//	public MenuSubPages getMenuSubPagesByMenuSubPagesId() {
//		return menuSubPagesByMenuSubPagesId;
//	}
//	public void setMenuSubPagesByMenuSubPagesId(MenuSubPages menuSubPagesByMenuSubPagesId) {
//		this.menuSubPagesByMenuSubPagesId = menuSubPagesByMenuSubPagesId;
//	}
//	public DepartmentRoleMap getDepartmentsRoleMap() {
//		return departmentsRoleMap;
//	}
//	public void setDepartmentsRoleMap(DepartmentRoleMap departmentsRoleMap) {
//		this.departmentsRoleMap = departmentsRoleMap;
//	}	public List<Integer> getMenuSubPagesIdList() {
//		return menuSubPagesIdList;
//	}
//	public void setMenuSubPagesIdList(List<Integer> menuSubPagesIdList) {
//		this.menuSubPagesIdList = menuSubPagesIdList;
//	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCommonUserId() {
		return commonUserId;
	}
	public void setCommonUserId(Integer commonUserId) {
		this.commonUserId = commonUserId;
	}
	
}
