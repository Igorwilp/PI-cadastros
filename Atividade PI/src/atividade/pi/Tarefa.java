package atividade.pi;

public class Tarefa {
    private String titulo;
    private String categoria;
    private String dataLimite;
    private String descricao;

    public Tarefa(String titulo, String categoria, String dataLimite, String descricao) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.dataLimite = dataLimite;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", dataLimite='" + dataLimite + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

