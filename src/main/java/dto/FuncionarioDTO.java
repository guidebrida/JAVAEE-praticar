/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domain.Funcionario;
import domain.enums.Funcionarios;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author guilherme.bona
 */
public class FuncionarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Funcionarios funcionarios;
    private String usuario;
  //  private String senha;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Integer id, String usuario, Funcionarios tipo) {
        this.id = id;
        this.usuario = usuario;
        this.funcionarios = tipo;
    }


    public FuncionarioDTO(Funcionario obj) {
        this.id = obj.getId();
        this.funcionarios = obj.getFuncionario();
        this.usuario = obj.getUsuario();
//        this.senha = obj.getSenha();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcionarios getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }
}

