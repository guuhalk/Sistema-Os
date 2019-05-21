package com.os.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.os.generico.GenericBean;




@ManagedBean
@ViewScoped
public class NewOsBean extends GenericBean {

	private Integer radio;

	public Integer getRadio() {
		return radio;
	}

	public void setRadio(Integer radio) {
		this.radio = radio;
	}
	
	
	
	
}
