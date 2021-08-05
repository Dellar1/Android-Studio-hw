package com.example.practika2;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

//import android.widget.ListView;

import com.example.practika2.adapters.PeopleAdapter;
import com.example.practika2.models.Person;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvItems;
    Button btnAdd;
    ImageView imgViewNewUserPhoto;
    EditText etFirstName,etLastName,etPhone;

    List<Person> people = new ArrayList<>();
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = findViewById(R.id.lvItems);
        imgViewNewUserPhoto = findViewById(R.id.imgViewNewUserPhoto);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etPhone = findViewById(R.id.etPhone);
        btnAdd = findViewById(R.id.btnAdd);



        ArrayList<Person> people = new ArrayList<>();

        people.add(new Person("First name 1", "Last name 1", "Phone1", "https://pngimg.com/uploads/mario/mario_PNG53.png"));
        people.add(new Person("First name 2", "Last name 2", "Phone1", "https://avatanplus.ru/files/resources/original/57a726e809c0715664effa68.png"));
        people.add(new Person("First name 3", "Last name 3", "Phone1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwS70r6aZEg6-wofSf66x7MU7FiZSEFSOIQA&usqp=CAU"));
        people.add(new Person("First name 1", "Last name 1", "Phone1", "https://pngimg.com/uploads/mario/mario_PNG53.png"));
        people.add(new Person("First name 2", "Last name 2", "Phone1", "https://avatanplus.ru/files/resources/original/57a726e809c0715664effa68.png"));
        people.add(new Person("First name 3", "Last name 3", "Phone1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwS70r6aZEg6-wofSf66x7MU7FiZSEFSOIQA&usqp=CAU"));

        PeopleAdapter adapter = new PeopleAdapter(this, R.layout.person_layout, people);
        btnAdd.setOnClickListener(v -> {
            String firstName = etFirstName.getText().toString();
            String lastName = etLastName.getText().toString();
            String phone = etPhone.getText().toString();
            String image = imgViewNewUserPhoto.getAccessibilityClassName().toString();
            people.add(new Person(firstName,lastName,phone,image));
            adapter.notifyDataSetChanged();
        });
        lvItems.setAdapter(adapter);

    }
}