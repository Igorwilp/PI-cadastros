package com.senac.pi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Analise")
public class Analise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer atividadeId;
    
    @ManyToOne
    @JoinColumn(name = "id_atividade")
    private Atividade atividade;
    
    private String textoAnalise;

    public Analise() {}
    public Analise(int id, String textoAnalise) {
        this.atividadeId = id;
        this.textoAnalise = textoAnalise;
    }

    // Getters e Setters
    public int getAtividadeId() { return atividadeId; }
    public void setAtividadeId(int id) { this.atividadeId = id; }
    public Atividade getAtividade() { return atividade; }
    public void setAtividade(Atividade filme) { this.atividade = atividade; }
    public String getTextoAnalise() { return textoAnalise; }
    public void setTextoAnalise(String textoAnalise) { this.textoAnalise = textoAnalise; }
}
