/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IIIQK.service.impl;

import com.Tienda_IIIQK.dao.UsuarioDao;
import com.Tienda_IIIQK.domain.Rol;
import com.Tienda_IIIQK.domain.Usuario;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.Tienda_IIIQK.service.UsuarioDetailsService;

@Service("UserDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional (readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //buscar el usuario por el username en la base de datos
      Usuario usuario = usuarioDao.findByUsername(username);
      //sino exxiste el usuario lanza una excepcion
      if(usuario == null){
          throw new UsernameNotFoundException(username);
      }
      //si llega aqui es porque el usuario existe en la bd
      //remover atributos de la sesion 
      session.removeAttribute("usuarioImagen");
      session.setAttribute("usuarioImagen", usuario.getRutaImagen());
      var roles = new ArrayList<GrantedAuthority>();
      //transformar roles a granted authority
      for (Rol item : usuario.getRoles()){
          roles.add(new SimpleGrantedAuthority(item.getNombre()));
          
      }
      return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

}
