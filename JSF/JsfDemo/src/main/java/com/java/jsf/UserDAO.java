package com.java.jsf;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sun.faces.context.SessionMap;

@ManagedBean
@SessionScoped
public class UserDAO {

	public String validate(User user){
		if(user.getUserName().equals("Sujay")&& user.getPassCode().equals("1234")){
			//return "Correct Credential...";
			return "menu.xhtml?faces-redirect=true";
		}else{
		Map<String,Object> SessionMap =FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		SessionMap.put("errMsg", "Invalid Credential");
		
		return "userInput.xhtml?faces-redirect=true ";
		//return "Invalid Credential...";
		}
	}
}
