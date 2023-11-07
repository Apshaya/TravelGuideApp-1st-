package com.example.dtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText uname,name,country,password,repass;
    Button reg_btn,sigin_btn;

    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        uname = findViewById(R.id.usrname);
        name = findViewById(R.id.inputname);
        country = findViewById(R.id.inputcountry);
        password = findViewById(R.id.inputpassword);
        repass = findViewById(R.id.repass);

        reg_btn = findViewById(R.id.buttonsignup);
        sigin_btn = findViewById(R.id.button);

        db=new DBHelper(this);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=uname.getText().toString();
                String name=country.getText().toString();
                String pssword=password.getText().toString();
                String repas=repass.getText().toString();


                if (user.equals("") || pssword.equals("")||repas.equals(""))
                    Toast.makeText(signup.this,"Enter all!",Toast.LENGTH_SHORT).show();

                else {
                    if (pssword.equals(repas)){
                        Boolean checkuser=db.checkuserName(user);
                        if (checkuser==false){
                            Boolean insert = db.insertData(user,pssword);
                            if (insert==true){
                                Toast.makeText(signup.this,"Registerd succesfully !",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),homwActivity.class);
                                startActivity(intent);

                            }else {
                                Toast.makeText(signup.this,"Registerd Fail !",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else
                        {
                            Toast.makeText(signup.this,"user alredy exits !",Toast.LENGTH_SHORT).show();

                        }
                    }
                    else {
                        Toast.makeText(signup.this,"password not match !",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });

        sigin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
    }
}