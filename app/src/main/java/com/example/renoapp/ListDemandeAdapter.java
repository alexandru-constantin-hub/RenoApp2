package com.example.renoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListDemandeAdapter extends ArrayAdapter<Demande> {
   Context context;
   int resource;
   List<Demande> demandeList;

    ListDemandeAdapter(Context context, int resource, List<Demande> demandeList) {
        super(context, resource, demandeList);
        this.context = context;
        this.resource = resource;
        this.demandeList = demandeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,null,false);
        TextView piece = view.findViewById(R.id.list_piece);
        TextView description = view.findViewById(R.id.list_description);
        TextView budget = view.findViewById(R.id.list_budget);
        TextView deadline = view.findViewById(R.id.list_deadline);
        Demande demande = demandeList.get(position);
        piece.setText(demande.getPiece());
        description.setText(demande.getDescription());
        budget.setText(demande.getBudget());
        deadline.setText(demande.getDeadline());
        return view;
    }
}
