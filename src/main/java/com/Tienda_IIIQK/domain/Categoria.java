
package com.Tienda_IIIQK.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data //para la creacion automatica de set y get de los atributos
@Entity //Esta anotacion me dice que Categoria es una entidad
@Table(name = "categoria")/*el serializable hace que la entidad se pueda guardar en la base de datos*/  
public class Categoria implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    //crear los atributos de la base de datos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;//lo pongo en camelCase para que Hibernate lo transforme en id_categoria en la base
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    List <Producto> productos;
    
    public Categoria(){}

    public Categoria(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
    
    
}
