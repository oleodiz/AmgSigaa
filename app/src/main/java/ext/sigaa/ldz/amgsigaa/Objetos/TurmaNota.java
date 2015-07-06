package ext.sigaa.ldz.amgsigaa.Objetos;

import java.util.List;

/**
 * Created by Leonardo on 06/07/2015.
 */
public class TurmaNota {
    public String codigo;
    public String nome;
    public String notas[];
    public String faltas;
    public String media;
    public String resultado;

    public TurmaNota()
    {
        notas = new String[6];
    }
}
