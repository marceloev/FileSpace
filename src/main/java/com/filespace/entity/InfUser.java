package com.filespace.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity(name = "InfUser")
@Table(name = "TINFUSER")
public class InfUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CODUSU", length = 11)
    private int codigo;

    @Column(name = "EMAIL", length = 80)
    @NotNull(message = "E-mail do usuário não pode ser vazio")
    private String email;

    @Column(name = "ENDERECO", length = 80)
    @NotNull(message = "Endereço do usuário não pode ser vazio")
    private String endereco;

    @Column(name = "ENDERECO2", length = 80)
    private String endereco2;

    @Column(name = "CEP", length = 8)
    @NotNull(message = "CEP do usuário não pode ser vazio")
    @Length(min = 8, max = 8, message = "CEP deve ter 8 dígitos")
    private String cep;

    @Column(name = "CIDADE", length = 30)
    @NotNull(message = "Cidade do usuário não pode ser vazio")
    private String cidade;

    @Column(name = "ESTADO", length = 20)
    @NotNull(message = "Estado do usuário não pode ser vazio")
    private String estado;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco2() {
        return endereco2;
    }

    public void setEndereco2(String endereco2) {
        this.endereco2 = endereco2;
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

    @Override
    public String toString() {
        return "InfUser{" +
                "codigo=" + codigo +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", endereco2='" + endereco2 + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
