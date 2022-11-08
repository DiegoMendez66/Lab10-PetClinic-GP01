package com.tecsup.petclinic.dto;

public class OwnerDTO {

	private long id;
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String telephone;
	public OwnerDTO(String first_name, String last_name, String address, String city, String telephone) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString() {
		return "OwnerDTO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
				+ ", city=" + city + ", telephone=" + telephone + "]";
	}
}
