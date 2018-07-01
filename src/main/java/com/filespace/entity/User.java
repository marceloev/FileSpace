package com.filespace.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity(name = "USER")
@NamedQueries({
        @NamedQuery(name = "User.findByLogin",
                query = "SELECT U FROM USER U WHERE U.login = :P_LOGIN"),
        @NamedQuery(name = "User.countUserByLogin",
                query = "SELECT U FROM USER U WHERE U.login LIKE :P_LOGIN")
})
@Table(name = "TUSER")
public class User implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODUSU")
    private int codigo;

    @NotNull(message = "Login do usuário não pode ser vazio")
    @Column(name = "LOGIN", unique = true)
    @Length(max = 20, message = "Login do usuário não pode ter mais de 20 caracteres")
    private String login;

    @NotNull(message = "Senha do usuário não pode ser vazio")
    @Column(name = "SENHA", length = 60)
    private String senha;

    @NotNull(message = "Nome do usuário não pode ser vazio")
    @Column(name = "NOME", length = 100)
    private String nome;

    @NotNull(message = "Usuário precisa estar Ativo ou Inativo")
    @Column(name = "ATIVO", length = 1)
    private Character ativo = 'S';

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getAtivo() {
        return ativo;
    }

    public void setAtivo(Character ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "User{" +
                "codigo=" + codigo +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", ativo=" + ativo +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
