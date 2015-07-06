package ext.sigaa.ldz.amgsigaa.Objetos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leonardo on 06/07/2015.
 */
public class Notas {
    public String periodo;
    public List<TurmaNota> turmas;

    public Notas()
    {
        turmas = new ArrayList<TurmaNota>();
    }
}
