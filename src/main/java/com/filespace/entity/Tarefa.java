package com.filespace.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "TTASK")
@Table(name = "TTASK")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CODTASK")
    private int codigo;

    @Column(name = "CODUSU")
    @NotNull(message = "Usuário da tarefa não pode ser vazio")
    private int usuario;

    @Column(name = "DESCRTASK")
    @NotNull(message = "Descrição da tarefa não pode ser vazia")
    @Length(min = 0, max = 60, message = "Descrição da tarefa pode ter até 60 dígitos")
    private String descrição;

    @Column(name = "OBSTASK")
    @Length(max = 4000, message = "Observação deve conter no máximo 4000 dígitos")
    private String observação;

    @Column(name = "DHTASK")
    private Date data;

    @Column(name = "RESOLVIDO")
    @NotNull(message = "Resolvido deve estar entre S ou N")
    @Length(min = 1, max = 1, message = "Resolvido deve estar entre S ou N")
    private Character resolvido;
}
