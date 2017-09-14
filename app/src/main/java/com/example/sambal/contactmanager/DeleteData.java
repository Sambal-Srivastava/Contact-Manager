package com.example.sambal.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteData extends AppCompatActivity {
    Button delete;
    EditText number;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);
        number= (EditText) findViewById(R.id.etNumber);
        delete= (Button) findViewById(R.id.btDelete);
        databaseHelper=new DatabaseHelper(this);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteData(number.getText().toString());
                Toast.makeText(DeleteData.this,"Data Deleted Successfully",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
