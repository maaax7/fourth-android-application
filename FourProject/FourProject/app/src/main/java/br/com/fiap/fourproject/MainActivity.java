package br.com.fiap.fourproject;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView _img;
    private ImageView _img2;
    private TextView _resultado;

    private int[] dados = {
            R.drawable.dado1,
            R.drawable.dado2,
            R.drawable.dado3,
            R.drawable.dado4,
            R.drawable.dado5,
            R.drawable.dado6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _img = (ImageView)findViewById(R.id.img);
        _img2 = (ImageView)findViewById(R.id.img2);
        _resultado = (TextView)findViewById(R.id.txtResultado);

        _img.setImageResource(R.drawable.dado0);
        _img2.setImageResource(R.drawable.dado0);
    }

    public void Jogar(View v){
        //String fraseVencedor = String.valueOf(R.string.txtVencedor);
        String fraseVencedor = getResources().getString(R.string.txtVencedor);

        Random r = new Random();

        int jogadorAndroid = r.nextInt(5);
        int jogadorHumano = r.nextInt(5);

        _img.setImageResource(dados[jogadorAndroid]);
        _img2.setImageResource(dados[jogadorHumano]);

        if(jogadorAndroid > jogadorHumano)
            fraseVencedor += getResources().getString(R.string.txtAndroid);
        else if(jogadorAndroid < jogadorHumano)
            fraseVencedor += getResources().getString(R.string.txtHumano);
        else
            fraseVencedor += getResources().getString(R.string.txtEmpate);

        _resultado.setText(fraseVencedor);
    }
}
