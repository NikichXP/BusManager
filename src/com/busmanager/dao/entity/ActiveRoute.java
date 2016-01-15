package com.busmanager.dao.entity;

import java.util.Arrays;
import java.util.Date;
import com.busmanager.dao.CarDAO;
import com.googlecode.objectify.annotation.*;

@Subclass (index = true)
public class ActiveRoute extends Route {
	@Index
	private Date plannedTime;
	@Index
	private long plannedTimestamp;
	@Index
	private Car car;
	private boolean [] seats;
	@Index
	private int freeSeats;
	
	public ActiveRoute (long id, String title, String from, String to, String time, String day, String carId, String date) {
		super(id, title, from, to, time, day);
		this.car = CarDAO.getCar(carId);
		this.seats = new boolean [car.getSeats()];
		this.freeSeats = this.seats.length;
	}
	
	@Deprecated
	public ActiveRoute() {
		super();
	}
	public Date getPlannedTime() {
		return plannedTime;
	}
	public void setPlannedTime(Date plannedTime) {
		this.plannedTime = plannedTime;
	}
	public long getPlannedTimestamp() {
		return plannedTimestamp;
	}
	public void setPlannedTimestamp(long plannedTimestamp) {
		this.plannedTimestamp = plannedTimestamp;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public boolean[] getSeats() {
		return seats;
	}
	public void setSeats(boolean[] seats) {
		this.seats = seats;
	}
	public int getFreeSeats() {
		return freeSeats;
	}
	public void setFreeSeats(int freeSeats) {
		this.freeSeats = freeSeats;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + freeSeats;
		result = prime * result + ((plannedTime == null) ? 0 : plannedTime.hashCode());
		result = prime * result + (int) (plannedTimestamp ^ (plannedTimestamp >>> 32));
		result = prime * result + Arrays.hashCode(seats);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ActiveRoute other = (ActiveRoute) obj;
		if (car == null) {
			if (other.car != null) {
				return false;
			}
		} else if (!car.equals(other.car)) {
			return false;
		}
		if (freeSeats != other.freeSeats) {
			return false;
		}
		if (plannedTime == null) {
			if (other.plannedTime != null) {
				return false;
			}
		} else if (!plannedTime.equals(other.plannedTime)) {
			return false;
		}
		if (plannedTimestamp != other.plannedTimestamp) {
			return false;
		}
		if (!Arrays.equals(seats, other.seats)) {
			return false;
		}
		return true;
	}	
}
