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
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "loginUsuario", nullable = false, length = 150)
    private String nomeUsuario;
    @Column(name = "senhaUsuario", nullable = false, length = 150)
    private String senha;
    @Column(name = "emailUsuario", nullable = false, length = 150)
    private String email;

}
