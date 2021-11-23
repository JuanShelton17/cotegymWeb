package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.cotegym.API.model.ItemFicha;


public interface ItemFichaService {

	Optional<ItemFicha> getItemFichaById(Integer id);
	List<ItemFicha> getAllItensFicha();
	void deleteAllItensFicha();
	void deleteItemFichaById(Integer id);
	void updateItemFichaById(Integer id, ItemFicha itemFicha);
	void updateItemFicha(ItemFicha itemFicha);
	void insertItemFicha(ItemFicha itemFicha);
}
