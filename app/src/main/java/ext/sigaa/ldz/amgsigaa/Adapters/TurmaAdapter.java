package ext.sigaa.ldz.amgsigaa.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ext.sigaa.ldz.amgsigaa.Objetos.Aula;
import ext.sigaa.ldz.amgsigaa.R;

/**
 * Created by Leonardo on 30/06/2015.
 */
public class TurmaAdapter extends BaseAdapter{
    List<Aula> aulas;
    Context context;
    private static LayoutInflater inflater = null;
    LinearLayout.LayoutParams params;

    public TurmaAdapter(Context contx, List<Aula> aulas) {
        this.aulas = aulas;
        context = contx;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return aulas.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView txt_arquivos, txt_descricaoAula,txt_topicoAula, txt_dataAula;
        LinearLayout lnr_itemAula;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView = convertView;


            rowView = inflater.inflate(R.layout.list_aulas, null);
            holder.txt_dataAula = (TextView) rowView.findViewById(R.id.txt_dataAula);
            holder.txt_arquivos = (TextView) rowView.findViewById(R.id.txt_arquivos);
            holder.txt_descricaoAula = (TextView) rowView.findViewById(R.id.txt_descricaoAula);
            holder.txt_topicoAula = (TextView) rowView.findViewById(R.id.txt_topicoAula);

            holder.lnr_itemAula = (LinearLayout) rowView.findViewById(R.id.lnr_itemTurma);

            if (aulas.get(position).data_inicio.equals(aulas.get(position).data_fim)) {
                holder.txt_dataAula.setText(aulas.get(position).data_inicio);
                holder.txt_dataAula.setMaxLines(1);
            } else
                holder.txt_dataAula.setText(aulas.get(position).data_inicio + "\n - \n" + aulas.get(position).data_fim);

            if (aulas.get(position).arquivos.size() > 0)
                holder.txt_arquivos.setText(aulas.get(position).arquivos.size() + " arquivo(s)");
            else
                holder.txt_arquivos.setVisibility(View.GONE);

            holder.txt_topicoAula.setText(aulas.get(position).topico);
            if (aulas.get(position).descricao.equals(""))
                holder.txt_descricaoAula.setVisibility(View.GONE);
            else
                holder.txt_descricaoAula.setText(aulas.get(position).descricao);
        return rowView;
    }
}
