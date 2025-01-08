package org.demo.despesaControle.entities;

import java.util.Date;

import org.demo.despesaControle.enums.TipoTransacao;

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
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TipoTransacao", nullable = false, length = 150)
    private TipoTransacao tipoTransacao;
    @Column(name = "valorDespesa", nullable = false, length = 150)
    private Double valor;
    @Column(name = "categoria", nullable = false, length = 150)
    private Categoria categoria;
    @Column(name = "descricao", nullable = false, length = 150)
    private String descricao;
    @Column(name = "TipoTransacao", nullable = true, length = 150)
    private Date dataPagamento;

}
