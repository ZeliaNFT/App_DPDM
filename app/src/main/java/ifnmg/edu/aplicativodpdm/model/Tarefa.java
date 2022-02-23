package ifnmg.edu.aplicativodpdm.model;

import java.io.Serializable;

public class Tarefa implements Serializable {

    private long Id;
    private  String nomeTarefa;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }
}
