package org.demo.despesaControle.service;

import java.util.Scanner;

import org.demo.despesaControle.dao.DespesasDAO;
import org.demo.despesaControle.entities.Despesas;

public class DespesaService {
    private final DespesasDAO dao;
    private final Scanner sc;


    public DespesaService(){
        this.dao = new DespesasDAO();
        this.sc = new Scanner(System.in);
    }

    public Despesas salvar(Despesas despesas){
        return this.dao.salvarDespesas(despesas);
    }

    public String atualizar (Despesas despesas, Long id){
        return this.dao.atualizarDespesas(despesas, id);
    }

    public String excluir(Despesas despesas, Long id){
        return this.dao.excluir(despesas, id);
    }
}
