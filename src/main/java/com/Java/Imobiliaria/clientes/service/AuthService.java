package com.Java.Imobiliaria.clientes.service;

import com.Java.Imobiliaria.clientes.repository.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final ClientesRepository clientesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     return clientesRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuário ou senha inválidos"));
    }



}
