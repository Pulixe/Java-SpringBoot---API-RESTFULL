package com.blanca.springboot.di.app.models.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blanca.springboot.di.app.Database.ConexionMySQL;
import com.blanca.springboot.di.app.models.dao.IClienteDao;
import com.blanca.springboot.di.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
    @Autowired
    private IClienteDao clienteDao;
    
    private ConexionMySQL con = new ConexionMySQL();
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente finById(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Boolean verify(String user, String passw) {
		// TODO Auto-generated method stub
		try {
			con.ConectarBasedeDatos();
			String query = "SELECT email,password FROM clientes WHERE email="+'"'+user+'"'+" AND password="+'"'+passw+'"';
			con.resultado = con.sentencia.executeQuery(query);
			
			if (con.resultado.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException ex) {
			System.out.print(ex);
		}
		
	    return false;
		
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);
	}
	
	
	

}
