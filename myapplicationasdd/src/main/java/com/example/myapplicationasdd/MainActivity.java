package com.example.myapplicationasdd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerViewNotes;
private final ArrayList<Note> notes=new ArrayList<>();
 private NotesAdapter adapter;

 private MainViewModel viewModel;
// private NotesDatabase database;

 //SQLLIte
// private NotesDBHelper dbHelper;
//private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
     viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        database=NotesDatabase.getInstance(this);
        recyclerViewNotes=findViewById(R.id.recylerViewNotes);

        //Sqllite
//        dbHelper=new NotesDBHelper(this);
//       database=dbHelper.getWritableDatabase();
       //


//        database.delete(NotesContract.NotesEntry.TABLE_NAME,null,null);

//        if (notes.isEmpty()) {
//
//        }
//        for (Note note:notes){
//            ContentValues contentValues=new ContentValues();
//            contentValues.put(NotesContract.NotesEntry.COLUMN_TITLE,note.getTitle());
//            contentValues.put(NotesContract.NotesEntry.COLUMN_DESCREPTION,note.getDescreption());
//            contentValues.put(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK,note.getDayOfWeek());
//            contentValues.put(NotesContract.NotesEntry.COLUMN_PRIORITY,note.getPriorety());
//            database.insert(NotesContract.NotesEntry.TABLE_NAME,null,contentValues);
//        }
//        ArrayList<Note>notesFromDb=new ArrayList<>();
getData();
 adapter=new NotesAdapter(notes);
recyclerViewNotes.setLayoutManager(new GridLayoutManager(this,3));
recyclerViewNotes.setAdapter(adapter);
adapter.setOnNoteClickListener(new NotesAdapter.OnNoteClickListener() {
    @Override
    public void onNoteClick(int position) {
        Toast.makeText(MainActivity.this, "Nomber "+position, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongClick(int position) {
remove(position);
    }
});
        ItemTouchHelper itemTouchHelper =new ItemTouchHelper
                (new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
remove(viewHolder.getAdapterPosition());
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);
    }
    private void remove(int position){
//        int id=notes.get(position).getId();
        //SQLite
//        String were= NotesContract.NotesEntry._ID+"=?";
//        String [] wereArgs=new String[]{Integer.toString(id)};
//
//        database.delete(NotesContract.NotesEntry.TABLE_NAME,were,wereArgs);
        //
//        notes.remove(position);

        Note note=notes.get(position);
        viewModel.deletNote(note);
//database.notesDao().deleteNote(note);
//        adapter.notifyDataSetChanged();
//        getData();
//        getData();
    }

    public void onClickNode(View view) {
        Intent intent=new Intent(this,AddNoteActivity.class);

        startActivity(intent);
    }

    //SqlLite
//    private void getData(){
//        notes.clear();
//        String selection= NotesContract.NotesEntry.COLUMN_PRIORITY+"< ?";
//        String[]selectionArgs=new String[]{"7"};
//        Cursor coursor=database.query(NotesContract.NotesEntry.TABLE_NAME,null,selection,selectionArgs,null,null,null);
//        while (coursor.moveToNext()){
//            int id =coursor.getInt(coursor.getColumnIndex(NotesContract.NotesEntry._ID));
//            String title=coursor.getString(coursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_TITLE));
//            String descreption=coursor.getString(coursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_DESCREPTION));
//          int dayOfWeek=coursor.getInt(coursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_DAY_OF_WEEK));
//            int prorety=coursor.getInt(coursor.getColumnIndex(NotesContract.NotesEntry.COLUMN_PRIORITY));
//            Note note=new Note(id,title,descreption,dayOfWeek,prorety);
//            notes.add(note);
//
//        }
//        coursor.close();
//    }
    //
    private void getData(){
    LiveData <List <Note>> notesfromDb=viewModel.getNotes();
    notesfromDb.observe(this, new Observer<List<Note>>() {
        @Override
        public void onChanged(List<Note> notesFromLiveData) {
            notes.clear();
            notes.addAll(notesFromLiveData);
            adapter.notifyDataSetChanged();
        }
    });

    }
}
