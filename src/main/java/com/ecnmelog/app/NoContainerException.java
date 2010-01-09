package com.ecnmelog.app;


/** Exception levée lorsqu'on essaye d'interagir avec un container qui n'existe pas*/
class NoContainerException extends Exception{
	public NoContainerException(String message){
		super(message);
	}
}
