package com.amazin.nayra.common;

public enum AesGcm {
	KEY("UmtOTlJFOUNWMlZpUVhCdw=="), SECRET("UkU5Q1YyVmlRWEJ3T2taRA==");
	private String action;

	public String getAction() {
		return this.action;
	}

	private AesGcm(String action) {
		this.action = action;
	}

}
