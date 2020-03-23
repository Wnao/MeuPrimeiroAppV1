package br.usjt.devmobile.meuprimeiroappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MEUAPP-MAINACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }


    public void enviarParaSegunda(View view) {

        Intent intent = new Intent(this,SegundaActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextNome);
        String message = editText.getText().toString();
        if(message.isEmpty()){
            Log.e(TAG,"ERRO-->Usuário tentou clicar no botão sem inserir texto!!");
        }else {

            intent.putExtra("EXTRA_MESSAGE", message);
            Log.d(TAG, "Botão foi acionado!");

            startActivity(intent);
        }

    }
}