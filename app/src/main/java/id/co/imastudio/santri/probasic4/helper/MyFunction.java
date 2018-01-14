package id.co.imastudio.santri.probasic4.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Server on 17/08/2017.
 */

public class MyFunction extends AppCompatActivity{
    public Context con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_function);
        //memberkikan fungsi bahwa context con yaitu class Myfunction
        con=MyFunction.this;

    }
    public void akseskelas (Class kelastujuan){
        startActivity(new Intent(con,kelastujuan));

    }



    }

