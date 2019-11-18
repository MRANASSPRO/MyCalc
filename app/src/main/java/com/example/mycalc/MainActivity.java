package com.example.mycalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean opPressed = false;
    private double nb1 = 0;
    private int n2Index = 0;
    private char opCourant;
    private int count = 0;
    TextView tv, scr;
    EditText resume;
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_Add, btn_Sub, btn_Mul, btn_Div, btn_calc, btn_dec, btn_clear, btn_undo, btn_openPar, btn_closePar, btn_carre, btn_sqrt;
    float Value1, Value2;
    boolean mAddition, mSubtract, mMultiplication, mDivision, done = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Java-XML binding

        //tv = findViewById(R.id.tv);
        btn_0 = findViewById(R.id.button21);
        btn_1 = findViewById(R.id.button19);
        btn_2 = findViewById(R.id.button18);
        btn_3 = findViewById(R.id.button17);
        btn_4 = findViewById(R.id.button14);
        btn_5 = findViewById(R.id.button13);
        btn_6 = findViewById(R.id.button16);
        btn_7 = findViewById(R.id.button3);
        btn_8 = findViewById(R.id.button12);
        btn_9 = findViewById(R.id.button10);
        btn_Add = findViewById(R.id.button22);
        btn_Div = findViewById(R.id.button20);
        btn_Sub = findViewById(R.id.button23);
        btn_Mul = findViewById(R.id.button15);
        btn_calc = findViewById(R.id.button24);
        btn_dec = findViewById(R.id.button5);
        btn_clear = findViewById(R.id.button11);
        btn_undo = findViewById(R.id.button4);
        btn_openPar = findViewById(R.id.button1);
        btn_closePar = findViewById(R.id.button2);
        btn_carre = findViewById(R.id.button7);
        btn_sqrt = findViewById(R.id.button8);

        resume = findViewById(R.id.editText);
        resume.setText("");
        final View.OnClickListener calListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch (id) {
                    //equals
                    case R.id.button24:
                        if (opPressed) {
                            if (opCourant == '+') {
                                String contenu = resume.getText().toString();
                                double nb2 = Double.parseDouble(contenu.substring(n2Index, contenu.length()));
                                nb2 += nb1;
                                resume.setText(String.valueOf(nb2));

                            }
                            if (opCourant == '-') {
                                String contenu = resume.getText().toString();
                                double nb2 = Double.parseDouble(contenu.substring(n2Index, contenu.length()));
                                nb2 = nb1 - nb2;
                                resume.setText(String.valueOf(nb2));

                            }
                            if (opCourant == '/') {
                                String contenu = resume.getText().toString();
                                double nb2 = Double.parseDouble(contenu.substring(n2Index, contenu.length()));
                                nb2 = nb1/nb2;
                                resume.setText(String.valueOf(nb2));
                            }
                            if (opCourant == '*') {
                                String contenu = resume.getText().toString();
                                double nb2 = Double.parseDouble(contenu.substring(n2Index, contenu.length()));
                                nb2 = nb1 * nb2;
                                resume.setText(String.valueOf(nb2));
                            }
                        }
                        break;
                    //multiplication
                    case R.id.button15:
                        //  screen.append(" * ");
                        String contenuM = resume.getText().toString();
                        n2Index = resume.length() + 1;
                        resume.append("*");
                        nb1 = Double.parseDouble(contenuM);
                        opPressed = true;
                        opCourant = '*';
                        break;
                    //soustraction
                    case R.id.button23:
                        // screen.setText("-");
                        String contenu1 = resume.getText().toString();
                        n2Index = resume.length() + 1;
                        resume.append("-");
                        nb1 = Double.parseDouble(contenu1);
                        opPressed = true;
                        opCourant = '-';
                        break;
                    //addition
                    case R.id.button22:
                        String contenu = resume.getText().toString();
                        n2Index = resume.length() + 1;
                        resume.append("+");
                        nb1 = Double.parseDouble(contenu);
                        opPressed = true;
                        opCourant = '+';
                        break;
                    //division
                    case R.id.button20:
                        // screen.append("/");
                        String contenuD = resume.getText().toString();
                        n2Index = resume.length() + 1;
                        resume.append("/");
                        nb1 = Double.parseDouble(contenuD);
                        opPressed = true;
                        opCourant = '/';
                        break;
                }
            }
        };

        btn_Mul.setOnClickListener(calListener);
        btn_Add.setOnClickListener(calListener);
        btn_Sub.setOnClickListener(calListener);
        btn_Div.setOnClickListener(calListener);
        btn_calc.setOnClickListener(calListener);

    }

    public void clickDigit(View view) {
        //if (view != btn_Add && view != btn_Sub && view != btn_Mul && view != btn_Div && view != btn_calc && view != btn_clear && view != btn_undo && view != btn_carre && view != btn_sqrt) {

        Button btn = (Button) view;
        String digit = btn.getText().toString();
        String screen = resume.getText().toString().trim();

        if (resume.equals(null)) {
            resume.setText(digit);
        } else {
            resume.append(digit);
        }

    }


    public void FillResume(View v) {
        Button btn = (Button) v;
        String OldResume = resume.getText().toString().trim();
        resume.setText(OldResume + btn.getText());
    }

    public void ClearResume() {
        resume.setText("");
    }

    public void ClickClear(View view) {
        resume.setText("");
        ClearResume();
    }
}
