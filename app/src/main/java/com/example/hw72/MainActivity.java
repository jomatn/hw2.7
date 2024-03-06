package com.example.hw72;
import static com.example.hw72.R.id.spinner;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private StringBuilder currentInput;
    private boolean isOperationOver;
    private Integer first, second;
    private String operator;
    private String result;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        currentInput = new StringBuilder();
    }

    public void onNumberClick(View view) {
        if (isOperationOver) {
            textView.setText("0");
            isOperationOver = false;
        }

        if (view instanceof Button) {
            String text = ((Button) view).getText().toString();
            if (text.equals("A/C")) {
                textView.setText("0");
                currentInput.setLength(0);
            } else if (textView.getText().toString().equals("0")) {
                textView.setText(text);
                currentInput.setLength(0);
                currentInput.append(text);
            } else {
                textView.append(text);
                currentInput.append(text);
            }
        }
    }

    public void onOperatorClick(View view) {
        if (view.getId() == R.id.oper4) {
            operator = "+";
            first = Integer.valueOf(textView.getText().toString());
            currentInput.setLength(0);
            textView.setText("");
        } else if (view.getId() == R.id.oper2) {
            operator = "*";
            first = Integer.valueOf(textView.getText().toString());
            currentInput.setLength(0);
            textView.setText("");

        } else if (view.getId() == R.id.oper1) {
            operator = "/";
            first = Integer.valueOf(textView.getText().toString());
            currentInput.setLength(0);
            textView.setText("");
        } else if (view.getId() == R.id.oper3) {
            operator = "-";
            first = Integer.valueOf(textView.getText().toString());
            currentInput.setLength(0);
            textView.setText("");
        } else if (view.getId() == R.id.equal) {
            second = Integer.valueOf(textView.getText().toString());
            if (operator != null) {
                Integer result;
                switch (operator) {
                    case "+":
                        result = first + second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        if (second != 0) {
                            result = first / second;
                        } else {
                            result = 0;

                        }
                        break;
                    case "-":
                        result = first - second;
                        break;
                    default:
                        result = 0;
                        break;
                }
                textView.setText(String.valueOf(result));
                Snackbar snackbar = Snackbar.make(view, "Result: " + result, Snackbar.LENGTH_SHORT)
                        .setAction("Go to Second Activity", v -> {
                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(intent);
                        });

                snackbar.setActionTextColor(getResources().getColor(android.R.color.white));

                snackbar.show();

                isOperationOver = true;
                operator = null;
            }
        }


    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        super.startActivity(intent, options);
        finish();
    }
}
