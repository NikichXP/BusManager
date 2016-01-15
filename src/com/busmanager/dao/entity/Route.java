package com.busmanager.dao.entity;

import java.util.Arrays;

import com.busmanager.dao.CarDAO;
import com.busmanager.dao.CityDAO;
import com.googlecode.objectify.annotation.*;
import static com.googlecode.objectify.ObjectifyService.ofy;

@Entity
public class Route {

	@Id
	private long id;
	@Index
	private String title;
	@Index
	private City from;
	@Index
	private City to;
	@Index
	private String time;
	@Index
	private boolean[] days;
	@Index
	private Car car;

	@Deprecated
	public Route() {
	}

	public Route(long id, String title, long from, long to, String time, long car) {
		this.id = id;
		this.title = title;
		this.from = (City) ofy().load().kind("City").id(from).now();
		this.to = (City) ofy().load().kind("City").id(to).now();
		this.time = time;
		this.car = (Car) ofy().load().kind("Car").id(car).now();
	}

	public Route(long id, String title, String from, String to, String time, String day, String carId) {
		this.id = id;
		this.title = title;
		this.from = CityDAO.findByName(from);
		this.to = CityDAO.findByName(to);
		this.time = time;
		this.car = CarDAO.getCar(id);
		this.days = new boolean[7];
		for (char c : day.toCharArray()) {
			switch (c) {
			case 'm':
			case 'M':
				days[0] = true;
				break;
			case 't':
			case 'T':
				days[1] = true;
				break;
			case 'w':
			case 'W':
				days[2] = true;
				break;
			case 'h':
			case 'H':
				days[3] = true;
				break;
			case 'f':
			case 'F':
				days[4] = true;
				break;
			case 's':
			case 'S':
				days[5] = true;
				break;
			case 'u':
			case 'U':
				days[6] = true;
				break;
			}
		}
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public City getFrom() {
		return from;
	}

	public void setFrom(City from) {
		this.from = from;
	}

	public City getTo() {
		return to;
	}

	public void setTo(City to) {
		this.to = to;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean[] getDays() {
		return days;
	}

	public void setDays(boolean[] days) {
		this.days = days;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + Arrays.hashCode(days);
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = (int) (prime * result + id);
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Route other = (Route) obj;
		if (car == null) {
			if (other.car != null) {
				return false;
			}
		} else if (!car.equals(other.car)) {
			return false;
		}
		if (!Arrays.equals(days, other.days)) {
			return false;
		}
		if (from == null) {
			if (other.from != null) {
				return false;
			}
		} else if (!from.equals(other.from)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (time == null) {
			if (other.time != null) {
				return false;
			}
		} else if (!time.equals(other.time)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		if (to == null) {
			if (other.to != null) {
				return false;
			}
		} else if (!to.equals(other.to)) {
			return false;
		}
		return true;
	}
}
