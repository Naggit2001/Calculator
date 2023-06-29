package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  String  input,output,new_out;

    TextView  textInput,textOutput;
    Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    Button buttonAdd,buttonSub,buttonMulti,buttonDiv,buttonEqual,buttonPoint,buttonPower,buttonPercent,buttonC,buttonDel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

                 //  its  use  for  input  output  text
        textInput =findViewById(R.id.textinput);
        textOutput =findViewById(R.id.output);

        //   number
        button0=findViewById(R.id.btn_0);
        button1=findViewById(R.id.btn_1);
        button2=findViewById(R.id.btn_2);
        button3=findViewById(R.id.btn_3);
        button4=findViewById(R.id.btn_4);
        button5=findViewById(R.id.btn_5);
        button6=findViewById(R.id.btn_6);
        button7=findViewById(R.id.btn_7);
        button8=findViewById(R.id.btn_8);
        button9=findViewById(R.id.btn_9);
         // operation

        buttonAdd=findViewById(R.id.btn_sum);
        buttonSub=findViewById(R.id.btn_sub);
        buttonMulti=findViewById(R.id.btn_mul);
        buttonDiv=findViewById(R.id.btn_di);

        buttonC=findViewById(R.id.btn_c);
        buttonPower=findViewById(R.id.btn_power);
        buttonPercent=findViewById(R.id.btn_persent);
        buttonEqual=findViewById(R.id.btn_equal);
        buttonPoint=findViewById(R.id.btn_point);
        buttonDel=findViewById(R.id.btn_del);



    }

    public  void  onbtnclick(View  view){


        Button button = (Button) view;
        String data = button.getText().toString();


        switch ( data){

            case  "C":
                   input =null;
                   output=null;
                   textOutput.setText("");
                   break;
            case  "Del" :
                   input=null;
                   textOutput.setText("");
                   break;
            case "^":
                solve();
                input +="^" ;

                break;

            case "x":
                solve();
                input +="*";

                break;
            case "=":
                solve();
                break;
            case "%":
                input+="%";
                double d=Double.parseDouble(textInput.getText().toString())/100;
                textOutput.setText(String.valueOf(d));

                break;
            default:if (input==null){
                input="";

            }
            if (data.equals("+")|| data.equals("-")||data.equals("/")){

                solve();
            }

            input +=data;


        }

        textInput.setText(input);

    }

    private void solve() {

          if (input.split("\\+").length==2){
              String numbers []=input.split("\\+");

              try {
                  double d = Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                  output = Double.toString(d);
                   textOutput.setText(output);
                   input=d+"";

              }catch (Exception exception ){
                  textOutput.setError(exception.getMessage().toString());
              }
          }



      else   if (input.split("\\-").length==2){
            String numbers []=input.split("\\-");

            try {
                double d = Double.parseDouble(numbers[0])-Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                textOutput.setText(output);
                input=d+"";

            }catch (Exception exception ){
                textOutput.setError(exception.getMessage().toString());
            }
        }


          else   if (input.split("\\*").length==2){
              String numbers []=input.split("\\*");

              try {
                  double d = Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                  output = Double.toString(d);
                  textOutput.setText(output);
                  input=d+"";

              }catch (Exception exception ){
                  textOutput.setError(exception.getMessage().toString());
              }
          }

          else   if (input.split("\\/").length==2){
              String numbers []=input.split("\\/");

              try {
                  double d = Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                  output = Double.toString(d);
                  new_out = cd(output);
                  textOutput.setText(new_out);
                  input=d+"";

              }catch (Exception exception ){
                  textOutput.setError(exception.getMessage().toString());
              }
          }


          else   if (input.split("\\^").length==2){
              String numbers []=input.split("\\^");

              try {
                  double d = Math.pow(Double.parseDouble(numbers[0]),Double.parseDouble(numbers[1]));
                  output = Double.toString(d);
                  textOutput.setText(output);
                  input=d+"";

              }catch (Exception exception ){
                  textOutput.setError(exception.getMessage().toString());
              }
          }


    }

    private String cd(String numbers){

        String num[] =numbers.split("\\.");
        if(num.length>1){

            if(num[1].equals("0")){
                numbers =num[0];
            }
        }


        return numbers;
    }





}