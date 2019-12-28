package br.edu.ifms.calculadoratempo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText horaA;
    private EditText horaB;
    private EditText horaC;
    private EditText minA;
    private EditText minB;
    private EditText minC;
    private EditText segA;
    private EditText segB;
    private EditText segC;
    private Button btnAdicao;
    private Button button2;
    private Button btnSubtracao;
    private Button btnGuardar;
    private CheckBox guardarAuto;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;

    public void adicao(){
        int hora1 = 0;
        int min1 = 0;
        int seg1 = 0;

        int hora2 = 0;
        int min2 = 0;
        int seg2 = 0;


        int res1 = 0;
        int res2 = 0;

        try {
            hora1 = Integer.parseInt(horaA.getText().toString());
            min1 = Integer.parseInt(minA.getText().toString());
            seg1 = Integer.parseInt(segA.getText().toString());


            hora2 = Integer.parseInt(horaB.getText().toString());
            min2 = Integer.parseInt(minB.getText().toString());
            seg2 = Integer.parseInt(segB.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "Nenhum valor a calcular", Toast.LENGTH_SHORT).show();
        }

        res1 = (60 * hora1)+ min1;   //transforma hora em minuto e soma com os minutos que foram informados
        res1 = (60 * res1) + seg1; //transforma minuto em segundo e soma com os segundos que foram informados

        res2 = (60 * hora2)+ min2;   //transforma hora em minuto e soma com os minutos que foram informados
        res2 = (60 * res2)+ seg2; //transforma minuto em segundo e soma com os segundos que foram informados

        int input = res1 + res2;
        int horas = input / 3600;
        int minutos = (input - (horas * 3600)) / 60;
        int segundos = input - (horas * 3600) - (minutos * 60);

        horaC.setText(Integer.toString(horas));
        minC.setText(Integer.toString(minutos));
        segC.setText(Integer.toString(segundos));

        if(guardarAuto.isChecked()){
            guardar(true);
        }
    }

    public void subtracao(){
        int hora1 = 0;
        int min1 = 0;
        int seg1 = 0;

        int hora2 = 0;
        int min2 = 0;
        int seg2 = 0;

        int res1 = 0;
        int res2 = 0;

        try {
            hora1 = Integer.parseInt(horaA.getText().toString());
            min1 = Integer.parseInt(minA.getText().toString());
            seg1 = Integer.parseInt(segA.getText().toString());


            hora2 = Integer.parseInt(horaB.getText().toString());
            min2 = Integer.parseInt(minB.getText().toString());
            seg2 = Integer.parseInt(segB.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "Nenhum valor a calcular", Toast.LENGTH_SHORT).show();
        }


        res1 = (60 * hora1)+ min1;   //transforma hora em minuto e soma com os minutos que foram informados
        res1 = (60 * res1) + seg1; //transforma minuto em segundo e soma com os segundos que foram informados

        res2 = (60 * hora2)+ min2;   //transforma hora em minuto e soma com os minutos que foram informados
        res2 = (60 * res2)+ seg2; //transforma minuto em segundo e soma com os segundos que foram informados

        int input = res1 - res2;
        int horas = input / 3600;
        int minutos = (input - (horas * 3600)) / 60;
        int segundos = input - (horas * 3600) - (minutos * 60);

        if (input >= 0) {
            horaC.setText(Integer.toString(horas));
            minC.setText(Integer.toString(minutos));
            segC.setText(Integer.toString(segundos));
        }else {
            horaC.setText(Integer.toString(horas*-1));
            minC.setText(Integer.toString(minutos*-1));
            segC.setText(Integer.toString(segundos*-1));
        }
        if(guardarAuto.isChecked()){
            guardar(true);
        }
    }

    public void reset(ViewGroup group){
        int cont = group.getChildCount();
        for (int i=0; i<cont; i++){
            View view = group.getChildAt(i);
            if (view instanceof EditText){
                ((EditText)view).setText("");
            }
        }
        horaA.requestFocus();
    }

    public void guardar(boolean guardaAuto){

        if (!horaC.getText().equals("") && guardaAuto == true){
            String hora3 = horaC.getText().toString();
            String min3 = minC.getText().toString();
            String seg3 = segC.getText().toString();
            reset((ViewGroup)findViewById(R.id.parent));

            horaA.setText(hora3);
            minA.setText(min3);
            segA.setText(seg3);

            horaC.setText(hora3);
            minC.setText(min3);
            segC.setText(seg3);

        }else if(!horaC.getText().equals("") && guardaAuto == false){
            String hora3 = horaC.getText().toString();
            String min3 = minC.getText().toString();
            String seg3 = segC.getText().toString();
            reset((ViewGroup)findViewById(R.id.parent));

            horaA.setText(hora3);
            minA.setText(min3);
            segA.setText(seg3);
        } else{
            Toast.makeText(this, "Nenhum valor a guardar", Toast.LENGTH_SHORT).show();
        }
        horaB.requestFocus();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        horaA = findViewById(R.id.horaA);
        horaB = findViewById(R.id.horaB);
        horaC = findViewById(R.id.horaC);
        minA = findViewById(R.id.minA);
        minB = findViewById(R.id.minB);
        minC = findViewById(R.id.minC);
        segA = findViewById(R.id.segA);
        segB = findViewById(R.id.segB);
        segC = findViewById(R.id.segC);
        btnAdicao = findViewById(R.id.btnAdicao);
        button2 = findViewById(R.id.button2);
        btnSubtracao = findViewById(R.id.btnSubtracao);
        btnGuardar = findViewById(R.id.btnGuardar);
        guardarAuto = findViewById(R.id.guardarAuto);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);

        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicao();
            }
        });

        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtracao();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset((ViewGroup)findViewById(R.id.parent));
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(false);
            }
        });

    }
}
