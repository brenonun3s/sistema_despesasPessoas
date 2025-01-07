package org.demo.despesaControle.entities;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Relatorio {
    private List<Despesas> despesas;
}
