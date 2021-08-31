/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domain.enums.TipoCliente;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author guilherme.bona
 */
public class ClienteNewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Prenchimento obrigatório")
    private String nome;
    @NotEmpty(message = "Prenchimento obrigatório")
    @Email(message = "Email invalido")
    private String email;
    @NotEmpty(message = "Prenchimento obrigatório")
    private String cpfCnpj;
    @NotEmpty(message = "Prenchimento obrigatório")
    private String telefone;
    private TipoCliente tipoCliente;

    @NotEmpty(message = "Prenchimento obrigatório")
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    @NotEmpty(message = "Prenchimento obrigatório")
    private String cep;
    @NotEmpty(message = "Prenchimento obrigatório")
    private String cidade;
    @NotEmpty(message = "Prenchimento obrigatório")
    private String estado;

    public ClienteNewDTO(){
    }

    public ClienteNewDTO( Integer id, String nome, String email, String cpfCnpj, String telefone, TipoCliente tipoCliente, String logradouro, String numero, String complemento, String bairro, String cep, String cidade, String estado) {

        this.nome = nome;
        this.email = email;
        this.cpfCnpj = cpfCnpj;
        this.telefone = telefone;
        this.tipoCliente = tipoCliente;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
