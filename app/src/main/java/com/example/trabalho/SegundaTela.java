package com.example.trabalho;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaTela extends AppCompatActivity {
    private TextView mTextMessage;

    private TextView txtNome;
    private TextView txtEndereco;
    private TextView txtIdade;

    private final String TAG = "SegundaTela";


    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        mTextMessage = findViewById(R.id.message);


        txtNome = (TextView) findViewById(R.id.txtNome);
        txtIdade = (TextView) findViewById(R.id.txtIdade);
        txtEndereco = (TextView) findViewById(R.id.txtEndereco);

        Intent intentRecebedora = getIntent();

        Bundle parametros = intentRecebedora.getExtras();

        if(parametros != null){
           String  nome = parametros.getString("chave_nome");
           String idade = parametros.getString("chave_idade");
           String endereco = parametros.getString("chave_endereco");

            TextView tnome = (TextView) findViewById (R.id.txtNome);
            tnome.setText (nome);
            TextView tidade = (TextView) findViewById (R.id.txtIdade);
            tidade.setText (idade);
            TextView tendereco = (TextView) findViewById (R.id.txtEndereco);
            tendereco.setText (endereco);

        }
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


    /**
     * @param view
     */
    public void clickSim(View view) {
        Intent intent = new Intent();
        intent.putExtra("qualquer", "qualquer texto");
        setResult(RESULT_OK, intent);
        finish();
    }

    /**
     * @param view
     */
    public void clickNao(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

}
