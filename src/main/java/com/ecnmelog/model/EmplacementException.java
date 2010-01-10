package com.ecnmelog.model;


/** Exception levée lorsqu'on fait des trucs interdits avec un emplacement*/
public class EmplacementException extends Exception{
	public EmplacementException(String message){
		super(message);
	}
}
