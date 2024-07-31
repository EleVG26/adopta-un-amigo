package com.elenakeepcoding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.elenakeepcoding.model.Mascota;
import com.elenakeepcoding.model.Propietario;
import com.elenakeepcoding.repository.MascotaRepository;
import com.elenakeepcoding.repository.PropietarioRepository;

@Service
public class MascotaService {
	
	@Autowired
	private MascotaRepository mascotaRepository;
	
	@Autowired
	private PropietarioRepository propietarioRepository;
	
	public Mascota getMascotaById(Long id) {
		return mascotaRepository.findById(id).orElse(null);
	}
	
	 public List<Mascota> getMascotaByNombre(String nombre) {
	        return mascotaRepository.findByNombreIgnoreCase(nombre);
	    }
	 
	 public List<Mascota> getYoungestMascotas(int count) {
	        Pageable pageable = PageRequest.of(0, count, Sort.by(Sort.Direction.ASC, "fechaNac"));
	        return mascotaRepository.findAll(pageable).getContent();
	    }

	    public Page<Mascota> getAllMascotas(Pageable pageable) {
	        return mascotaRepository.findAll(pageable);
	    }

	    public void deleteMascota(Long id) {
	        mascotaRepository.deleteById(id);
	    }
	          
	    public List<Mascota> getAllMascotaWithPropietario() {
	        List<Mascota> mascotas = mascotaRepository.findAllWithPropietario();
	        return mascotas;
	    }

	    
    public Mascota saveMascota(Mascota mascota, Long propietarioId) {
        if (propietarioId != null) {
            Optional<Propietario> propietario = propietarioRepository.findById(propietarioId);
            propietario.ifPresent(mascota::setPropietario);
        }
        return mascotaRepository.save(mascota);
    }
}
