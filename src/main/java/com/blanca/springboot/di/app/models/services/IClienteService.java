package com.blanca.springboot.di.app.models.services;

import java.util.List;

import com.blanca.springboot.di.app.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public Cliente finById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);

	public Boolean verify(String user, String passw);
}
