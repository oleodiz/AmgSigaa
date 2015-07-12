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

import ext.sigaa.ldz.amgsigaa.Auxiliares.AutoFitTextView;
import ext.sigaa.ldz.amgsigaa.Objetos.DetalhesTurma;
import ext.sigaa.ldz.amgsigaa.Objetos.Turma;
import ext.sigaa.ldz.amgsigaa.R;

/**
 * Created by Leonardo on 28/06/2015.
 */
public class ListaTurmasAdapter extends BaseAdapter {
    List<Turma> turmas;
    Context context;
    private static LayoutInflater inflater = null;
    LinearLayout.LayoutParams params;

    public ListaTurmasAdapter(Context contx, List<Turma> turmas) {
        this.turmas = turmas;
        context = contx;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return turmas.size();
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
        TextView txt_turma;
        LinearLayout lnr_itemTurma, lnr_areaDetalhesTurma;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.list_turmas, null);
        holder.txt_turma = (TextView) rowView.findViewById(R.id.txt_turma);

        holder.lnr_itemTurma = (LinearLayout) rowView.findViewById(R.id.lnr_itemTurma);
        holder.lnr_areaDetalhesTurma = (LinearLayout) rowView.findViewById(R.id.lnr_areaDetalhesTurma);

        holder.txt_turma.setText(turmas.get(position).descricao);

        for (DetalhesTurma dt : turmas.get(position).detalhes)
        {
            AutoFitTextView dia_hora = new AutoFitTextView(context);
            dia_hora.setTextSize(20);
            dia_hora.setSingleLine(true);
            dia_hora.setTextColor(Color.argb(200, 102, 102, 102));
            dia_hora.setText(dt.dia + " - " + dt.hora);

            dia_hora.setLayoutParams(params);
            holder.lnr_areaDetalhesTurma.addView(dia_hora);

            AutoFitTextView local = new AutoFitTextView(context);
            local.setTextSize(20);
            local.setSingleLine(true);
            local.setTextColor(Color.argb(200, 153, 153, 153));
            local.setText(dt.local);

            local.setLayoutParams(params);
            holder.lnr_areaDetalhesTurma.addView(local);
        }

        return rowView;
    }
}