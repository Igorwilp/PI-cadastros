package atividade.pi;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TarefaTableModel extends AbstractTableModel {
    private List<Tarefa> tarefas;
    private String[] colunas = {"Número", "Título", "Descrição", "Data Limite", "Categoria"};

    public TarefaTableModel() {
        this.tarefas = new ArrayList<>();
    }

    public void addTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
        fireTableRowsInserted(tarefas.size() - 1, tarefas.size() - 1);
    }

    @Override
    public int getRowCount() {
        return tarefas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tarefa tarefa = tarefas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1; // Número da linha
            case 1:
                return tarefa.getTitulo();
            case 2:
                return tarefa.getDescricao();
            case 3:
                return tarefa.getDataLimite();
            case 4:
                return tarefa.getCategoria();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
