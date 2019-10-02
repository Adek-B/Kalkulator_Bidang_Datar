package com.example.kalkulatorbidangdatar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button BtnHtgPersegi;
    Button BtnHtgSegitiga;
    Button BtnHtgLingkaran;
    EditText FormInput1, FormInput2;
    TextView HitungLuas, HitungKeliling;
    double ValInput1, ValInput2, ValLuas, ValKel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnHtgPersegi = (Button)findViewById(R.id.Persegi);
        BtnHtgSegitiga = (Button)findViewById(R.id.Segitiga);
        BtnHtgLingkaran = (Button)findViewById(R.id.Lingkaran);
        FormInput1 = (EditText)findViewById(R.id.formInput1);
        FormInput2 = (EditText)findViewById(R.id.formInput2);
        HitungLuas = (TextView)findViewById(R.id.textHasil1);
        HitungKeliling = (TextView)findViewById(R.id.textHasil2);

        BtnHtgPersegi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(FormInput1.getText().toString().trim())){
                    Toast myMsg = Toast.makeText(getApplicationContext(), R.string.errPersegi1,Toast.LENGTH_SHORT);
                    myMsg.show();
                }else if(TextUtils.isEmpty(FormInput2.getText().toString().trim())) {
                    Toast myMsg = Toast.makeText(getApplicationContext(), R.string.errPersegi2, Toast.LENGTH_SHORT);
                    myMsg.show();
                }else {
                    ValInput1 = Double.parseDouble(FormInput1.getText().toString());
                    ValInput2 = Double.parseDouble(FormInput2.getText().toString());
                    ValLuas = ValInput1 * ValInput2;
                    ValKel = (ValInput1 * 2) + (ValInput2 * 2);
                    HitungLuas.setText("Luas : " + String.format("%.2f", ValLuas));
                    HitungKeliling.setText("Keliling : " + String.format("%.2f", ValKel));
                }
            }
        });

        BtnHtgSegitiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(FormInput1.getText().toString().trim())){
                    Toast myMsg = Toast.makeText(getApplicationContext(), R.string.errSegitiga1,Toast.LENGTH_SHORT);
                    myMsg.show();
                }else if(TextUtils.isEmpty(FormInput2.getText().toString().trim())){
                    Toast myMsg = Toast.makeText(getApplicationContext(), R.string.errSegitiga2,Toast.LENGTH_SHORT);
                    myMsg.show();
                }else {
                    double sisi;
                    ValInput1 = Double.parseDouble(FormInput1.getText().toString());
                    ValInput2 = Double.parseDouble(FormInput2.getText().toString());
                    ValLuas = (ValInput1 * ValInput2) / 2;
                    sisi = Math.sqrt(Math.pow(ValInput1, 2) + Math.pow(ValInput2, 2));
                    ValKel = (ValInput1 + ValInput2 + sisi);
                    HitungLuas.setText("Luas : " + String.format("%.2f", ValLuas));
                    HitungKeliling.setText("Keliling : " + String.format("%.2f", ValKel));
                }
            }
        });

        BtnHtgLingkaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(FormInput1.getText().toString().trim())){
                    Toast myMsg = Toast.makeText(getApplicationContext(), R.string.errLingkaran1,Toast.LENGTH_SHORT);
                    myMsg.show();
                }else{
                    ValInput1 = Double.parseDouble(FormInput1.getText().toString());
                    ValInput2 = ValInput1 / 2; //turn this to radius
                    ValLuas = Math.PI * Math.pow(ValInput2, 2);
                    ValKel = 2 * Math.PI * ValInput2;
                    HitungLuas.setText("Luas : " + String.format("%.2f", ValLuas));
                    HitungKeliling.setText("Keliling : " + String.format("%.2f", ValKel));
                }
            }
        });
    }
}
