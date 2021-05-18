package com.example.obvplanner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestsFragment extends Fragment {


RecyclerView recyclerView1;
RecyclerView.Adapter adapter1;
RecyclerView recyclerView2;
RecyclerView.Adapter adapter2;
RecyclerView.LayoutManager layoutManager1;
RecyclerView.LayoutManager layoutManager2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuestsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestsFragment newInstance(String param1, String param2) {
        QuestsFragment fragment = new QuestsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quests, container, false);


        //CardHolder etc. um die Quests darzustellen
        List<Quest> questListActive = MainActivity.getQuestListActive();

        recyclerView1 = view.findViewById(R.id.recyclerView1);
        recyclerView1.setHasFixedSize(false);
        //adapter1 = new RVcustomAdapter(MainActivity.getQuestListActive());
        adapter1 = new RVcustomAdapter(MainActivity.questList);
        layoutManager1 = new LinearLayoutManager(getContext());
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(adapter1);

        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(false);
        adapter2 = new RVcustomAdapter(MainActivity.getQuestListFinished());
        layoutManager2 = new LinearLayoutManager(getContext());
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter2);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        adapter1.notifyDataSetChanged();
       // adapter2.notifyDataSetChanged();
    }
}