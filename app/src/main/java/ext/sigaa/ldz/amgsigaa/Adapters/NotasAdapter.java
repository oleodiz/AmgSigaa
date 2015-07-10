package ext.sigaa.ldz.amgsigaa.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import ext.sigaa.ldz.amgsigaa.Objetos.Notas;
import ext.sigaa.ldz.amgsigaa.Objetos.TurmaNota;
import ext.sigaa.ldz.amgsigaa.R;

/**
 * Created by Leonardo on 09/07/2015.
 */
public class NotasAdapter extends BaseAdapter {

    List<TurmaNota> notas;
    Context context;
    private static LayoutInflater inflater = null;
    LinearLayout.LayoutParams params;

    public NotasAdapter(Context contx, List<TurmaNota> notas) {
        this.notas = notas;
        context = contx;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void addNotas(List<TurmaNota> notas)
    {
        this.notas.addAll(notas);
    }

    public void addNota(TurmaNota notas)
    {
        this.notas.add(notas);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return notas.size();
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
        TextView periodo;
        TextView txt_codTurma, txt_nomeTurma,txt_nota1, txt_nota2, txt_nota3, txt_nota4, txt_nota5, txt_nota6, txt_faltas, txt_media,txt_resultado ;
        LinearLayout lnr_itemNota;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowView =convertView;
        if (rowView == null) {
            if (!notas.get(position).codigo.equals("0")) {
                rowView = inflater.inflate(R.layout.list_notas, null);
                holder.txt_codTurma = (TextView) rowView.findViewById(R.id.txt_codTurma);
                holder.txt_nomeTurma = (TextView) rowView.findViewById(R.id.txt_nomeTurma);
                holder.txt_nota1 = (TextView) rowView.findViewById(R.id.txt_nota1);
                holder.txt_nota2 = (TextView) rowView.findViewById(R.id.txt_nota2);
                holder.txt_nota3 = (TextView) rowView.findViewById(R.id.txt_nota3);
                holder.txt_nota4 = (TextView) rowView.findViewById(R.id.txt_nota4);
                holder.txt_nota5 = (TextView) rowView.findViewById(R.id.txt_nota5);
                holder.txt_nota6 = (TextView) rowView.findViewById(R.id.txt_nota6);

                holder.txt_faltas = (TextView) rowView.findViewById(R.id.txt_faltas);
                holder.txt_media = (TextView) rowView.findViewById(R.id.txt_media);
                holder.txt_resultado = (TextView) rowView.findViewById(R.id.txt_resultado);

                holder.lnr_itemNota = (LinearLayout) rowView.findViewById(R.id.lnr_itemNota);
            }
            else
            {
                rowView = inflater.inflate(R.layout.txt_periodo, null);
                holder.periodo = (TextView) rowView.findViewById(R.id.txt_periodo);
            }
            rowView.setTag(holder);
        }
        else
            holder = (Holder) convertView.getTag();


        if (!notas.get(position).codigo.equals("0")) {
            holder.txt_codTurma.setText(notas.get(position).codigo);
            holder.txt_nomeTurma.setText(notas.get(position).nome);
            holder.txt_nomeTurma.setTextSize(30);
            holder.txt_faltas.setText(notas.get(position).faltas);
            holder.txt_media.setText(notas.get(position).media);
            holder.txt_resultado.setText(notas.get(position).resultado);

            holder.txt_nota1.setText(notas.get(position).notas[0]);
            holder.txt_nota2.setText(notas.get(position).notas[1]);
            holder.txt_nota3.setText(notas.get(position).notas[2]);
            holder.txt_nota4.setText(notas.get(position).notas[3]);
            holder.txt_nota5.setText(notas.get(position).notas[4]);
            holder.txt_nota6.setText(notas.get(position).notas[5]);


            if (position % 2 == 0)
                rowView.setBackgroundColor(Color.argb(255, 205, 238, 248));
            else
                rowView.setBackgroundColor(Color.argb(255, 236, 249, 253));
        }
        else
            holder.periodo.setText(notas.get(position).nome);
        return rowView;
    }
}
