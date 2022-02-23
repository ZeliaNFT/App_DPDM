package ifnmg.edu.aplicativodpdm.helper;

import java.util.List;

import ifnmg.edu.aplicativodpdm.model.Tarefa;

public interface iTarefaDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);

    public List<Tarefa> listar();
}
