package com.autoservices.web.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.autoservice.ejbs.object.ShoppingCartItem;
import com.autoservice.ejbs.object.ShoppingCartService;
import com.autoservice.exceptions.InvalidItemException;
import com.autoservice.exceptions.NotExistsException;
import com.autoservices.web.util.CartUtil;
import com.autoservices.web.util.objects.CartVehicle;

public class ServiceItem {

	private int type; // ids de servicios { 1: aceite, 2: tintado, 3: bateria, 4:cerrajeria, 5:tune up, 6:gomas }
	private Object objectService; // servicios {aceite, tintado, bateria, cerrajeria, tune up, gomas
	private CartVehicle vehicle;
	private Date startServiceTime;
	private String fecha;
	private String horario;
	private Date endServiceTime;
	private ServiceAddress address;
	//private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
	// dateFormat.format(new Date(startServiceTime))
	public ServiceItem(int type, Object objectService, CartVehicle vehicle,
			Date startServiceTime, ServiceAddress address) {
		super();
		this.type = type;
		this.objectService = objectService;
		this.vehicle = vehicle;
		this.startServiceTime = startServiceTime;
		this.address = address;
	}
	
	public ServiceItem(ShoppingCartService service) throws InvalidItemException {
		try {
			load(service);
		} catch (NotExistsException e) {
			e.printStackTrace();
			throw new InvalidItemException("Veh�culo invalido");
		} catch (InvalidItemException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Object getObjectService() {
		return objectService;
	}
	public void setObjectService(Object objectService) {
		this.objectService = objectService;
	}
	public CartVehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(CartVehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Date getStartServiceTime() {
		return startServiceTime;
	}
	public void setStartServiceTime(Date startServiceTime) {
		this.startServiceTime = startServiceTime;
	}
	public Date getEndServiceTime() {
		return endServiceTime;
	}
	public void setEndServiceTime(Date endServiceTime) {
		this.endServiceTime = endServiceTime;
	}

	public ServiceAddress getAddress() {
		return address;
	}

	public void setAddress(ServiceAddress address) {
		this.address = address;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "ServiceItem [address=" + address + ", endServiceTime="
				+ endServiceTime + ", fecha=" + fecha + ", horario=" + horario
				+ ", objectService=" + objectService + ", startServiceTime="
				+ startServiceTime + ", type=" + type + ", vehicle=" + vehicle
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result
				+ ((objectService == null) ? 0 : objectService.hashCode());
		result = prime * result + type;
		result = prime * result + ((vehicle == null) ? 0 : vehicle.hashCode());
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
		ServiceItem other = (ServiceItem) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (objectService == null) {
			if (other.objectService != null)
				return false;
		} else if (!objectService.equals(other.objectService))
			return false;
		if (type != other.type)
			return false;
		if (vehicle == null) {
			if (other.vehicle != null)
				return false;
		} else if (!vehicle.equals(other.vehicle))
			return false;
		return true;
	}

	public void load(ShoppingCartService service) throws NotExistsException, InvalidItemException {
		type = service.getType();
		startServiceTime = service.getStartServiceTime();
		endServiceTime = service.getEndServiceTime();
		address = new ServiceAddress(service.getAddress());
		vehicle = new CartVehicle(service.getVehicle());
		objectService = CartUtil.getObjectFromShoppingCartObject(service);
		fecha = service.getFecha();
		horario = service.getHorario();
	}	

	
}
