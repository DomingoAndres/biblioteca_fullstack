package com.example.biblioteca2.controller;
import com.example.biblioteca2.model.LibroModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca2.service.LibroService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;


    @GetMapping
    public List<LibroModel> obtenerLibros(){
        return libroService.getLibros();
    }

   // @PostMapping
    //public LibroModel agregarLibro(@RequestBody LibroModel libro){
        //return libroService.saveBook(libro);
    //}

    @GetMapping("{id}")
    public LibroModel buscarLibroPorId(@PathVariable int id){
        return libroService.getLibroId(id);
    }
    
    
    @GetMapping("/isbn/{isbn}")
    public LibroModel buscarLibroPorIsbn(@PathVariable String isbn){
        return libroService.getLibroIsbn(isbn);
    }

    @GetMapping("/autores/{autor}")
    public LibroModel buscarLibroPorAutor(@PathVariable String autor){
        return libroService.getLibroAutor(autor);
    }

    @PutMapping("{id}")
    public LibroModel actualizarLibro(@PathVariable int id, @RequestBody LibroModel lib){
        return libroService.updateLibro(lib);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        libroService.deleteLibro(id);
        return "Libro eliminado.";
    }

    @PostMapping
    public LibroModel guardarLibro(@RequestBody LibroModel libro){
        return libroService.saveBook(libro);
    }




}
