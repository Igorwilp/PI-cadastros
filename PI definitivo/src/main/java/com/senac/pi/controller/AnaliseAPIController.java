/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.pi.controller;

import com.senac.pi.model.Analise;
import com.senac.pi.model.Atividade;
import com.senac.pi.service.AnaliseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analise")
public class AnaliseAPIController {

    @Autowired
    AnaliseService analiseService;

    //cadastrar
    @PostMapping("/adicionar")
    public ResponseEntity<Analise> criar(@RequestBody Analise analise) {
        Analise novaAnalise = analiseService.criar(analise);
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED);
    }

    @GetMapping("/pesquisa/{idAtividade}")
    public ResponseEntity<List> listarComentarios(@PathVariable int idAtividade) {
        List<Analise> lista = analiseService.buscarTodosPeloIdAtividade(idAtividade);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PutMapping("/atualizaranalise/{idAtividade}")
    public ResponseEntity<Analise> atualizar(@PathVariable int idAtividade, @RequestBody Analise analise) {
        Analise analiseAtualizada = analiseService.atualizaranalise(idAtividade, analise);
        return new ResponseEntity<>(analiseAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{atividadeId}")
    public ResponseEntity<Analise> excluir(@PathVariable int atividadeId) {
        analiseService.excluir(atividadeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
