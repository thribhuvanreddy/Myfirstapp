package com.a2017b3ps1116h.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {
    EditText EditText1;
    EditText title;
    Button button;
    String fileName;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (EditText)findViewById(R.id.title);
        fileName = title.getText().toString();
        EditText1 = (EditText)findViewById(R.id.EditText1);
        /*Button b = (Button)findViewById(R.id.button);
        b.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save(fileName);
            }
        });*/


    }
    /*public void Save(String fileName){
        String str = EditText1.getText().toString();
        try {
           FileOutputStream out = openFileOutput(fileName,MODE_PRIVATE);
            out.write(str.getBytes());
            out.close();
            Toast.makeText(getApplicationContext(),"Text Saved",Toast.LENGTH_SHORT).show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public boolean FileExists(String fName){
        File file = getBaseContext().getFileStreamPath(fName);
        return file.exists();
    }*/

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

    public void Write(String content,String fileName){
        String Mytextmessage =content;
        try{
            FileOutputStream outputStream=openFileOutput(fileName,MODE_PRIVATE);
            outputStream.write(Mytextmessage.getBytes());
            outputStream.close();
            Toast.makeText(getApplicationContext(), "text saved", Toast.LENGTH_LONG).show();
            finish();
        }catch(FileNotFoundException f){
            Toast.makeText(getApplicationContext(),"File not found",Toast.LENGTH_SHORT).show();
            f.printStackTrace();
        }catch(IOException l){
            Toast.makeText(getApplicationContext(),"IO exception",Toast.LENGTH_SHORT).show();
            l.printStackTrace();
        }
    }

   /* public void loadFiles(){
        String y=getFilesDir().toString();
        File g=new File(y);
        File file[]=g.listFiles();
        for(File d :file){
            Log.d(" new file",y.toString());
        }
    }

    public void readClick(View view){
        //Read(EditText1);
    }*/

    public void writeClick(View view){
        Write(EditText1.getText().toString(),title.getText().toString());
    }
}
