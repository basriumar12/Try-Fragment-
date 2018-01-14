package id.co.imastudio.santri.probasic4.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import id.co.imastudio.santri.probasic4.R;
import id.co.imastudio.santri.probasic4.adapter.MasterListAdapter;
import id.co.imastudio.santri.probasic4.data.AndroidImageAssets;

/**
 * Created by Server on 17/08/2017.
 */

public class MasterListFragment extends Fragment {

    OnImageClickListiner callback;
    public interface OnImageClickListiner{
        void onImageselected(int posisition);
    }

    public MasterListFragment() {
    }
    //mengecek apakah sebauh variabel callback sudah di implementasikan
    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        try{
            callback=(OnImageClickListiner)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+
                    "must implement OnImageClickListiner");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_master_list,container,false);
       //inisialisasi gridview dalam fragment_mster_list.xml
        GridView grdikostum = (GridView)v.findViewById(R.id.images_grid_view);

        MasterListAdapter adapter = new MasterListAdapter
                (getContext(), AndroidImageAssets.getAll());
        grdikostum.setAdapter(adapter);
        grdikostum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posisi, long l) {
                callback.onImageselected(posisi);
            }
        });
        return v;
    }

}
