package ext.sigaa.ldz.amgsigaa.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ext.sigaa.ldz.amgsigaa.Adapters.NotasAdapter;
import ext.sigaa.ldz.amgsigaa.Objetos.Notas;
import ext.sigaa.ldz.amgsigaa.R;

public class TabNotaFragment extends Fragment {

    Notas notas;
    Context context;
    public void construir(Notas notas, Context context)
    {
        this.notas = notas;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.notas_fragment,container,false);
        ListView lst_notas =(ListView) v.findViewById(R.id.lst_notas);
        NotasAdapter adapter = new NotasAdapter(context, notas.turmas);



        lst_notas.setAdapter(adapter);

        lst_notas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (savedInstanceState == null) {
                    ArrayList<String> unidades = new ArrayList<String>();
                    ArrayList<Float> notasF = new ArrayList<Float>();
                    ArrayList<Float> mediaF = new ArrayList<Float>();

                    for (int n = 0; n < notas.turmas.get(i).notas.length; n++) {
                        if (notas.turmas.get(i).notas[n].equals("-"))
                            break;
                        unidades.add((n + 1) + "Uni.");
                        notasF.add(Float.parseFloat(notas.turmas.get(i).notas[n].replace(",",".")));
                        mediaF.add(Float.parseFloat(notas.turmas.get(i).media.replace(",", ".")));
                    }

                    if (notasF.size() > 1) {
                        LineChartFragment grafico = new LineChartFragment();
                        grafico.setValues(notas.turmas.get(i).nome,
                                unidades.toArray(new String[unidades.size()]),
                                notasF.toArray(new Float[notasF.size()]),
                                mediaF.toArray(new Float[mediaF.size()]));

                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.add(android.R.id.content, grafico).commit();
                    }
                    else
                        Toast.makeText(context, R.string.semgrafico, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}