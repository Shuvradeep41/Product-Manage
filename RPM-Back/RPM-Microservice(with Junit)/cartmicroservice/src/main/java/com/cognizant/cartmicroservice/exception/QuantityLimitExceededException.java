package com.cognizant.cartmicroservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@EqualsAndHashCode(callSuper = true)
public class QuantityLimitExceededException extends Exception{

	private static final long serialVersionUID = 1L;

	public QuantityLimitExceededException(String message) {
		super(message);
	}

}
