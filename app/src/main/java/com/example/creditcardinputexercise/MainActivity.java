package com.example.creditcardinputexercise;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button submit;
    private EditText accountNumber, cvv, date, firstName, lastName;
    private TextView securityCode, card, invalidCvv, invalidNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountNumber = findViewById(R.id.textView);
        date = findViewById(R.id.textView2);
        cvv = findViewById(R.id.textView3);
        submit = findViewById(R.id.button);
        securityCode = findViewById(R.id.textView8);
        card = findViewById(R.id.textView6);
        invalidCvv = findViewById(R.id.textView11);
        invalidCvv.setVisibility(View.GONE);
        invalidNumber=findViewById(R.id.textView12);
        invalidNumber.setVisibility(View.GONE);
        firstName = findViewById(R.id.textView4);
        lastName = findViewById(R.id.textView5);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAccountNumber();
            }
        });
    }


    private void checkAccountNumber() {
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        String number = accountNumber.getText().toString();
        int cvvLength = cvv.length();
        if (fName.isEmpty() || lName.isEmpty() || cvvLength == 0 || number.isEmpty()) {
            Toast.makeText(this, "Incomplete Details", Toast.LENGTH_LONG).show();
        } else {
            int a = Integer.parseInt(String.valueOf(number.charAt(0)));
            int size = number.length();
            if (a == 3 && size == 15) {
                if (cvvLength == 4) {
                    if (checkLuhn(number)) {
                        openDialog();
                    } else {
                        accountNumber.setBackground(getDrawable(R.drawable.curve2));
                        invalidNumber.setVisibility(View.VISIBLE);
                        card.setTextColor(this.getResources().getColor(R.color.colorText));
                    }
                } else {
                    securityCode.setTextColor(this.getResources().getColor(R.color.colorText));
                    cvv.setBackground(getDrawable(R.drawable.curve2));
                    invalidCvv.setVisibility(View.VISIBLE);
                }
            } else if (a == 4 && size == 13 || size == 16 || size == 19) {
                if (cvvLength == 3) {
                    if (checkLuhn(number)) {
                        openDialog();
                    } else {
                        accountNumber.setBackground(getDrawable(R.drawable.curve2));
                        card.setTextColor(this.getResources().getColor(R.color.colorText));
                        invalidNumber.setVisibility(View.VISIBLE);
                    }

                } else {
                    securityCode.setTextColor(this.getResources().getColor(R.color.colorText));
                    cvv.setBackground(getDrawable(R.drawable.curve2));
                    invalidCvv.setVisibility(View.VISIBLE);
                }
            } else if (a == 5 && size == 16) {
                if (cvvLength == 3) {
                    if (checkLuhn(number)) {
                        openDialog();
                    } else {
                        accountNumber.setBackground(getDrawable(R.drawable.curve2));
                        card.setTextColor(this.getResources().getColor(R.color.colorText));
                        invalidNumber.setVisibility(View.VISIBLE);
                    }

                } else {
                    securityCode.setTextColor(this.getResources().getColor(R.color.colorText));
                    cvv.setBackground(getDrawable(R.drawable.curve2));
                    invalidCvv.setVisibility(View.VISIBLE);
                }
            } else if (a == 6 && size == 16 || size == 19) {
                if (cvvLength == 3) {
                    if (checkLuhn(number)) {
                        openDialog();
                    } else {
                        accountNumber.setBackground(getDrawable(R.drawable.curve2));
                        card.setTextColor(this.getResources().getColor(R.color.colorText));
                        invalidNumber.setVisibility(View.VISIBLE);
                    }

                } else {
                    securityCode.setTextColor(this.getResources().getColor(R.color.colorText));
                    cvv.setBackground(getDrawable(R.drawable.curve2));
                    invalidCvv.setVisibility(View.VISIBLE);
                }
            } else {
                Toast.makeText(this, "Invalid Card Number", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean checkLuhn(String cardNo) {
        int nDigits = cardNo.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {

            int d = cardNo.charAt(i) - '0';

            if (isSecond == true)
                d = d * 2;
            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

    private void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }
}