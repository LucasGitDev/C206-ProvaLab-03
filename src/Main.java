import Controllers.FileController;
import Models.Jurado;
import Models.Participante;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    private static final List<Participante> participantes = new ArrayList<>();

    public static void main(String[] args) {
        Participante participante = new Participante("João", 25, "Massas");
        Participante participante2 = new Participante("João", 25, "Massas");
        Participante participante3 = new Participante("José", 25, "Feijuca");
        Participante participante4 = new Participante("Maia", 25, "Massas");
        loadAllParticipantes(); // primeiro run não terá arquivos, logo, não carregará nada

        participante.apresentarPrato("Lasanha");
        participante2.apresentarPrato("Lasanha");
        participante3.apresentarPrato("Feijoada");
        participante4.apresentarPrato("Miojo");

        addParticipante(participante);
        addParticipante(participante2);
        addParticipante(participante3);
        addParticipante(participante4);

        Jurado jurado = new Jurado("Maria", 30, "Doces");

        for (Participante p: participantes) {
            jurado.avaliarParticipante(p, 10);
        }

        jurado.avaliarParticipante(participante, 10);
        jurado.avaliarParticipante(participante2, 10);
        jurado.avaliarParticipante(participante3, 10);
        jurado.avaliarParticipante(participante4, 10);

        jurado.mostrarAvaliacoes();

        jurado.getAvaliacoes().forEach((key, value) -> {
            participantes.forEach(p -> {
                if (p.getNome() == key) {
                    p.gravarInformacoes();
                }
            });
        });

        participantes.forEach(p -> {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Idade: " + p.getIdade());
            System.out.println("Especialidade: " + p.getEspecialidade());
            System.out.println("Prato apresentado: " + p.getPratoApresentado());
        });
    }

    public static void addParticipante(Participante participante) {
        for (Participante p: participantes) {
            if (Objects.equals(p.getNome(), participante.getNome())) {
                return;
            }
        }
        participantes.add(participante);
    }

    public static void loadAllParticipantes() {
        try {
            List<String> files = FileController.getFilesInFolder("src/assets");
            for (String file : files) {
                List<String> lines = FileController.readAllLines(file);
                Participante participante = new Participante(lines.get(0).split(":")[1], Integer.parseInt(lines.get(1).split(":")[1]), lines.get(2).split(":")[1]);
                participantes.add(participante);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}