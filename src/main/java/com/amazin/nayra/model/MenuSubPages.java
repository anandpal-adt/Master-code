package com.amazin.nayra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "menu_sub_pages")
@Where(clause = "is_deleted = 0")
public class MenuSubPages {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private Integer displayorder;
	    private String url;
	    private String menuMainSubPage;
	   @ManyToOne
	    @JoinColumn(name = "menu_main_id", referencedColumnName = "id", nullable = true,insertable = false ,updatable = false)
	   private MenuMain menuMain;
	    @Transient
	    private Integer commonUserId;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getDisplayorder() {
			return displayorder;
		}
		public void setDisplayorder(Integer displayorder) {
			this.displayorder = displayorder;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getMenuMainSubPage() {
			return menuMainSubPage;
		}
		public void setMenuMainSubPage(String menuMainSubPage) {
			this.menuMainSubPage = menuMainSubPage;
		}
		public MenuMain getMenuMain() {
			return menuMain;
		}
		public void setMenuMain(MenuMain menuMain) {
			this.menuMain = menuMain;
		}
		public Integer getCommonUserId() {
			return commonUserId;
		}
		public void setCommonUserId(Integer commonUserId) {
			this.commonUserId = commonUserId;
		}
		public MenuSubPages(Integer id, Integer displayorder, String url, String menuMainSubPage, MenuMain menuMain,
				Integer commonUserId) {
			super();
			this.id = id;
			this.displayorder = displayorder;
			this.url = url;
			this.menuMainSubPage = menuMainSubPage;
			//this.menuMain = menuMain;
			this.commonUserId = commonUserId;
		}
	    
	    

}
