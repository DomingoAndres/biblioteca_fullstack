package com.example.biblioteca2.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.biblioteca2.model.LibroModel;

import com.example.biblioteca2.repository.LibroRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<LibroModel> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public LibroModel getLibroId(int id){
        return libroRepository.buscarLibroPorId(id);
    }

    public LibroModel getLibroIsbn(String isbn){
        return libroRepository.buscarLibroPorIsbn(isbn);
    }


    public LibroModel getLibroAutor(String autor){
        return libroRepository.buscarLibroPorAutor(autor);
    }

    public LibroModel updateLibro(LibroModel lib){
        return libroRepository.actualizar(lib);
    }


    public void deleteLibro(int id){
        libroRepository.eliminar(id);
        System.out.println("Libro eliminado.");
    }

    public LibroModel saveBook(LibroModel libro){
        return libroRepository.guardarLibro(libro);
    }

    public int totalBooks(){
        return libroRepository.librosTotales();
    }







}
