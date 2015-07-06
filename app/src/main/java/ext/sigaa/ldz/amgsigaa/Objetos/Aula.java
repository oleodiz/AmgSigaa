package ext.sigaa.ldz.amgsigaa.Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonardo on 28/06/2015.
 */
public class Aula {
    public String topico;
    public String descricao;
    public String data_inicio;
    public String data_fim;
    public List<Arquivo> arquivos;

    public Aula()
    {
        arquivos = new ArrayList<Arquivo>() {};
    }
}
