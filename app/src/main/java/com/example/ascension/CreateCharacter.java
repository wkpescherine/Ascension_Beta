package com.example.ascension;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.EditText;

public class CreateCharacter extends AppCompatActivity {
    CharDataConfig charSheet = new CharDataConfig();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
    }

    public void handleStyle(View v){
        TextView t1 = (TextView) v;
        String selectStyle = t1.getText().toString();
        TextView styleText = findViewById(R.id.charStyleHolder);
        charSheet.updateStyle(selectStyle);
        styleText.setText(selectStyle);
        setStats();
    }

    public void handleRace(View v){
        TextView t2 = (TextView) v;
        String selectRace = t2.getText().toString();
        TextView raceText = findViewById(R.id.charRaceHolder);
        charSheet.updateRace(selectRace);
        raceText.setText(selectRace);
        setStats();
    }

    public void handleClass(View v){
        TextView t3 = (TextView) v;
        String selectClass = t3.getText().toString();
        TextView classText = findViewById(R.id.charClassHolder);
        charSheet.updateClass(selectClass);
        classText.setText(selectClass);
        setStats();
    }

    public void backToMain(View v){
        charSheet.resetUI();
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

    public void loadSkills(View v){
        EditText nameChar = findViewById(R.id.editName);
        charSheet.charName = nameChar.getText().toString();
        if(charSheet.charName.length() != 0 && charSheet.charStyle.length() != 0 && charSheet.charRace.length() != 0 && charSheet.charClass.length() != 0){
            Intent intent2 = new Intent(this, SkillScreen.class);
            startActivity(intent2);
        }
    }

    public void setStats(){
        TextView strText = findViewById(R.id.str);
        TextView dexText = findViewById(R.id.dex);
        TextView conText = findViewById(R.id.con);
        TextView intText = findViewById(R.id.intel);
        TextView pieText = findViewById(R.id.pie);
        TextView quiText = findViewById(R.id.qui);
        TextView toHitText = findViewById(R.id.toHit);
        TextView dodgeText = findViewById(R.id.dodge);
        TextView afText = findViewById(R.id.armor);
        TextView spdText = findViewById(R.id.speed);
        TextView hpText = findViewById(R.id.hp);
        TextView powText = findViewById(R.id.pow);
        //stats array def -str int, pie, qui, dex, con
        strText.setText("STR: " + charSheet.charStats[0] +" + "+ charSheet.charBonus[0]);
        intText.setText("INT: " + charSheet.charStats[1] +" + "+ charSheet.charBonus[1]);
        pieText.setText("PIE: " + charSheet.charStats[2] +" + "+ charSheet.charBonus[2]);
        dexText.setText("DEX: " + charSheet.charStats[3] +" + "+ charSheet.charBonus[3]);
        quiText.setText("QUI: " + charSheet.charStats[4] +" + "+ charSheet.charBonus[4]);
        conText.setText("CON: " + charSheet.charStats[5] +" + "+ charSheet.charBonus[5]);
        hpText.setText("HP: " + charSheet.charStats[7]);
        powText.setText("POW: " +charSheet.charStats[8]);
        // stats array def - toHit, Dodge, AF, SPD
        toHitText.setText("toHit: "+ (charSheet.combatStats[0]+10));
        dodgeText.setText("Dodge: "+ charSheet.combatStats[1]);
        afText.setText("AF: 0");
        spdText.setText("SPD: "+ charSheet.combatStats[3]);
    }
}