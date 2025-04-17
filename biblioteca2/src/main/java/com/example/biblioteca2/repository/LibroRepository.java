package com.example.biblioteca2.repository;

import com.example.biblioteca2.model.LibroModel;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;


@Repository
public class LibroRepository {

    private List<LibroModel> listaLibros = new ArrayList<>();

    @PostConstruct
    public void init(){

        listaLibros.add(new LibroModel(1, "978-0134685991", "Effective Java", "Addison-Wesley", 2018, "Joshua Bloch"));

        listaLibros.add(new LibroModel(2, "978-1617294945", "Spring in Action", "Manning", 2020, "Craig Walls"));

        listaLibros.add(new LibroModel(3, "978-1491950357", "Designing Data-Intensive Applications", "O'Reilly Media", 2017, "Martin Kleppmann"));

        listaLibros.add(new LibroModel(4, "978-0132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));
    }

    public List<LibroModel> obtenerLibros(){
        return listaLibros;
    }

    public LibroModel buscarLibroPorId(int id){
        
        for(LibroModel libro : listaLibros){
            if(libro.getId() == id) return libro;
        }
        return null;
    }

    //buscar libro por isbn
    public LibroModel buscarLibroPorIsbn(String isbn){  
        
        for(LibroModel libro : listaLibros){
            if(libro.getIsbn() == isbn) return libro;
        }
        return null;
    }

    //buscar por autor
    public LibroModel buscarLibroPorAutor(String autor){
        
        for(LibroModel libro : listaLibros){
            if(libro.getAutor() == autor) return libro;
        }
        return null;
    }


    public LibroModel actualizar(LibroModel lib){
        
        int id = 0;
        int idPosicion = 0;

        for(int i = 0;i<listaLibros.size();i++){
            if(listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }
        LibroModel libro1 = new LibroModel();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);
        return libro1;
    }


    public void eliminar(int id){
        //Altyernativa 1

        LibroModel libro = buscarLibroPorId(id);
        if(libro != null) listaLibros.remove(libro);

        //Alternativa 2

        int idPosicion = 0;
        for(int i=0;i<listaLibros.size();i++){
            if(listaLibros.get(i).getId() == id){
                idPosicion = i;
                break;
            }
        }
        if(idPosicion > 0){
            listaLibros.remove(idPosicion);
        }

        //Alternativa 3

        listaLibros.removeIf((x) -> x.getId() == id);
    }

    public LibroModel guardarLibro(LibroModel libro){
        listaLibros.add(libro);
        return libro;
    }

    public int librosTotales(){
        return listaLibros.size();
    }

}

