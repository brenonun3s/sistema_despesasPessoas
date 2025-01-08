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
public class Rendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "categoria", nullable = false, length = 150)
    private Categoria categoria;
    @Column(name = "nomeRenda", nullable = false, length = 150)
    private String nome;
    @Column(name = "valorRenda", nullable = false, length = 150)
    private double valorRenda;

}