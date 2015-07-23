package com.example.asynctask;

import com.example.asynctask.ProgressBarAsyncTask.DataFinishListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;  
import android.widget.Button;  
import android.widget.ProgressBar;  
import android.widget.TextView;  
  
public class MainActivity extends Activity {  
    private Button button;  
    private ProgressBar progressBar;  
    private TextView textView;  
    String result ;
      
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
        
        button = (Button)findViewById(R.id.button03);  
        progressBar = (ProgressBar)findViewById(R.id.progressBar02);  
        textView = (TextView)findViewById(R.id.textView01);  
          
        button.setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) { 
                ProgressBarAsyncTask asyncTask = new ProgressBarAsyncTask(textView, progressBar);  
                asyncTask.setDataFinishListener(new DataFinishListener() {
                    @Override
                    public void dataFinishSuccessfully(Object data) {
                        // TODO Auto-generated method stub
                        result = (String) data;
                        System.out.println("dataFinishSuccessfully : "+result);
                        
                    }
                });
                asyncTask.execute(1000);
            }  
        });  
        
        System.out.println("dataFinishSuccessfully outside: "+result);
        
    }  
}  
