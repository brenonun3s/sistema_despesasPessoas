package org.demo.despesaControle.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orcamento {
    private double orcamentoTotal;
    private double valorGasto;
    private double valorRestante;

}
