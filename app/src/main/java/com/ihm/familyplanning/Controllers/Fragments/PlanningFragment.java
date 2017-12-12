package com.ihm.familyplanning.Controllers.Fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.ihm.familyplanning.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlanningFragment extends Fragment {

    private boolean even = true;
    public PlanningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planning, container, false);

        TableLayout table = view.findViewById(R.id.idTable); // on prend le tableau défini dans le layout
        TableRow row; // création d'un élément : ligne
        row = this.addRow("heure","pseudo","rdv",true);
        table.addView(row);
        row = this.addRow("20h","Papa","Soirée OM-PSG avec les potes",false);
        table.addView(row);
        row = this.addRow("17h","Maman","rdv chez la gynecologue",false);
        table.addView(row);
        row = this.addRow("16h","Manon","Piano",false);
        table.addView(row);

        return view;
    }

    private TableRow addRow(String hour, String pseudo, String rdv, boolean isFirst){
        TableRow row; // création d'un élément : ligne
        TextView tv1,tv2,tv3; // création des cellules

        row = new TableRow(getActivity());
        if(even) {
            row.setBackgroundColor(this.getResources().getColor(R.color.colorEvenTab));
            even = false;
        }
        else{
            row.setBackgroundColor(this.getResources().getColor(R.color.colorOddTab));
            even = true;
        }
        if(!isFirst) {
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
        tv1 = new TextView(getActivity()); // création cellule
        tv1.setText(hour); // ajout du texte
        tv1.setGravity(Gravity.CENTER); // centrage dans la cellule
        tv1.setTextSize(18f);
        // adaptation de la largeur de colonne à l'écran :
        tv1.setLayoutParams( new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );

        // idem 2ème cellule
        tv2 = new TextView(getActivity());
        tv2.setText(pseudo);
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextSize(18f);
        tv2.setLayoutParams( new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );


        // column 3
        tv3 = new TextView(getActivity());
        tv3.setText(rdv);
        tv3.setGravity(Gravity.CENTER);
        tv3.setTextSize(18f);
        tv3.setLayoutParams( new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );

        if(isFirst)
        {
            tv1.setTypeface(null, Typeface.BOLD);
            tv2.setTypeface(null, Typeface.BOLD);
            tv3.setTypeface(null, Typeface.BOLD);
        }
        // ajout des cellules à la ligne
        row.addView(tv1);
        row.addView(tv2);
        row.addView(tv3);

        return row;
    }

}
