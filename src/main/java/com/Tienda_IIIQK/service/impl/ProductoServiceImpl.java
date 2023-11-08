/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IIIQK.service.impl;

/**
 *
 * @author josep
 */
import com.Tienda_IIIQK.dao.ProductoDao;
import com.Tienda_IIIQK.domain.Producto;
import com.Tienda_IIIQK.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService{
    
     @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> productos = productoDao.findAll();
        
        if (activos) {
            productos.removeIf(c -> !c.isActivo());
        }
        return productos;
    }

    @Override
    public Producto getProducto(Producto producto) {
        return  productoDao.findById(producto.getIdProducto()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
}
