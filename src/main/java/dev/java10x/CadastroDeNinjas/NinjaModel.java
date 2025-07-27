package dev.java10x.CadastroDeNinjas;

import jakarta.persistence.*;


// Entity ele transforma uma classe em uma entidade de banco de dados
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    //Informar qual é o Id logo abaixo
    //GeneratedValue vai ser como esse id vai ser passado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
