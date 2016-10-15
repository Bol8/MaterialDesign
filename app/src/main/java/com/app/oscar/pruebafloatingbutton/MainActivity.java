package com.app.oscar.pruebafloatingbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String DEBUG_TAG = "AppCompatActivity";

    public static final String EXTRA_UPDATE = "update";
    public static final String EXTRA_DELETE = "delete";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_COLOR = "color";
    public static final String EXTRA_INITIAL = "initial";

    public static final String TRANSITION_FAB = "fab_transition";
    public static final String TRANSITION_INITIAL = "initial_transition";
    public static final String TRANSITION_NAME = "name_transition";
    public static final String TRANSITION_DELETE_BUTTON = "delete_button_transition";

    private RecyclerView recyclerView;
    private SampleMaterialAdapter adapter;
    private ArrayList<Card> cardsList = new ArrayList<>();
    private int[] colors;
    private String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
