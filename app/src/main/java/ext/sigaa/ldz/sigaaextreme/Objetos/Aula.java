package ext.sigaa.ldz.sigaaextreme.Objetos;

import java.util.ArrayList;
import java.util.List;

import ext.sigaa.ldz.sigaaextreme.Auxiliares.AutoFitTextView;

/**
 * Created by Leonardo on 28/06/2015.
 */
public class Aula {
    public String topico;
    public List<Arquivo> arquivos;

    public Aula()
    {
        arquivos = new ArrayList<Arquivo>() {};
    }
}
