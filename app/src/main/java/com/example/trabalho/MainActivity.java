package com.example.trabalho;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private final String TAG = "MainActivity";
    private TextView edtNome;
    private TextView edtEndereco;
    private EditText edtIdade;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sobre:
                Intent intentSobre = new Intent(this, TerceiraTela.class);
                startActivity(intentSobre);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = findViewById(R.id.message);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtIdade = (EditText) findViewById(R.id.edtIdade);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);

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
     * @param requestCode
     * @param resultCode
     * @param data
     */

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK){
//            Log.e(TAG, "Extras resultado: "+data.getExtras().getString("qualquer"));
//            Toast.makeText(this, "Cadastro salvo com sucesso!", Toast.LENGTH_SHORT).show();
//
//
//        }
//
//
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e(TAG, "está executando");
        if(resultCode == RESULT_OK){
            Log.e(TAG, "Extras resultado: "+data.getExtras().getString("qualquer"));
            Toast.makeText(this, "Cadastro salvo com sucesso!", Toast.LENGTH_SHORT).show();
            edtNome.setText("");
            edtIdade.setText("");
            edtEndereco.setText("");
        }
    }

    /**
     * @param view
     */
    public void clickSalvar(View view){

        String nome = edtNome.getText().toString();
        String idade = edtIdade.getText().toString();
        String endereco = edtEndereco.getText().toString();

        Intent intentEnviadora = new Intent(getApplicationContext(), SegundaTela.class);
        Bundle parametros = new Bundle();

        parametros.putString("chave_nome", nome);
        parametros.putString("chave_idade", idade);
        parametros.putString("chave_endereco", endereco);

        intentEnviadora.putExtras(parametros);

        startActivityForResult(intentEnviadora, 0);

    }

}
