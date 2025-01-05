/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.senac.pi.repository;

import com.senac.pi.model.Analise;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author igorw
 */
@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Integer>{
    List<Analise> findByAtividadeId(int atividadeId);
}
