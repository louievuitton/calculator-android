package com.stevenlouie.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button clearBtn, changeSignBtn, equalsBtn, multiplyBtn, divideBtn, subtractBtn, plusBtn, decimalBtn, btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private TextView calculationsTextView;

    // total and secondValue refers to the numbers of a mathematical operation
    private String total = "0";
    private String secondValue = "";
    private String state = null;
    private int index = 0;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    // initialize UI elements
    private void initViews() {
        calculationsTextView = findViewById(R.id.calculationTextView);
        clearBtn = findViewById(R.id.clearBtn);
        changeSignBtn = findViewById(R.id.changeSignBtn);
        equalsBtn = findViewById(R.id.equalsBtn);
        multiplyBtn = findViewById(R.id.multiplyBtn);
        divideBtn = findViewById(R.id.divideBtn);
        subtractBtn = findViewById(R.id.subtractBtn);
        plusBtn = findViewById(R.id.plusBtn);
        decimalBtn = findViewById(R.id.decimalBtn);
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        clearBtn.setOnClickListener(this);
        changeSignBtn.setOnClickListener(this);
        equalsBtn.setOnClickListener(this);
        multiplyBtn.setOnClickListener(this);
        divideBtn.setOnClickListener(this);
        subtractBtn.setOnClickListener(this);
        plusBtn.setOnClickListener(this);
        decimalBtn.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
    }

    // used to handle click event handler
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clearBtn:
                total = "0";
                secondValue = "";
                calculationsTextView.setText("0");
                multiplyBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                multiplyBtn.setTextColor(getColor(R.color.white));
                divideBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                divideBtn.setTextColor(getColor(R.color.white));
                subtractBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                subtractBtn.setTextColor(getColor(R.color.white));
                plusBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                plusBtn.setTextColor(getColor(R.color.white));
                state = null;
                break;
            case R.id.changeSignBtn:
                if (state == null) {
                    if (!total.equals("0") && !total.equals("0.")) {
                        if (total.charAt(0) != '-') {
                            total = "-" + total;
                        }
                        else {
                            total = total.substring(1);
                        }
                        calculationsTextView.setText(total);
                    }
                }
                else {
                    if (!secondValue.equals("0") && !secondValue.equals("0.")) {
                        if (secondValue.charAt(0) != '-') {
                            secondValue = "-" + secondValue;
                        }
                        else {
                            secondValue = secondValue.substring(1);
                        }
                        calculationsTextView.setText(secondValue);
                    }
                }
                break;
            case R.id.equalsBtn:
                if (!secondValue.equals("")) {
                    handleStateChange();
                }
                multiplyBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                multiplyBtn.setTextColor(getColor(R.color.white));
                divideBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                divideBtn.setTextColor(getColor(R.color.white));
                subtractBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                subtractBtn.setTextColor(getColor(R.color.white));
                plusBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                plusBtn.setTextColor(getColor(R.color.white));
                state = null;
                break;
            case R.id.multiplyBtn:
                changeOperationButtonColor("MULTIPLY");
                if (total.charAt(total.length() - 1) == '.') {
                    total = total.substring(0, total.length() - 1);
                }
                if (!secondValue.equals("")) {
                    handleStateChange();
                }
                state = "MULTIPLY";
                break;
            case R.id.divideBtn:
                changeOperationButtonColor("DIVIDE");
                if (total.charAt(total.length() - 1) == '.') {
                    total = total.substring(0, total.length() - 1);
                }
                if (!secondValue.equals("")) {
                    handleStateChange();
                }
                state = "DIVIDE";
                break;
            case R.id.subtractBtn:
                changeOperationButtonColor("SUBTRACT");
                if (total.charAt(total.length() - 1) == '.') {
                    total = total.substring(0, total.length() - 1);
                }
                if (!secondValue.equals("")) {
                    handleStateChange();
                }
                state = "SUBTRACT";
                break;
            case R.id.plusBtn:
                changeOperationButtonColor("PLUS");
                if (total.charAt(total.length() - 1) == '.') {
                    total = total.substring(0, total.length() - 1);
                }
                if (!secondValue.equals("")) {
                    handleStateChange();
                }
                state = "PLUS";
                break;
            case R.id.btnZero:
                handleNumPressed("0");
                break;
            case R.id.btnOne:
                handleNumPressed("1");
                break;
            case R.id.btnTwo:
                handleNumPressed("2");
                break;
            case R.id.btnThree:
                handleNumPressed("3");
                break;
            case R.id.btnFour:
                handleNumPressed("4");
                break;
            case R.id.btnFive:
                handleNumPressed("5");
                break;
            case R.id.btnSix:
                handleNumPressed("6");
                break;
            case R.id.btnSeven:
                handleNumPressed("7");
                break;
            case R.id.btnEight:
                handleNumPressed("8");
                break;
            case R.id.btnNine:
                handleNumPressed("9");
                break;
            case R.id.decimalBtn:
                handleNumPressed(".");
                break;
            default:
                break;
        }
    }

    // change value when a key is pressed
    private void handleNumPressed(String num) {

        // if state is null the user is still inputting for the first number otherwise we change the value of the second number
        if (state == null) {
            if (num.equals(".")) {
                if (!total.contains(".")) {
                    total = total.concat(num);
                }
            }
            else {
                if (total.equals("0")) {
                    if (!num.equals("0")) {
                        total = num;
                    }
                }
                else {
                    total = total.concat(num);
                }
            }
            calculationsTextView.setText(total);
        }
        else {
            if (num.equals(".")) {
                if (secondValue.equals("")) {
                    secondValue = "0.";
                }
                else {
                    if (!secondValue.contains(".")) {
                        secondValue = secondValue.concat(num);
                    }
                }
            }
            else {
                if (secondValue.equals("0")) {
                    if (!num.equals("0")) {
                        secondValue = num;
                    }
                }
                else {
                    secondValue = secondValue.concat(num);
                }
            }
            calculationsTextView.setText(secondValue);
        }
    }

    private void changeOperationButtonColor(String currentState) {
        if (state == null) {
            if (currentState.equals("MULTIPLY")) {
                multiplyBtn.setBackgroundTintList(getColorStateList(R.color.white));
                multiplyBtn.setTextColor(getColor(R.color.operationBackgroundColor));
            } else if (currentState.equals("DIVIDE")) {
                divideBtn.setBackgroundTintList(getColorStateList(R.color.white));
                divideBtn.setTextColor(getColor(R.color.operationBackgroundColor));
            } else if (currentState.equals("SUBTRACT")) {
                subtractBtn.setBackgroundTintList(getColorStateList(R.color.white));
                subtractBtn.setTextColor(getColor(R.color.operationBackgroundColor));
            } else if (currentState.equals("PLUS")) {
                plusBtn.setBackgroundTintList(getColorStateList(R.color.white));
                plusBtn.setTextColor(getColor(R.color.operationBackgroundColor));
            }
        }
        else {
            if (!state.equals(currentState)) {
                if (state.equals("MULTIPLY")) {
                    multiplyBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                    multiplyBtn.setTextColor(getColor(R.color.white));
                } else if (state.equals("DIVIDE")) {
                    divideBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                    divideBtn.setTextColor(getColor(R.color.white));
                } else if (state.equals("SUBTRACT")) {
                    subtractBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                    subtractBtn.setTextColor(getColor(R.color.white));
                } else if (state.equals("PLUS")) {
                    plusBtn.setBackgroundTintList(getColorStateList(R.color.operationBackgroundColor));
                    plusBtn.setTextColor(getColor(R.color.white));
                }

                if (currentState.equals("MULTIPLY")) {
                    multiplyBtn.setBackgroundTintList(getColorStateList(R.color.white));
                    multiplyBtn.setTextColor(getColor(R.color.operationBackgroundColor));
                } else if (currentState.equals("DIVIDE")) {
                    divideBtn.setBackgroundTintList(getColorStateList(R.color.white));
                    divideBtn.setTextColor(getColor(R.color.operationBackgroundColor));
                } else if (currentState.equals("SUBTRACT")) {
                    subtractBtn.setBackgroundTintList(getColorStateList(R.color.white));
                    subtractBtn.setTextColor(getColor(R.color.operationBackgroundColor));
                } else if (currentState.equals("PLUS")) {
                    plusBtn.setBackgroundTintList(getColorStateList(R.color.white));
                    plusBtn.setTextColor(getColor(R.color.operationBackgroundColor));
                }
            }
        }
    }

    // used to handle the state change of the application which is different operations
    private void handleStateChange() {
        if (secondValue.charAt(secondValue.length() - 1) == '.') {
            secondValue = secondValue.substring(0, secondValue.length() - 1);
        }
        if (state.equals("MULTIPLY")) {
            total = removeZeroDecimal(String.valueOf(Double.valueOf(total) * Double.valueOf(secondValue)));
            calculationsTextView.setText(total);
        }
        else if (state.equals("DIVIDE")) {
            if (!secondValue.equals("0")) {
                total = removeZeroDecimal(String.valueOf(Double.valueOf(total) / Double.valueOf(secondValue)));
                calculationsTextView.setText(total);
            }
            else {
                calculationsTextView.setText("Error");
                total = "0";
                secondValue = "";
                state = null;
            }
        }
        else if (state.equals("SUBTRACT")) {
            total = removeZeroDecimal(String.valueOf(Double.valueOf(total) - Double.valueOf(secondValue)));
            calculationsTextView.setText(total);
        }
        else if (state.equals("PLUS")) {
            total = removeZeroDecimal(String.valueOf(Double.valueOf(total) + Double.valueOf(secondValue)));
            calculationsTextView.setText(total);
        }
        secondValue = "";
    }

    // used to remove any zero decimal from total
    private String removeZeroDecimal(String res) {
        index = res.indexOf(".");
        if (index != -1) {
            for (int i = 0; i < res.substring(index+1).length(); i++) {
                if (res.charAt(index+1+i) != '0') {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                res = res.substring(0, index);
            }
            flag = false;
        }

        return res;
    }
}

