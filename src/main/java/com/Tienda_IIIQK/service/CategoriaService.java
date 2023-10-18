package com.Tienda_IIIQK.service;

import com.Tienda_IIIQK.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //retorna una lista de categorias activas o todas
    public List<Categoria> getCategorias(boolean activos);
    
    //retorna una categoria por id
    public Categoria getCategoria(Categoria categoria);
    
    //se inserta un nuevo registro si el id de la categoria esta vacio 
    //Se actualiza el registro si el id de la categoria no esta vacio (osea que la categoria tenga id)
    public void save(Categoria categoria);
    
    
    public void delete(Categoria categoria);
}
