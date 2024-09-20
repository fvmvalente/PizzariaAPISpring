package br.com.projetodanki.pizzariadankicode.pizza;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Pizza")
//@Getter
//@Setter
//@EqualsAndHashCode
// @Data engloba as 3 anotacoes anteriores
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pizza {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean disponivel;
    private Double preco;
    @Enumerated(EnumType.STRING)
    private Sabor sabor;
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

}
