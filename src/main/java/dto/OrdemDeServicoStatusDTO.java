/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;


public class OrdemDeServicoStatusDTO  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer status;

    public OrdemDeServicoStatusDTO() {
    }

    public OrdemDeServicoStatusDTO(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
