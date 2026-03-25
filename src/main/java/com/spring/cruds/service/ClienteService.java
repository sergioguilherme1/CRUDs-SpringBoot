package com.spring.cruds.service;

import com.spring.cruds.entity.Cliente;
import com.spring.cruds.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientes(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public void deletarClientes(Long id) {
        clienteRepository.deleteById(id);
    }
}