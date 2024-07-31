package com.elenakeepcoding.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elenakeepcoding.model.Propietario;
import com.elenakeepcoding.repository.PropietarioRepository;

@Service
public class PropietarioService {
	 @Autowired
	    private PropietarioRepository propietarioRepository;

	    public Propietario getPropietarioById(Long id) {
	        return propietarioRepository.findById(id).orElse(null);
	    }

	    public Propietario savePropietario(Propietario propietario) {
	        return propietarioRepository.save(propietario);
	    }

	    public List<Propietario> getAllPropietarios() {
	        return StreamSupport.stream(propietarioRepository.findAll().spliterator(), false)
	                            .collect(Collectors.toList());
	    }
	    public void deletePropietario(Long id) {
	        propietarioRepository.deleteById(id);
	    }

}
