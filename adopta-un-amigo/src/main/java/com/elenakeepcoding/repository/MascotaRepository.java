package com.elenakeepcoding.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.elenakeepcoding.model.Mascota;


public interface MascotaRepository extends PagingAndSortingRepository<Mascota, Long>{
	
	@EntityGraph(attributePaths = "propietario")
    Optional<Mascota> findById(Long id);
	
	@EntityGraph(attributePaths = "propietario")
    @Query("SELECT m FROM Mascota m WHERE LOWER(m.nombre) = LOWER(:nombre)")
    List<Mascota> findByNombreIgnoreCase(@Param("nombre") String nombre);
	
	@EntityGraph(attributePaths = "propietario")
    @Query("SELECT m FROM  Mascota m LEFT JOIN FETCH m.propietario")
    List<Mascota> findAllWithPropietario();
    
    Page<Mascota> findAll(Pageable pageable);
	

}
