package com.a2017b3ps1116h.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class last extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        //TextView t = (TextView) findViewById(R.id.textView4);
        //t.setMovementMethod(new ScrollingMovementMethod());
        viewfile=(LinearLayout)findViewById(R.id.master);
        copyfile();
    }
    LinearLayout viewfile;
    private TextView createNewTextView(String text){
        final Intent intent =new Intent(this,second.class);
        final String temp=text;
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(80,20,80,20);
        TextView textView=new TextView(this);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        textView.setAlpha((float)0.8);
        textView.setTextColor(Color.parseColor("#83ff00"));
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new TextView.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent.putExtra("fileName",temp);
                startActivity(intent);
            }
        });
        textView.setText(text);
        return textView;

    }
    public void copyfile(){
        viewfile.removeAllViews();
        String path=getFilesDir().toString();
        String temp;
        File fileName=new File(path);
        File file[]=fileName.listFiles();
        for(File x:file){
            temp=x.toString();
            temp=temp.replace(path+"/","");
            viewfile.addView(createNewTextView(temp));
        }
    }

    public void Read(TextView textView,String f){

        try{
            FileInputStream fileInputStream=openFileInput(f);
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer =new StringBuffer();
            String lines;
            while ((lines=bufferedReader.readLine())!=null){
                stringBuffer.append(lines+"\n");
            }
            textView.setText(stringBuffer.toString());
        }catch(FileNotFoundException k){
            k.printStackTrace();
        }catch(IOException j){
            j.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
