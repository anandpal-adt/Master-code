package com.amazin.nayra.common;
public class DataContainer
{
    private String msg;
    private Object Data;
    private Object Menumainlist;
    private String status;
    



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getMenumainlist() {
        return Menumainlist;
    }

    public void setMenumainlist(Object menumainlist) {
        Menumainlist = menumainlist;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

	/*
	 * public void setData(String data) { this.data = data; }
	 */
    
}
