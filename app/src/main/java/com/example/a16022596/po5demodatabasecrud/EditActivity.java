package com.example.a16022596.po5demodatabasecrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EditActivity extends AppCompatActivity {

    TextView tvId;
    EditText etEditContent;
    Button btnDelete,btnUpdate;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tvId = (TextView)findViewById(R.id.textViewId);
        etEditContent = (EditText)findViewById(R.id.editTextUpdateContent);
        btnDelete = (Button)findViewById(R.id.buttonDelete);
        btnUpdate = (Button)findViewById(R.id.buttonUpdate);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");

        tvId.setText("ID: " + data.getId());
        etEditContent.setText(data.getNoteContent());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBhelper dbh = new DBhelper(EditActivity.this);
                data.setNoteContent(etEditContent.getText().toString());
                dbh.updateNote(data);
                dbh.close();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBhelper dbh = new DBhelper(EditActivity.this);
                dbh.deleteNote(data.getId());
                dbh.close();
            }
        });


    }
}
