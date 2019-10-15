package com.example.myapplicationasdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
private EditText editTextTitle;
private EditText editTextDescreption;
private Spinner  spinnerDaysOfWek;
private RadioGroup  radioGroupPriorety;
//private NotesDBHelper dbHelper;
//private SQLiteDatabase database;
//    private NotesDatabase database;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
//
//        dbHelper=new NotesDBHelper(this);
//        database=dbHelper.getWritableDatabase();
//
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
//        database=NotesDatabase.getInstance(this);
        editTextTitle=findViewById(R.id.editTextTitle);
        editTextDescreption=findViewById(R.id.editTextDescreption);
        spinnerDaysOfWek=findViewById(R.id.spinnerDaysOfWek);
        radioGroupPriorety=findViewById(R.id.radioGrupProereti);
    }

    public void onClickSaveNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String descreption = editTextDescreption.getText().toString().trim();
       int dayofWe = spinnerDaysOfWek.getSelectedItemPosition();
        int radioButonId = radioGroupPriorety.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButonId);
        int prioreti = Integer.parseInt(radioButton.getText().toString());

        if (isFiled(title,descreption)){
            Note note =new Note(title,descreption,dayofWe,prioreti);
//            database.notesDao().insertNote(note);
            viewModel.insertNote(note);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "dolgen", Toast.LENGTH_SHORT).show();
        }
//        Note note =new Note(title,descreption,dayofWe,prioreti);
//        MainActivity.notes.add(note);
//        if (isFiled(title, descreption)) {
//            ContentValues contentValues = new ContentValues();
//            contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE, title);
//            contentValues.put(NotesContract.NotesEntry.COLUMN_DESCREPTION, descreption);
//            contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK, dayofWe+1);
//            contentValues.put(NotesContract.NotesEntry.COLUMN_PRIORITY, prioreti);
////            database.insert(NotesContract.NotesEntry.TABLE_NAME, null, contentValues);
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);
//        }else {
//            Toast.makeText(this, "dolgen", Toast.LENGTH_SHORT).show();
//        }
    }

    private boolean isFiled(String title,String descreption){
        return !title.isEmpty()&&!descreption.isEmpty();

    }
}
