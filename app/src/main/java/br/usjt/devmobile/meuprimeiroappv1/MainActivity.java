package br.usjt.devmobile.meuprimeiroappv1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MEUAPP-MAINACTIVITY";

    Button buttomEnviar;
    private Button alertDialogButton;


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

            alertDialogButton = (Button) findViewById(R.id.buttomEnviar);

            buttomEnviar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Erro!!!");
                    builder.setMessage("O nome não pode estar vazio.");
                    builder.setCancelable(false);

                    builder.setPositiveButton("Entendido.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "OK.",Toast.LENGTH_LONG).show();
                        }
                    });

                    builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });

                    AlertDialog alert=builder.create();

                    alert.show();


                }

            });

        }else {

            intent.putExtra("EXTRA_MESSAGE", message);
            Log.d(TAG, "Botão foi acionado!");

            startActivity(intent);
        }

    }

    public void openDialog(){

    }
}

