package com.app.oscar.pruebafloatingbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Oscar on 15/10/2016.
 */

public class SampleMaterialAdapter extends RecyclerView.Adapter<SampleMaterialAdapter.ViewHolder> {
    private static final String DEBUG_TAG = "SampleMaterialAdapter";

    public Context context;
    public ArrayList<Card> cardsList;




    public void animateCircularDelete(final View view, final int list_position) {
        int centerX = view.getWidth();
        int centerY = view.getHeight();
        int startRadius = view.getWidth();
        int endRadius = 0;
        Animator animation = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius);

        animation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                Log.d(DEBUG_TAG, "SampleMaterialAdapter onAnimationEnd for Edit adapter position " + list_position);
                Log.d(DEBUG_TAG, "SampleMaterialAdapter onAnimationEnd for Edit cardId " + getItemId(list_position));

                view.setVisibility(View.INVISIBLE);
                cardsList.remove(list_position);
                notifyItemRemoved(list_position);
            }
        });
        animation.start();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView initial;
        private TextView name;
        private Button deleteButton;

        public ViewHolder(View v) {
            super(v);
            initial = (TextView) v.findViewById(R.id.initial);
            name = (TextView) v.findViewById(R.id.name);
            deleteButton = (Button) v.findViewById(R.id.delete_button);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // animateCircularDelete(itemView, getAdapterPosition());
                }
            });

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Pair<View, String> p1 = Pair.create((View) initial, MainActivity.TRANSITION_INITIAL);
                Pair<View, String> p2 = Pair.create((View) name, MainActivity.TRANSITION_NAME);
                Pair<View, String> p3 = Pair.create((View) deleteButton, MainActivity.TRANSITION_DELETE_BUTTON);

                ActivityOptionsCompat options;
                Activity act = (AppCompatActivity) context;
                options = ActivityOptionsCompat.makeSceneTransitionAnimation(act, p1, p2, p3);

                int requestCode = getAdapterPosition();
                String name = cardsList.get(requestCode).getName();
                int color = cardsList.get(requestCode).getColorResource();

                Log.d(DEBUG_TAG, "SampleMaterialAdapter itemView listener for Edit adapter position " + requestCode);

                Intent transitionIntent = new Intent(context, TransitionEditActivity.class);
                transitionIntent.putExtra(MainActivity.EXTRA_NAME, name);
                transitionIntent.putExtra(MainActivity.EXTRA_INITIAL, Character.toString(name.charAt(0)));
                transitionIntent.putExtra(MainActivity.EXTRA_COLOR, color);
                transitionIntent.putExtra(MainActivity.EXTRA_UPDATE, false);
                transitionIntent.putExtra(MainActivity.EXTRA_DELETE, false);
                ((AppCompatActivity) context).startActivityForResult(transitionIntent, requestCode, options.toBundle());
            }
        });
        }
    }
}


