package com.ecnmelog.model;


/** Exception levée lorsqu'on essaye de faire des trucs pas nets avec les containers*/
public class ContainerException extends Exception{
	public ContainerException(String message){
		super(message);
	}
}
