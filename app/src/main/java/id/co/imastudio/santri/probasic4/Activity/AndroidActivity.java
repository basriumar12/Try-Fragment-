package id.co.imastudio.santri.probasic4.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.co.imastudio.santri.probasic4.R;
import id.co.imastudio.santri.probasic4.data.AndroidImageAssets;
import id.co.imastudio.santri.probasic4.fragment.BagianTubuhFragment;

public class AndroidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);
        if (savedInstanceState == null) {
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
    }
}