package com.filespace.impls;

import com.filespace.entity.User;
import com.filespace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class ImplsUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = null;
        try {
            user = service.findByLogin(login);
        } catch (NoResultException ex) {
            ex.printStackTrace();
            throw new UsernameNotFoundException("Usuário/Senha inválidos");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new UsernameNotFoundException(ex.getMessage());
        }
        return user;
    }
}
