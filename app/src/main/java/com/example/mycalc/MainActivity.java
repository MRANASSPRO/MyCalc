package com.example.mycalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //TextView tv;
    EditText ed1;
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_Add, btn_Sub, btn_Mul, btn_Div, btn_calc, btn_dec, btn_clear;
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
        ed1 = findViewById(R.id.editText);

    }

    public void clickDigit(View view) {
        if (view != btn_Add && view != btn_Sub && view != btn_Mul && view != btn_Div && view != btn_calc && view != btn_clear) {
            Button btn = (Button) view;
            String digit = btn.getText().toString();
            String screen = ed1.getText().toString().trim();

            if (ed1.equals(null)) {
                ed1.setText(digit);
            } else {
                ed1.append(digit);
            }
        } else {
            if (view == btn_clear) {
                ed1.setText(null);
            }

            if (view == btn_Add) {
                if (ed1 == null) {
                    mAddition = true;
                    //ed1.setText("");
                } else {
                    try {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        mAddition = true;
                        ed1.setText(null);
                    } catch (NumberFormatException exep) {
                        System.out.println(exep.getMessage());
                    }

                }
            }

            if (view == btn_Sub) {
                if (ed1 == null) {
                    mSubtract = true;
                    //ed1.setText("");
                } else {
                    try {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        mSubtract = true;
                        ed1.setText(null);
                    } catch (NumberFormatException exep) {
                        System.out.println(exep.getMessage());
                    }

                }

            }

            if (view == btn_Mul) {
                if (ed1 == null) {
                    mMultiplication = true;
                    //ed1.setText("");
                } else {
                    try {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        mMultiplication = true;
                        ed1.setText(null);
                    } catch (NumberFormatException exep) {
                        System.out.println(exep.getMessage());
                    }

                }

            }

            if (view == btn_Div) {
                if (ed1 == null) {
                    mDivision = true;
                    //ed1.setText("");
                } else {
                    try {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        mDivision = true;
                        ed1.setText(null);
                    } catch (NumberFormatException exep) {
                        System.out.println(exep.getMessage());
                    }

                }

            }

            if (view == btn_calc) {
                //String screen = ed1.getText().toString().trim();
                //String num = ed1.getText().toString();
                try {
                    Value2 = Float.parseFloat(ed1.getText() + "");

                    if (mAddition == true) {
                        ed1.setText(Value1 + Value2 + "");
                        mAddition = false;
                    }

                    if (mSubtract == true) {
                        ed1.setText(Value1 - Value2 + "");
                        mSubtract = false;
                    }

                    if (mMultiplication == true) {
                        ed1.setText(Value1 * Value2 + "");
                        mMultiplication = false;
                    }

                    if (mDivision == true) {
                        ed1.setText(Value1 / Value2 + "");
                        mDivision = false;
                    }

                } catch (NumberFormatException exep) {
                    System.out.println(exep.getMessage());
                }
            }
        }
    }
}
