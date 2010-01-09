package com.ecnmelog.app;


/** Exception levée lorsqu'on fait des trucs interdits avec un emplacement*/
class EmplacementException extends Exception{
	public EmplacementException(String message){
		super(message);
	}
}
