package com.elenakeepcoding.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elenakeepcoding.model.Mascota;
import com.elenakeepcoding.service.MascotaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/mascotas")
@Api(value = "Mascota Management System")
public class DesignMascotaControllerApi {
    
	@Autowired
    private MascotaService mascotaService;

	//OBTENER TODAS LAS MASCOTAS
    @GetMapping
    @ApiOperation(value = "Get mascota by propietario")
	public List<Mascota> getAllMascotas() {
	    List<Mascota> mascotas = mascotaService.getAllMascotaWithPropietario();
	    return mascotas;
	} 
    
	//OBTENER MASCOTA POR ID
    @GetMapping("/{id}")
    @ApiOperation(value = "Get a mascota by Id")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Long id) {
		Mascota mascota = mascotaService.getMascotaById(id);
		if (mascota != null) {
			return ResponseEntity.ok(mascota);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

    //OBTENER MASCOTA POR SU NOMBRE
    @GetMapping("/nombre/{nombre}")
    @ApiOperation(value = "Get mascota by nombre")
	public List<Mascota> getMascotaByNombre(@PathVariable String nombre) {
		return mascotaService.getMascotaByNombre(nombre);
	}

    //CREAR UNA NUEVA MASCOTA
    @PostMapping
    @ApiOperation(value = "Create mascota")
    public ResponseEntity<Mascota> createMascota(@RequestBody Mascota mascota,
			@RequestParam(required = false) Long propietarioId) {
		Mascota savedMascota = mascotaService.saveMascota(mascota, propietarioId);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMascota);
	}
    

    
    //LISTAR LAS 20 MASCOTAS MAS JOVENES
    @GetMapping("/youngest")
    @ApiOperation(value = "Get mascotas 20 youngest")
    public List<Mascota> getYoungestMascotas() {
        return mascotaService.getYoungestMascotas(20);
    }

    //LISTAR DE A 5 MASCOTAS POR PAGINA
    @GetMapping("/page")
    @ApiOperation(value = "Get mascotas paginated")
    public Page<Mascota> getMascotasPaginated(@RequestParam(defaultValue = "0") int page) {
    	Pageable pageable = PageRequest.of(page, 5);
        //Page<Mascota> mascotasPage = mascotaService.getAllMascotas(pageable);
        return mascotaService.getAllMascotas(pageable);
    }

    //ELIMINAR MASCOTA POR ID
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete mascota by id")
    public void deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
    }

}
