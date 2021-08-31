/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import domain.Equipamento;
import domain.OrdemDeServico;
import domain.enums.Status;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class OrdemDeServicoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime instante;
    @Enumerated(value = EnumType.ORDINAL)
    private Status status;
    private Integer clienteId;
    private List<Equipamento> equipamentos;
    private String imageUrl;

    public OrdemDeServicoDTO() {
    }

    public OrdemDeServicoDTO(OrdemDeServico obj) {
        id = obj.getId();
        instante = obj.getInstante();
        this.status = obj.getStatus();
        clienteId = obj.getCliente().getId();
        equipamentos = obj.getEquipamentos();
        this.imageUrl = obj.getImageUrl();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
