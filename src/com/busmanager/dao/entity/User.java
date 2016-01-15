package com.busmanager.dao.entity;

import java.util.*;
import com.googlecode.objectify.annotation.*;

@Entity
public class User {
	
	@Id
	private long id;
    @Index 
    private String login;
    @Index 
    private String pass;
	private String name;
	private String surname;
	@Ignore
	private String token;
	
	@Deprecated	public User () {}
    
    public User (String login, String pass, String name, String surname) {
    	this.id = (long) (new Random().nextInt(99_999));
    	this.login = login;
    	this.name = name;
    	this.surname = surname;
    	this.pass = pass;
    	this.token = UUID.randomUUID().toString();
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getToken () {
		if (this.token == null) {
			this.token = UUID.randomUUID().toString();
		}
		return token;
	}
	
	public void setToken (String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", pass=" + pass + ", name=" + name + ", surname=" + surname
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	
	
        
}