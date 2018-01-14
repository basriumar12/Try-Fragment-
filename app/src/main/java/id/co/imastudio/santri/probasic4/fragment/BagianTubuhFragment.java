package id.co.imastudio.santri.probasic4.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import id.co.imastudio.santri.probasic4.R;

/**
 * Created by Server on 17/08/2017.
 */

public class BagianTubuhFragment extends Fragment {
    //deklarasi dan buat setter di bagian bawah
    List<Integer> datagambar;
    int indexgambar;
    //menampung data
    public static final String GAMBAR_LIST= "datagambar";
    public static final String INDEX_LIST_GAMBAR ="indexgambar";
    //meanmpilkan log
    private static final String LOG ="BagianTubuhFragment";
    public BagianTubuhFragment(){

    }

    @Nullable
    @Override
    //panggil layout fragment
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(savedInstanceState!=null){
            datagambar=savedInstanceState.getIntegerArrayList(GAMBAR_LIST);
            indexgambar=savedInstanceState.getInt(INDEX_LIST_GAMBAR);

        }
        View v = inflater.inflate(R.layout.freagment_bag_tubuh,container,false);
        //deklarasi fragment xml
        final ImageView gambartubuh = (ImageView) v.findViewById(R.id.imgBagTubuh);
        //ambil gambar
       // gambartubuh.setImageResource(AndroidImageAssets.getHeads().get(1));

        if (gambartubuh != null){
            gambartubuh.setImageResource(datagambar.get(indexgambar));
            gambartubuh.setOnClickListener(new View.OnClickListener() {
                @Override
                //klik merubah data gambar
                public void onClick(View view) {
                    if(indexgambar<datagambar.size()-1){
                        indexgambar++;
                    }else {
                        indexgambar=0;
                    }
                    gambartubuh.setImageResource(datagambar.get(indexgambar));
                }
            });
        } else {
            Log.v(LOG,"fragment ini tidak ada data coy");
        }
        return v;
    }

    public void setDatagambar(List<Integer> datagambar) {
        this.datagambar = datagambar;
    }

    public void setIndexgambar(int indexgambar) {
        this.indexgambar = indexgambar;
    }
    //menyimpan data

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    outState.putIntegerArrayList(GAMBAR_LIST,(ArrayList<Integer>)datagambar);
        outState.putInt(INDEX_LIST_GAMBAR,indexgambar);
    }
}
