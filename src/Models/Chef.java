package Models;

public class Chef {
    private String nome;
    private int idade;
    private String especialidade;

    public Chef(String nome, int idade, String especialidade) {
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
