package Models;

import Exceptions.ParticipanteDuplicadoException;

import java.util.HashMap;
import java.util.Map;

public class Jurado extends Chef{

    private final Map<String, Integer> avaliacoes = new HashMap<>();

    public Jurado(String nome, int idade, String especialidade) {
        super(nome, idade, especialidade);
    }

    public void avaliarParticipante(Participante participante, int nota) {
        try {
            if (avaliacoes.containsKey(participante.getNome())) {
                throw new ParticipanteDuplicadoException(participante.getNome());
            }
            avaliacoes.put(participante.getNome(), nota);
        } catch (ParticipanteDuplicadoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarAvaliacoes() {
        for (Map.Entry<String, Integer> entry : avaliacoes.entrySet()) {
            System.out.println("Participante: " + entry.getKey() + " - Nota: " + entry.getValue());
        }
    }

    public Map<String, Integer> getAvaliacoes() {
        return avaliacoes;
    }
}
