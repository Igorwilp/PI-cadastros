/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senac.pi.controller;

import com.senac.pi.model.Atividade;
import com.senac.pi.service.AtividadeService;

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
@RequestMapping("/atividade")
public class AtividadeAPIController {
    
    @Autowired
    AtividadeService atividadeService;
    
    //cadastrar
    @PostMapping("/adicionar")
    public ResponseEntity<Atividade> criar (@RequestBody Atividade atividade){
       Atividade novaAtividade = atividadeService.criar(atividade);
       return new ResponseEntity<>(novaAtividade,HttpStatus.CREATED);
    }
    
    @GetMapping("/listarTodos")
    public ResponseEntity<List> listar(){
        List<Atividade> listarTodosAtividades = atividadeService.buscarTodos();
        return new ResponseEntity<>(listarTodosAtividades,HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Atividade> buscar(@PathVariable int id){
        Atividade atividadeEncontrada = atividadeService.buscarPorId(id);
        return new ResponseEntity<>(atividadeEncontrada,HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Atividade> atualizar(@PathVariable int id, @RequestBody Atividade atividade){
        Atividade atividadeAtualizada = atividadeService.atualizar(id, atividade);
        return new ResponseEntity<>(atividadeAtualizada,HttpStatus.OK);
    }
    
    
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Atividade> excluir(@PathVariable int id){
        atividadeService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }    
    
    
    
    
}
