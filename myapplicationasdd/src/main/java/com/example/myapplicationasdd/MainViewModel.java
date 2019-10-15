package com.example.myapplicationasdd;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static NotesDatabase database;
    private LiveData<List<Note>>notes;
    public MainViewModel(@NonNull Application application) {
        super(application);
        database=NotesDatabase.getInstance(getApplication());
        notes=database.notesDao().getAllNotes();
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }
    public void insertNote(Note note){
        new InsertTask().execute(note);

    }
    public void deletNote(Note note){
        new DeletTask().execute(note);

    }
    public void deleteAllNote(){
        new DeletAllTask().execute();

    }
    private static class InsertTask extends AsyncTask<Note,Void,Void>{

        @Override
        protected Void doInBackground(Note... notes) {
            if (notes!=null&&notes.length>0){
                database.notesDao().insertNote(notes[0]);
            }
            return null;
        }
    }
    private static class DeletTask extends AsyncTask<Note,Void,Void>{

        @Override
        protected Void doInBackground(Note... notes) {
            if (notes!=null&&notes.length>0){
                database.notesDao().deleteNote(notes[0]);
            }
            return null;
        }
    }

    private static class DeletAllTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... notes) {
           database.notesDao().deleteAllNote();

            return null;
        }
    }

}
