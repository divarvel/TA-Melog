//TODO : Tout

package com.ecnmelog.controller;

import com.ecnmelog.model.AbstractStockage;
import com.ecnmelog.model.AbstractAttente;

/**
 * Partie du contrôleur dédiée à la communication avec le modèle
 */
public class StockageController extends AbstractController {

	public StockageController(AbstractStockage stock, AbstractAttente att) {
		super(stock, att);
	}

	void control() {
		//On notifie le modèle d'une action si le contrôle est bon
		//--------------------------------------------------------
		
		
	}
}
