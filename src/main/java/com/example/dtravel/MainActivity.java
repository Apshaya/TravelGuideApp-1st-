package com.example.dtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class    MainActivity extends AppCompatActivity {

    EditText useremail,password;
    Button login_btn,buttonsign;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useremail=findViewById(R.id.usrname);
        password=findViewById(R.id.inputpassword);
        login_btn=findViewById(R.id.buttonlogin);
        buttonsign=findViewById(R.id.buttonsign);

        db=new DBHelper(this);

        buttonsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"Login now!",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(), signup.class);
                startActivity(intent);



            }


        });
        login_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user=useremail.getText().toString();
                String psword=password.getText().toString();

                if (user.equals("")||psword.equals(""))
                    Toast.makeText(MainActivity.this,"Plese enter all details!",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkpass=db.checkuserPassword(user,psword);
                    if (checkpass==true){
                        Toast.makeText(MainActivity.this,"Login succesfully !",Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(getApplicationContext(), homwActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(MainActivity.this,"Invalid deta !",Toast.LENGTH_SHORT).show();

                    }
                }
            }

        });
    }
}
