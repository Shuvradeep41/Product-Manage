package com.cognizant.cartmicroservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@EqualsAndHashCode(callSuper=true)
@Getter
@Setter
@Data
public class CartEmptyException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CartEmptyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
