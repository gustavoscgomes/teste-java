import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CadastroPacoteViagem {

    private final List<PacoteViagem> pacotes = new ArrayList<>();

    public void adicionar(String descricao, double precoDiaria) {
       PacoteViagem pacote = new PacoteViagem(descricao, precoDiaria);

       if (pacotes.contains(pacote)) {
           throw new PacoteJaExisteException("Pacote ja existente");
       }

       pacotes.add(pacote);
    }

    public List<PacoteViagem> obterTodos() {
        return pacotes;
    }

    public void ordenar() {
        Collections.sort(pacotes);
    }

    public void ordenarPorPrecoDecrescente() {
        pacotes.sort(new OrdenarPorPreco().reversed());
    }

    public void removerPorDescricao(String descricao) {
        Iterator<PacoteViagem> pacoteIterator = pacotes.iterator();
        while (pacoteIterator.hasNext()) {
            PacoteViagem pacote = pacoteIterator.next();
            if (pacote.getDescricao().equals(descricao)) {
                pacoteIterator.remove();
            }
        }
    }

    public PacoteViagem buscarPorDescricao(String descricao) {
        // TODO iterar pacotes com enhanced for, localizar e retornar
        //  pacote com descrição informada (ou lançar exceção se não encontrar)
        for(PacoteViagem pacote : pacotes) {
            if (pacote.getDescricao().equals(descricao)) {
                return pacote;
            }
        }

        throw new PacoteNaoEncontrado("Pacote nao encontrado");
    }
}
