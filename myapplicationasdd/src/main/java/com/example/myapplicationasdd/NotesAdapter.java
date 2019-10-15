package com.example.myapplicationasdd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter <NotesAdapter.NotesViewHolder>{
    private ArrayList<Note> notes;
private OnNoteClickListener onNoteClickListener;
    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }
interface OnNoteClickListener{
        void onNoteClick(int position);
     void onLongClick(int position);
}

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder notesViewHolder, int position) {
        Note note=notes.get(position);
        notesViewHolder.textViewTitle.setText(note.getTitle());
        notesViewHolder.textViewDescreption.setText(note.getDescreption());
        notesViewHolder.textViewDayOfWeek.setText(Note.getDayAsString(note.getDayOfWeek()+1));

int colorId = 0;
int priorety=note.getPriorety();
switch (priorety){
    case 1:
        colorId=notesViewHolder.itemView.getResources().getColor(android.R.color.holo_red_light);
        break;
    case 2:
        colorId=notesViewHolder.itemView.getResources().getColor(android.R.color.holo_green_dark);
        break;
    case 3:
        colorId=notesViewHolder.itemView.getResources().getColor(android.R.color.holo_blue_light);
        break;

}
notesViewHolder.textViewTitle.setBackgroundColor(colorId);
}


    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{
private TextView textViewTitle;
private TextView textViewDescreption;
private TextView textViewDayOfWeek;


        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            textViewDescreption=itemView.findViewById(R.id.textViewDescreption);
            textViewDayOfWeek=itemView.findViewById(R.id.textViewDayOfWeek);
itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (onNoteClickListener !=null){
            onNoteClickListener.onNoteClick(getAdapterPosition());
        }
    }
});
itemView.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        if (onNoteClickListener!=null){
            onNoteClickListener.onLongClick(getAdapterPosition());
        }
        return true;
    }
});
        }
    }
}
