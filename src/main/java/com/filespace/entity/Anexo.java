package com.filespace.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Entity(name = "TANX")
@Table(name = "TANX")
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODANX")
    private int codigo;

    @Column(name = "CODUSU")
    @NotNull(message = "Usuário detentor do anexo não pode ser vazio")
    private int usuario;

    @Column(name = "DESCRANX")
    @NotNull(message = "Descrição do anexo não pode ser vazio")
    @Length(min = 0, max = 60, message = "Descrição do anexo só pode ter até 60 dígitos")
    private String descrição;

    @Column(name = "TIPOANX")
    @Length(max = 10, message = "Extensão do anexo não pode ter mais de 10 dígitos")
    private String tipo;

    @Column(name = "ARQANX")
    @NotNull(message = "Anexo não pode estar vazio")
    private Byte[] arquivo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(Byte[] arquivo) {
        this.arquivo = arquivo;
    }

    @Override
    public String toString() {
        return "Anexo{" +
                "codigo=" + codigo +
                ", usuario=" + usuario +
                ", descrição='" + descrição + '\'' +
                ", tipo='" + tipo + '\'' +
                ", arquivo=" + Arrays.toString(arquivo) +
                '}';
    }
}
