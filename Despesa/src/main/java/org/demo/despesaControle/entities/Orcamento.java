package org.demo.despesaControle.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "totalOrcamento", nullable = false, length = 150)
    private double orcamentoTotal;
    @Column(name = "valorGasto", nullable = false, length = 150)
    private double valorGasto;
    @Column(name = "valorRestante", nullable = false, length = 150)
    private double valorRestante;

}
