package ext.sigaa.ldz.amgsigaa.Fragments;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.db.chart.Tools;
import com.db.chart.model.LineSet;
import com.db.chart.view.AxisController;
import com.db.chart.view.ChartView;
import com.db.chart.view.LineChartView;
import com.db.chart.view.animation.Animation;

import ext.sigaa.ldz.amgsigaa.R;

/**
 * Created by leoss on 12/07/2015.
 */
public class LineChartFragment extends Fragment {


    /** First chart */
    private LineChartView mChartOne;
    private ImageButton mPlayOne, img_voltar;
    private TextView txt_nomeTurma;
    private boolean mUpdateOne;
    private String[] mLabelsOne= {"1Uni.",  "2Uni.", "3Uni.", "4Uni.", "5Uni.", "6Uni."};
    private Float[] mValuesOne = {7.0f, 3.5f, 4.7f, 9.0f, 6.5f, 8.3f};
    private Float[] mValuesAvg = {5.0f,5.0f,5.0f,5.0f,5.0f,5.0f};
    String nomeTurma;

    Fragment context;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);

        context = this;
    }
    public void setValues(String nomeTurma, String[] mLabelsOne, Float[] mValuesOne, Float[] mValuesAvg)
    {
        this.mLabelsOne = mLabelsOne;
        this.mValuesOne = mValuesOne;
        this.nomeTurma = nomeTurma;
        this.mValuesAvg = mValuesAvg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.line, container, false);

        mPlayOne = (ImageButton) layout.findViewById(R.id.play1);
        img_voltar = (ImageButton) layout.findViewById(R.id.img_voltar);
        txt_nomeTurma = (TextView) layout.findViewById(R.id.txt_nomeTurma);
        txt_nomeTurma.setText(nomeTurma);

        img_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().remove(context).commit();
            }
        });

        // Init first chart
        mUpdateOne = true;
        mChartOne = (LineChartView) layout.findViewById(R.id.linechart1);

        showChart(0, mChartOne, mPlayOne);
        return layout;
    }

    /**
     * Show a CardView chart
     * @param tag   Tag specifying which chart should be dismissed
     * @param chart   Chart view
     * @param btn    Play button
     */
    private void showChart(final int tag, final LineChartView chart, final ImageButton btn){
        dismissPlay(btn);
        Runnable action =  new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        showPlay(btn);
                    }
                }, 500);
            }
        };

        switch(tag){
            case 0:
                produceOne(chart, action); break;

            default:
        }
    }



    /**
     * Show CardView play button
     * @param btn    Play button
     */
    private void showPlay(ImageButton btn){
        btn.setEnabled(true);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            btn.animate().alpha(1).scaleX(1).scaleY(1);
        else
            btn.setVisibility(View.VISIBLE);
    }


    /**
     * Dismiss CardView play button
     * @param btn    Play button
     */
    private void dismissPlay(ImageButton btn){
        btn.setEnabled(false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH)
            btn.animate().alpha(0).scaleX(0).scaleY(0);
        else
            btn.setVisibility(View.INVISIBLE);
    }



    /**
     *
     * Chart 1
     *
     */

    public void produceOne(LineChartView chart, Runnable action){

        LineSet dataset = new LineSet(mLabelsOne, mValuesOne);
        dataset.setColor(Color.parseColor("#80BBF0"))
                .setDotsStrokeThickness(Tools.fromDpToPx(4))
                .setDotsStrokeColor(Color.parseColor("#80BBF0"))
                .setDotsColor(Color.parseColor("#FFFFFF"));
        chart.addData(dataset);

        dataset = new LineSet(mLabelsOne, mValuesAvg);
        dataset.setColor(Color.parseColor("#ffc0c0c0"))
                .setThickness(Tools.fromDpToPx(3))
                .setDashed(new float[]{5, 5});
        chart.addData(dataset);


        Paint gridPaint = new Paint();
        gridPaint.setColor(Color.parseColor("#ffc0c0c0"));
        gridPaint.setStyle(Paint.Style.STROKE);
        gridPaint.setAntiAlias(true);
        gridPaint.setStrokeWidth(Tools.fromDpToPx(1f));

        chart.setBorderSpacing(1)
                .setAxisBorderValues(0, 10, 1)
                .setXLabels(AxisController.LabelPosition.OUTSIDE)
                .setYLabels(AxisController.LabelPosition.OUTSIDE)
                .setLabelsColor(Color.parseColor("#FF8E9196"))
                .setFontSize(12)
                .setXAxis(false)
                .setYAxis(false)
                .setStep(1)
                .setBorderSpacing(Tools.fromDpToPx(5))
                .setGrid(ChartView.GridType.VERTICAL, gridPaint);

        Animation anim = new Animation().setEndAction(action);

        chart.show(anim);
    }

}
