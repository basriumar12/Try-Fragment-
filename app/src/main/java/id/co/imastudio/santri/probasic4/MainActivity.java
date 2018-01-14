package id.co.imastudio.santri.probasic4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import id.co.imastudio.santri.probasic4.Activity.AndroidActivity;
import id.co.imastudio.santri.probasic4.data.AndroidImageAssets;
import id.co.imastudio.santri.probasic4.fragment.BagianTubuhFragment;
import id.co.imastudio.santri.probasic4.fragment.MasterListFragment;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListiner {
    int kepalaindex,badanindex,kakiindex;
    Boolean twopane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.android_linear_layout )!= null){
            twopane=true;

            if (savedInstanceState == null) {

                Button show = (Button) findViewById(R.id.next);
                show.setVisibility(View.GONE);
                GridView grdikostum = (GridView)findViewById(R.id.images_grid_view);
                grdikostum.setNumColumns(2);
                //memanggil fragment bagian kepala
                BagianTubuhFragment kepalafragment = new BagianTubuhFragment();
                //untuk tangkap bundle dari mainactivity
                int kepaladindex = getIntent().getIntExtra("kepalaIndex",0);

                //ambil array
                kepalafragment.setDatagambar(AndroidImageAssets.getHeads());
                kepalafragment.setIndexgambar(kepaladindex);
                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction()
                        .add(R.id.kepala_container, kepalafragment)
                        .commit();


                //untuk badan
                BagianTubuhFragment badanfragment = new BagianTubuhFragment();

                int badanindex = getIntent().getIntExtra("badanIndex",0);
                //ambil array

                badanfragment.setDatagambar(AndroidImageAssets.getBodies());
                badanfragment.setIndexgambar(badanindex);
                manager.beginTransaction()
                        .add(R.id.badan_container, badanfragment)
                        .commit();


                //kaki fragment
                BagianTubuhFragment kakifragment = new BagianTubuhFragment();

                int kakidindex = getIntent().getIntExtra("kakiIndex",0);
                //ambil array
                kakifragment.setDatagambar(AndroidImageAssets.getLegs());
                kakifragment.setIndexgambar(kakidindex);

                manager.beginTransaction()
                        .add(R.id.kaki_container, kakifragment)
                        .commit();
            }




        }else {
            twopane=false;
        }

    }

    @Override
    public void onImageselected(int posisition) {
        Toast.makeText(this, "pilihan anda di posisi" +posisition, Toast.LENGTH_SHORT).show();
        int bodypartnumber=posisition/12;
        int listindex=posisition-12*bodypartnumber;
        if (twopane){
            BagianTubuhFragment tubuhfragment = new BagianTubuhFragment();

            switch (bodypartnumber){
                case 0:
                    tubuhfragment.setDatagambar(AndroidImageAssets.getHeads());
                    tubuhfragment.setIndexgambar(listindex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.kepala_container,tubuhfragment)
                            .commit();
                    break;
                case 1:
                    tubuhfragment.setDatagambar(AndroidImageAssets.getBodies());
                    tubuhfragment.setIndexgambar(listindex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.badan_container,tubuhfragment)
                            .commit();
                    break;
                case 2:
                    tubuhfragment.setDatagambar(AndroidImageAssets.getLegs());
                    tubuhfragment.setIndexgambar(listindex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.kaki_container,tubuhfragment)
                            .commit();
                    break;
            }
        }else{
        switch (bodypartnumber){
            case 0: kepalaindex=listindex;
                break;
            case 1: badanindex=listindex;
                break;
            case 2: kakiindex=listindex;
                default:
        }

        Bundle b = new Bundle();
        b.putInt("kepalaIndex",kepalaindex);
        b.putInt("badanIndex",badanindex);
        b.putInt("kakiIndex",kakiindex);
        final Intent intent = new Intent(this, AndroidActivity.class);
        intent.putExtras(b);

        Button show = (Button) findViewById(R.id.next);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
    }
}
