package Exceptions;

public class ParticipanteDuplicadoException extends Exception {
    public ParticipanteDuplicadoException(String nome) {
        super("O participante "+ nome +" já foi avaliado!");
    }
}
