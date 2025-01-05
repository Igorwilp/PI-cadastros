/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.pi.service;

import com.senac.pi.model.Analise;
import com.senac.pi.model.Atividade;
import com.senac.pi.repository.AnaliseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author igorw
 */
@Service
public class AnaliseService {

    @Autowired
    AnaliseRepository analiseRepository;

    public Analise buscarPorId(int atividadeId) {
        return analiseRepository.findById(atividadeId).orElseThrow();
    }

    public Analise criar(Analise analise) {
        // analise.setFilmeId(null);
        analiseRepository.save(analise);
        return analise;
    }

    public void excluir(int atividadeId) {
        Analise analiseEncontrada = buscarPorId(atividadeId);
        analiseRepository.deleteById(analiseEncontrada.getAtividadeId());
    }

    public List<Analise> buscarTodosPeloIdAtividade(Integer atividadeId) {
        return analiseRepository.findByAtividadeId(atividadeId);
    }

    public Analise atualizaranalise(int atividadeId, Analise analise) {
        Analise analiseEncontrada = buscarPorId(atividadeId);
        analiseEncontrada.setTextoAnalise(analise.getTextoAnalise());

        analiseRepository.save(analise);
        return analise;
    }
}
