/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domain.Equipamento;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class EquipamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
       
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Prenchimento Obrigatório")
    private String nome;
    private String marca;
    @NotEmpty(message = "Prenchimento Obrigatório")
    private String descricao;
    @NotEmpty(message = "Prenchimento Obrigatório")
    private String defeito;

    public EquipamentoDTO() {
    }
    
     public EquipamentoDTO(Equipamento obj) {
        id = obj.getId();
        nome = obj.getNome();
        marca = obj.getMarca();
        descricao = obj.getDescricao();
        defeito = obj.getDefeito();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }
    
}
