package com.Tienda_IIIQK.service.impl;

import com.Tienda_IIIQK.dao.CategoriaDao;
import com.Tienda_IIIQK.domain.Categoria;
import com.Tienda_IIIQK.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //esta anotacion siempre va en la impl
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)//es una transaccion de la base de datos pero unicamente de lectura
    public List<Categoria> getCategorias(boolean activos) {

        List<Categoria> categorias = categoriaDao.findAll(); //se trae todo lo que esta en la base de datos

        if (activos) {
            categorias.removeIf(c -> !c.isActivo()); //esta filtrando todos los inactivos
        }
        return categorias;
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);//me busco el id de la categoria y me lo traigo

    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

}
