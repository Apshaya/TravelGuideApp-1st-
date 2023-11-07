package com.example.dtravel;

import static com.example.dtravel.R.id.addname;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class adddetails extends AppCompatActivity {

    Databasehelper mydb;
    EditText editName,editabout,editdetails,EditId;
    Button btnAddData,btnViewAll,btnUpdateData,btnDeleteData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddetails);

        setContentView(R.layout.activity_adddetails);
        mydb = new Databasehelper(this);

        editName = findViewById(R.id.addname);
        editabout = findViewById(R.id.addcountry);
        editdetails = findViewById(R.id.adddetails);
        EditId = findViewById(R.id.editTextNumber2);

        btnAddData = findViewById(R.id.button2);
        btnViewAll = findViewById(R.id.button3);
        btnUpdateData = findViewById(R.id.button4);
        btnDeleteData  = findViewById(R.id.button5);


        addData();
        viewAll();
        updateData();
        deleteData();
    }

    public void  addData(){
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = mydb.insertData(editName.getText().toString(),editabout.getText().toString(),editdetails.getText().toString());
                if (isInserted == true)
                    Toast.makeText(adddetails.this,"Data Inserted Succesffuly",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(adddetails.this,"Data Not Inserted Succesffuly",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAll(){
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor results = mydb.getAllData();
                if (results.getCount()==0){
                    showMessage("Error Message :", "No Data Avalible in the Database");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (results.moveToNext()){
                    buffer.append("ID :" + results.getString(0)+"\n");
                    buffer.append("NAME :" + results.getString(1)+"\n");
                    buffer.append("About Me :" + results.getString(2)+"\n");
                    buffer.append("Contact Number :" + results.getString(3)+"\n  \n");

                    showMessage("List of Data", buffer.toString());
                }
            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void updateData(){
        btnUpdateData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = mydb.updateData(EditId.getText().toString(),editName.getText().toString(),
                                editabout.getText().toString(),editdetails.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(adddetails.this,"Data Updated" ,Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(adddetails.this,"Data not Updated", Toast.LENGTH_LONG).show();

                    }
                }
        );


    }
    public void deleteData(){
        btnDeleteData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedatarows = mydb.deleteData(EditId.getText().toString());
                        if (deletedatarows>0)
                            Toast.makeText(adddetails.this,"Data Deleted" ,Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(adddetails.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}

