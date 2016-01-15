package com.busmanager.dao.entity;

import java.util.*;
import com.googlecode.objectify.annotation.*;

@Entity
public class Car {
	
	@Id
	private long id;
	@Index
	private String model;
	@Index
	private int seats;
	
	public Car() {}
	public Car (String model, int seats) {
		this.id = (long) (new Random().nextInt(99_999));
		this.model = model;
		this.seats = seats;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + seats;
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
		Car other = (Car) obj;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (seats != other.seats)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", seats=" + seats + "]";
	}
	
}
