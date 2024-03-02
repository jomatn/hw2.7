package com.example.hw72;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private StringBuilder currentInput;
    private boolean isOperationOver;
    private Integer first, second;
    private String operator;

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
            // Равно
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
                            // Обработка деления на ноль
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
                isOperationOver = true;
                operator = null;
            }
        }
    }

    public void onClearClick(View view) {
    }
}
