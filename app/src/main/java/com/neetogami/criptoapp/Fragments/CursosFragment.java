package com.neetogami.criptoapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.neetogami.criptoapp.Adapters.PersonAdapter;
import com.neetogami.criptoapp.Models.Person;
import com.neetogami.criptoapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CursosFragment extends Fragment {
    private List<Person> persons;
    private ListView listView;
    private PersonAdapter adapter;

    public CursosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cursos, container, false);
        persons = new ArrayList<Person>();
        listView = (ListView) view.findViewById(R.id.listViewPerson);
        adapter = new PersonAdapter(getContext(),R.layout.list_view_item_person,persons);
        listView.setAdapter(adapter);

        return view;
    }

    public void addPerson(Person person){
        this.persons.add(person);
        adapter.notifyDataSetChanged();
    }
}
