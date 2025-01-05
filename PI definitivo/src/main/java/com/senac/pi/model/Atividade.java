package com.senac.pi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Atividade")
public class Atividade {
    //private static int contadorId = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private String atividadeNome;
    private String materia;
    private int prazo;

    // Construtores
    public Atividade() {
        //this.id = contadorId++;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAtividadeNome() { return atividadeNome; }
    public void setAtividadeNome(String atividadeNome) { this.atividadeNome = atividadeNome; }
    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }
    public int getPrazo() { return prazo; }
    public void setPrazo(int prazo) { this.prazo = prazo; }
}

