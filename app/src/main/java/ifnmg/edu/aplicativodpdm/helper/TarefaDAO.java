package ifnmg.edu.aplicativodpdm.helper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLInput;
import java.util.ArrayList;
import java.util.List;

import ifnmg.edu.aplicativodpdm.model.Tarefa;

public class TarefaDAO implements iTarefaDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa());

        try{
            escreve.insert(DbHelper.TABELA_TAREFAS,null, cv);
            Log.e("INFO", "Tarefa Salva com Sucesso");

        }catch(Exception e){
            Log.e("INFO", "Erro ao salvar Tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";
        Cursor cursor= ler.rawQuery(sql, null);

        while (cursor.moveToNext()){

            Tarefa tarefa = new Tarefa();

            @SuppressLint("Range") Long id = cursor.getLong(cursor.getColumnIndex("id"));
            @SuppressLint("Range") String nomeTarefa = cursor.getString(cursor.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);
            tarefas.add(tarefa);

        }
        return tarefas;
    }
}
