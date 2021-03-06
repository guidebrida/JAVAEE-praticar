package domain;

import domain.enums.Status;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class OrdemDeServico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false, updatable = false)
    private Date instante;
    @Column(nullable = false)
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordemDeServico")
    private List<Equipamento> equipamentos = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @Column(length = 128, nullable = false)
    public String imageUrl;

    public OrdemDeServico() {
    }

    public OrdemDeServico(Integer id, Status status, String imageUrl) {
        this.id = id;
//        this.instante = LocalDateTime.now();
        this.instante = new Date();
        this.status = (status == null) ? null : status.getCod();
        this.imageUrl = imageUrl;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getInstante() {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(instante.getTime()),
                ZoneId.systemDefault());
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = Date.from(instante.toInstant(ZoneOffset.UTC));
    }

    public Status getStatus() {
        return Status.toEnum(status);
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status.getCod();
        } else {
            this.status = 0;
        }

    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
