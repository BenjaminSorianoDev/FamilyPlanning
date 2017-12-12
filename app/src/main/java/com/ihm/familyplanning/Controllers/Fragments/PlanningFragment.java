package com.ihm.familyplanning.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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

    public PlanningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planning, container, false);

        // données du tableau
        final String [] col1 = {"col1:ligne1","col1:ligne2","col1:ligne3","col1:ligne4","col1:ligne5"};
        final String [] col2 = {"col2:ligne1","col2:ligne2","col2:ligne3","col2:ligne4","col2:ligne5"};

        TableLayout table = view.findViewById(R.id.idTable); // on prend le tableau défini dans le layout
        TableRow row; // création d'un élément : ligne
        TextView tv1,tv2; // création des cellules

        // pour chaque ligne
        for(int i=0;i<col1.length;i++) {
            row = new TableRow(getActivity()); // création d'une nouvelle ligne

            final int id=i;
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // faites ici ce que vous voulez
                    Log.d("mydebug","i="+id);
                }
            });

            tv1 = new TextView(getActivity()); // création cellule
            tv1.setText(col1[i]); // ajout du texte
            tv1.setGravity(Gravity.CENTER); // centrage dans la cellule
            // adaptation de la largeur de colonne à l'écran :
            tv1.setLayoutParams( new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );

            // idem 2ème cellule
            tv2 = new TextView(getActivity());
            tv2.setText(col2[i]);
            tv2.setGravity(Gravity.CENTER);
            tv2.setLayoutParams( new TableRow.LayoutParams( 0, android.view.ViewGroup.LayoutParams.WRAP_CONTENT, 1 ) );

            // ajout des cellules à la ligne
            row.addView(tv1);
            row.addView(tv2);

            // ajout de la ligne au tableau
            table.addView(row);
        }
        return view;
    }

}
