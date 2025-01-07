package org.demo.despesaControle.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rendas {
    private Categoria categoria;
    private String nome;
    private double valorRenda;
    
}