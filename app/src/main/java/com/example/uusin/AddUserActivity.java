package com.example.uusin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import java.util.ArrayList;

public class AddUserActivity extends AppCompatActivity {
    private EditText editFirstName;
    private EditText editLastName;
    private EditText editEmail;
    private Button addUserButton;

    private RadioGroup radioDegreeProgram;
    private RadioButton seRadioButton;
    private RadioButton imRadioButton;
    private RadioButton ceRadioButton;
    private RadioButton eeRadioButton;

    private CheckBox bcCheckBox; // Ph. D.
    private CheckBox msCheckBox; // Lic.
    private CheckBox lciCheckBox; // B. Sc.
    private CheckBox phdCheckBox; // M. Sc.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        // EditText
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);

        // RadioButton
        radioDegreeProgram = findViewById(R.id.radioDegreeProgram);
        ceRadioButton = findViewById(R.id.ceRadioButton);
        seRadioButton = findViewById(R.id.seRadioButton);
        eeRadioButton = findViewById(R.id.eeRadioButton);
        imRadioButton = findViewById(R.id.imRadioButton);

        // CheckBox
        bcCheckBox = findViewById(R.id.bcCheckBox); // Ph. D.
        msCheckBox = findViewById(R.id.msCheckBox); // Lic.
        lciCheckBox = findViewById(R.id.lciCheckBox); // B. Sc.
        phdCheckBox = findViewById(R.id.phdCheckBox); // M. Sc.

        // Button
        addUserButton = findViewById(R.id.addUserButton);
    }

    public void addUser(View view) {
        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String email = editEmail.getText().toString();
        int selectedId = radioDegreeProgram.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        String major = radioButton.getText().toString();

        ArrayList<String> degrees = new ArrayList<>();
        if (bcCheckBox.isChecked()) degrees.add("Ph. D.");
        if (phdCheckBox.isChecked()) degrees.add("M. Sc.");
        if (lciCheckBox.isChecked()) degrees.add("B. Sc.");
        if (msCheckBox.isChecked()) degrees.add("Lic.");

        User user = new User(firstName, lastName, email, major, degrees);
        UserStorage.getInstance().addUser(user, this);

        finish(); // Sulkee aktiviteetin ja palaa edelliseen näkymään
    }
}