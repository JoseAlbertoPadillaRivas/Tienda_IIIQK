package com.Tienda_IIIQK.controller;

import com.Tienda_IIIQK.domain.Categoria;
import com.Tienda_IIIQK.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        
        List<Categoria> listadoCategorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", listadoCategorias);//para la vista mando desde el controlador con el model todas las categorias
        model.addAttribute("totalCategorias", listadoCategorias.size());//para la vista mando la cantidad de categorias desde el controlador con el model

        return "/categoria/listado";
    }
    
}
