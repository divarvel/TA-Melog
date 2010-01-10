// TODO : Quasiment tout ^^

package com.ecnmelog.controller;

import java.util.ArrayList;


import com.ecnmelog.model.AbstractModel;

public abstract class AbstractController {
	
	protected AbstractModel stock;
	
	public AbstractController(AbstractModel stock){
		this.stock = stock;
	}
	
	/**
	 * Méthode de contrôle
	 */
	abstract void control();
}
