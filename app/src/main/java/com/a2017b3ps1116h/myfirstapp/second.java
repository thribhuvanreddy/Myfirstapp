package com.a2017b3ps1116h.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;



public class second extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView t = (TextView) findViewById(R.id.textView3);
        t.setMovementMethod(new ScrollingMovementMethod());
        String f=getIntent().getStringExtra("fileName");
        Read(textView,f);

    }

    String fileName;


    public void create(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Read(TextView textView, String f) {
      textView=findViewById(R.id.textView3);
        try {
            FileInputStream fileInputStream = openFileInput(f);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            textView.setText(stringBuffer.toString());
        } catch (FileNotFoundException k) {
            k.printStackTrace();
        } catch (IOException j) {
            j.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(View view) {

        String fileName = getIntent().getStringExtra("fileName");
        File file = new File(getFilesDir(), fileName);
        boolean k = file.delete();
        if (k == true) {
            Toast.makeText(getApplicationContext(), "Notes deleted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Failed to delete note", Toast.LENGTH_LONG).show();
        }
    }
    LinearLayout viewfile;
    private TextView createNewTextView(String text){
        final Intent intent =new Intent(this,last.class);
        final String temp=text;
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
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

   private void loadFiles(TextView c){
        String y=getFilesDir().toString();
        String d="";
        String t;
        File g=new File(y);
        File file[]=g.listFiles();
        for(File x :file){
            t=x .toString();
            t=t.replace(y+"/","");
            d=d+t+"\n";
        }
        c.setText(d);
            //Log.d(" new file",y.toString());
        }

  /* public void readClick(View view){
        Read(,);
    }

    public void writeClick(View view){
        Write(EditText1.getText().toString(),title.getText().toString());
    }*/


}