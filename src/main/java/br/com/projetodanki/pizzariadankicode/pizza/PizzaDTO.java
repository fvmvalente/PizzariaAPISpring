package br.com.projetodanki.pizzariadankicode.pizza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {

    private Long id;
    @NonNull
    @NotBlank
    private String nome;
    private boolean disponivel;
    @Positive
    private Double preco;
    private Sabor sabor;
    private Tamanho tamanho;
    private Categoria categoria;
}
