package Models;

import Controllers.FileController;

import java.util.ArrayList;
import java.util.List;

public class Participante extends Chef{
    private String pratoApresentado;

    public Participante(String nome, int idade, String especialidade) {
        super(nome, idade, especialidade);
    }

    public String getPratoApresentado() {
        return pratoApresentado;
    }

    public void setPratoApresentado(String pratoApresentado) {
        this.pratoApresentado = pratoApresentado;
    }

    public void apresentarPrato(String prato) {
        setPratoApresentado(prato);
        System.out.println("Prato apresentado por "+ this.getNome() + ": " + prato);
    }

    public void gravarInformacoes() {
        List<String> lines = new ArrayList<>();
        lines.add("Nome:" + this.getNome());
        lines.add("Idade:" + this.getIdade());
        lines.add("Especialidade:" + this.getEspecialidade());
        lines.add("Prato apresentado:" + this.getPratoApresentado());

        FileController.writeAllLines("src/assets/"+this.getNome().toLowerCase()+".txt", lines);
    }
}
