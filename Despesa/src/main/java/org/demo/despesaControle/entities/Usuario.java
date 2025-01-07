package org.demo.despesaControle.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    private String nomeUsuario;
    private String senha;
    private String email;


    

    
}
