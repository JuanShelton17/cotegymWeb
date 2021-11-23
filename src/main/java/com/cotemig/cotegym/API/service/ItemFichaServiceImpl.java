package com.cotemig.cotegym.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.cotegym.API.model.ItemFicha;
import com.cotemig.cotegym.API.repository.ItemFichaRepository;


@Service("itemFichaService")
public class ItemFichaServiceImpl implements ItemFichaService{

	@Autowired
	ItemFichaRepository repository;
	
	@Override
	public Optional<ItemFicha> getItemFichaById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<ItemFicha> getAllItensFicha() {
		return repository.findAll();
	}

	@Override
	public void deleteAllItensFicha() {
		repository.deleteAll();
	}

	@Override
	public void deleteItemFichaById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void updateItemFichaById(Integer id, ItemFicha itemFicha) {

		 Optional<ItemFicha> getItemFicha = getItemFichaById(id);
		 getItemFicha.get().setDescanso(itemFicha.getDescanso());
		 getItemFicha.get().setDescricao(itemFicha.getDescricao());
		 getItemFicha.get().setRepeticao(itemFicha.getRepeticao());
		 getItemFicha.get().setSerie(itemFicha.getSerie());
		 
		 repository.save(getItemFicha.get());
	}

	@Override
	public void updateItemFicha(ItemFicha itemFicha) {
		repository.save(itemFicha);
	}

	@Override
	public void insertItemFicha(ItemFicha itemFicha) {
		repository.save(itemFicha);
	}
}
