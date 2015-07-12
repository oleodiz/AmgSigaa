package ext.sigaa.ldz.amgsigaa.Auxiliares;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ext.sigaa.ldz.amgsigaa.Activitys.Main;
import ext.sigaa.ldz.amgsigaa.Adapters.NotasAdapter;
import ext.sigaa.ldz.amgsigaa.Objetos.Notas;
import ext.sigaa.ldz.amgsigaa.Objetos.TurmaNota;
import ext.sigaa.ldz.amgsigaa.R;

/**
 * Created by Edwin on 15/02/2015.
 */
public class TabNotaFragment extends Fragment {

    Notas notas;
    Context context;
    public void construir(Notas notas, Context context)
    {
        this.notas = notas;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.notas_fragment,container,false);
        ListView lst_notas =(ListView) v.findViewById(R.id.lst_notas);
        NotasAdapter adapter = new NotasAdapter(context, notas.turmas);

        lst_notas.setAdapter(adapter);

        lst_notas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return v;
    }
}