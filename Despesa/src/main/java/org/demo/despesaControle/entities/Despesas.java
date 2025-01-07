package org.demo.despesaControle.entities;

import org.demo.despesaControle.enums.TipoTransacao;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Despesas {
    private TipoTransacao tipoTransacao;
    private Double valor;
    private String categoria;
    private String descricao;


    
}
