/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.pi.service;

import com.senac.pi.model.Atividade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senac.pi.repository.AtividadeRepository;

/**
 *
 * @author igorw
 */

@Service
public class AtividadeService {

    @Autowired
    AtividadeRepository atividadeRepository;

    public Atividade criar(Atividade atividade) {
        // filme.setId(null);
        atividadeRepository.save(atividade);
        return atividade;
    }

    public List<Atividade> buscarTodos() {
        return atividadeRepository.findAll();
    }

    public Atividade buscarPorId(int id) {
        return atividadeRepository.findById(id).orElseThrow();
    }

    public void excluir(int id) {
        Atividade atividadeEncontrada = buscarPorId(id);
        atividadeRepository.deleteById(atividadeEncontrada.getId());
    }

    public Atividade atualizar(int id, Atividade atividade) {
        Atividade atividadeEncontrada = buscarPorId(id);
        atividadeEncontrada.setTitulo(atividade.getTitulo());
        atividadeEncontrada.setAtividadeNome(atividade.getAtividadeNome());
        atividadeEncontrada.setMateria(atividade.getMateria());
        atividadeEncontrada.setPrazo(atividade.getPrazo());

        atividadeRepository.save(atividade);
        return atividade;
    }
}

