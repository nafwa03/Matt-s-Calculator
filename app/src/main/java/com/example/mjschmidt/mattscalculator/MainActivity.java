package com.example.mjschmidt.mattscalculator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
    String result = "";
    int lastBtnPress = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView output = (TextView) findViewById(R.id.editText);
        //output.setMovementMethod(new ScrollingMovementMethod());

        output.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(50);
                if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    clipboard.setText(output.getText().toString());
                } else {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("Calculator Output", output.getText().toString());
                    clipboard.setPrimaryClip(clip);
                }
                Context context = getApplicationContext();
                CharSequence text = "Output copied";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context,text, duration).show();
                return true;
            }
        });

        final Button buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                if (output.getText().toString().endsWith("+") || output.getText().toString().endsWith("-") || output.getText().toString().endsWith("×") ||
                        output.getText().toString().endsWith("÷") || output.getText().toString().endsWith(".")) {
                    //do nothing
                } else {
                    output.append(".");
                }

                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });

            }
        });

        final Button buttonZR = (Button) findViewById(R.id.buttonZR);
        buttonZR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("0");
                } else {
                    output.append("0");
                }
                lastBtnPress = 0;

                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("1");
                } else {
                    output.append("1");
                }
                lastBtnPress = 1;

                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }

        });

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("2");
                } else {
                    output.append("2");
                }
                lastBtnPress = 2;

                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("3");
                } else {
                    output.append("3");
                }
                lastBtnPress = 3;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("4");
                } else {
                    output.append("4");
                }
                lastBtnPress = 4;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("5");
                } else {
                    output.append("5");
                }
                lastBtnPress = 5;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("6");
                } else {
                    output.append("6");
                }
                lastBtnPress = 6;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("7");
                } else {
                    output.append("7");
                }
                lastBtnPress = 7;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("8");
                } else {
                    output.append("8");
                }
                lastBtnPress = 8;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                String textDigits = output.getText().toString();
                if (textDigits.equals("0")) {
                    output.setText("9");
                } else {
                    output.append("9");
                }
                lastBtnPress = 9;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });

            }
        });

        final Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                if (output.getText().toString().endsWith("+") || output.getText().toString().endsWith("-") || output.getText().toString().endsWith("×") ||
                        output.getText().toString().endsWith("÷") || output.getText().toString().endsWith(".")) {
                    //do nothing
                } else {
                    output.append("+");
                }
                lastBtnPress = 10;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                if (output.getText().toString().endsWith("+") || output.getText().toString().endsWith("-") || output.getText().toString().endsWith("×") ||
                        output.getText().toString().endsWith("÷") || output.getText().toString().endsWith(".")) {
                    //do nothing
                } else {
                    output.append("-");
                }
                lastBtnPress = 11;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button buttonMult = (Button) findViewById(R.id.buttonMult);
        buttonMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                if (output.getText().toString().endsWith("+") || output.getText().toString().endsWith("-") || output.getText().toString().endsWith("×") ||
                        output.getText().toString().endsWith("÷") || output.getText().toString().endsWith(".")) {
                    //do nothing
                } else {
                    output.append("×");
                }
                lastBtnPress = 12;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                if (output.getText().toString().endsWith("+") || output.getText().toString().endsWith("-") || output.getText().toString().endsWith("×") ||
                        output.getText().toString().endsWith("÷") || output.getText().toString().endsWith(".")) {
                    //do nothing
                } else {
                    output.append("÷");
                }
                lastBtnPress = 13;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });

        final Button buttonDEL = (Button) findViewById(R.id.buttonDEL);
        buttonDEL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (buttonDEL.getText() == "CLR") {
                    buttonDEL.setText("DEL");
                }
                final TextView output = (TextView) findViewById(R.id.editText);
                String text = output.getText().toString();
                if (text.length() == 1 || text.equals(result) && lastBtnPress == 15) {
                    output.setText("0");
                }
                else {
                    output.setText(text.substring(0, text.length() - 1));
                }
                lastBtnPress = 14;
                final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                output.post(new Runnable() {
                    @Override
                    public void run() {
                        hzn.fullScroll(View.FOCUS_RIGHT);
                    }
                });
            }
        });
        buttonDEL.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(50);
                output.setText("0");
                return true;
            }
        });

        final Button buttonEQ = (Button) findViewById(R.id.buttonEQ);
        buttonEQ.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView output = (TextView) findViewById(R.id.editText);
                if (output.getText().toString().endsWith("+") || output.getText().toString().endsWith("-") || output.getText().toString().endsWith("×") ||
                        output.getText().toString().endsWith("÷") || output.getText().toString().endsWith(".")) {
                    //do nothing
                } else {
                    String equation = output.getText().toString();
                    String plus = "+";
                    String minus = "-";
                    String mult = "×";
                    String div = "÷";

                    String[] operands = equation.split("(?=\\×)|(?=\\+)|(?=\\-)|(?=\\÷)|(?<=\\×)|(?<=\\+)|(?<=\\-)|(?<=\\÷)");
                    ArrayList<String> foo = new ArrayList();
                    for (int i = 0; i < operands.length; i++) {
                        foo.add(operands[i]);
                    }

                    while (foo.size() != 1) {
                            for (int k = 0; k < foo.size(); k++) {
                                if (foo.get(k).equals(mult)) {
                                    Double first = Double.parseDouble(foo.get(k - 1));
                                    Double second = Double.parseDouble(foo.get(k + 1));
                                    Double result = first * second;
                                    foo.set(k-1, Double.toString(result));
                                    foo.remove(k);
                                    foo.remove(k);
                                    k = k - 1;
                                } else if (foo.get(k).equals(div)) {
                                    Double first = Double.parseDouble(foo.get(k - 1));
                                    Double second = Double.parseDouble(foo.get(k + 1));
                                    Double result = first / second;
                                    foo.set(k-1, Double.toString(result));
                                    foo.remove(k);
                                    foo.remove(k);
                                    k = k - 1;
                                }

                        }

                            for (int j = 0; j < foo.size(); j++) {
                                if (foo.get(j).equals(plus)) {
                                    Double first = Double.parseDouble(foo.get(j - 1));
                                    Double second = Double.parseDouble(foo.get(j + 1));
                                    Double result = first + second;
                                    foo.set(j - 1, Double.toString(result));
                                    foo.remove(j);
                                    foo.remove(j);
                                    j = j - 1;
                                } else if (foo.get(j).equals(minus)) {
                                    Double first = Double.parseDouble(foo.get(j - 1));
                                    Double second = Double.parseDouble(foo.get(j + 1));
                                    Double result = first - second;
                                    foo.set(j - 1, Double.toString(result));
                                    foo.remove(j);
                                    foo.remove(j);
                                    j = j - 1;
                                }

                        }

                        foo.set(0, fmt(Double.parseDouble(foo.get(0))));
                        output.setText(foo.get(0));
                        result = foo.get(0);
                        lastBtnPress = 15;
                        final Button buttonDEL = (Button) findViewById(R.id.buttonDEL);
                        buttonDEL.setText("CLR");
                        final HorizontalScrollView hzn = (HorizontalScrollView) findViewById(R.id.horizontalScrollView1);
                        output.post(new Runnable() {
                            @Override
                            public void run() {
                                hzn.fullScroll(View.FOCUS_LEFT);
                            }
                        });
                    }
                }

            }
        });

    }

}
