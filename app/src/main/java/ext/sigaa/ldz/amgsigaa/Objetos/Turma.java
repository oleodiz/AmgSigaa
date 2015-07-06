package ext.sigaa.ldz.amgsigaa.Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonardo on 28/06/2015.
 */
public class Turma {
    public String id;
    public String idForm;
    public String descricao;

    public List<DetalhesTurma> detalhes;
    public List<Aula> aulas;

    public Turma()
    {
        detalhes = new ArrayList<DetalhesTurma>();
        aulas =  new ArrayList<Aula>();
    }

}
