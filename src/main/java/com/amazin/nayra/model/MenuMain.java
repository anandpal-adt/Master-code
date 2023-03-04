package com.amazin.nayra.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "main_menu")
public class MenuMain {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String main_menu_name;
    private String main_menu_desc;
    private int displayorder;
    private Integer status;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMain_menu_name() {
		return main_menu_name;
	}
	public void setMain_menu_name(String main_menu_name) {
		this.main_menu_name = main_menu_name;
	}
	public String getMain_menu_desc() {
		return main_menu_desc;
	}
	public void setMain_menu_desc(String main_menu_desc) {
		this.main_menu_desc = main_menu_desc;
	}
	public int getDisplayorder() {
		return displayorder;
	}
	public void setDisplayorder(int displayorder) {
		this.displayorder = displayorder;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "MenuMain [id=" + id + ", main_menu_name=" + main_menu_name + ", main_menu_desc=" + main_menu_desc
				+ ", displayorder=" + displayorder + ", status=" + status + "]";
	}
    


    
	

}
