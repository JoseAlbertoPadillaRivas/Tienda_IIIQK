package com.Tienda_IIIQK.service;

import com.Tienda_IIIQK.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
}
