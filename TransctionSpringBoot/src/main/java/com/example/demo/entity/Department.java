package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Department {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	
	private long departId;
	private String departName;
	private String depatCode;
	/**
	 * @return the departId
	 */
	public long getDepartId() {
		return departId;
	}
	/**
	 * @param departId the departId to set
	 */
	public void setDepartId(long departId) {
		this.departId = departId;
	}
	/**
	 * @return the departName
	 */
	public String getDepartName() {
		return departName;
	}
	/**
	 * @param departName the departName to set
	 */
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	/**
	 * @return the depatCode
	 */
	public String getDepatCode() {
		return depatCode;
	}
	/**
	 * @param depatCode the depatCode to set
	 */
	public void setDepatCode(String depatCode) {
		this.depatCode = depatCode;
	}
	
	
	}


