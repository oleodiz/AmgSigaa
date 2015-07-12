package ext.sigaa.ldz.amgsigaa.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import ext.sigaa.ldz.amgsigaa.Auxiliares.TabNotaFragment;
import ext.sigaa.ldz.amgsigaa.Objetos.Notas;

/**
 * Created by Edwin on 15/02/2015.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    ArrayList<Notas> notas;
    Context context;
    // Build a Constructor and assign the passed Values to appropriate values in the class
    public PagerAdapter(FragmentManager fm, ArrayList<Notas> notas, Context context) {
        super(fm);

        this.notas = notas;
        this.context = context;
    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        TabNotaFragment tab = new TabNotaFragment();
        tab.construir(notas.get(position), context);
        return tab;

    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return notas.get(position).periodo;
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        if (notas != null)
        return notas.size();

        return 0;
    }
}