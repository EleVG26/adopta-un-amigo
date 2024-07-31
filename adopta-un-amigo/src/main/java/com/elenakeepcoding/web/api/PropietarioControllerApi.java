package com.elenakeepcoding.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elenakeepcoding.model.Propietario;
import com.elenakeepcoding.service.PropietarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Propietario Management System")
@RequestMapping("/api/propietarios")
public class PropietarioControllerApi {
	
	@Autowired
    private PropietarioService propietarioService;
	
	//LISTAR TODOS LOS PROPIETARIOS
    @GetMapping
    @ApiOperation(value = "Get all propietarios ")
    public List<Propietario> getAllPropietarios() {
        return propietarioService.getAllPropietarios();
    }

	//OBTENER PROPIETARIO POR ID
    @GetMapping("/{id}")
    @ApiOperation(value = "Get propietario by id")
    public Propietario getPropietarioById(@PathVariable Long id) {
        return propietarioService.getPropietarioById(id);
    }

    
    //CREAR PROPIETARIO NUEVO
    @ApiOperation(value = "Create propietario")
    @PostMapping
    public Propietario createPropietario(@RequestBody Propietario propietario) {
        return propietarioService.savePropietario(propietario);
    }

   
    
    //ELIMINAR PROPIETARIO POR ID
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete propietario by id")
    public void deletePropietario(@PathVariable Long id) {
        propietarioService.deletePropietario(id);
    }

}
