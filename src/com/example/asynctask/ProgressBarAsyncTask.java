package com.example.asynctask;

import android.os.AsyncTask;  
import android.widget.ProgressBar;  
import android.widget.TextView;  
  
/**  
 * ���ɸ���Ķ��󣬲�����execute����֮��  
 * ����ִ�е���onProExecute����  
 * ���ִ��doInBackgroup����  
 *  
 */  
public class ProgressBarAsyncTask extends AsyncTask<Integer, Integer, String> {  
  
    private TextView textView;  
    private ProgressBar progressBar;  
      
      
    public ProgressBarAsyncTask(TextView textView, ProgressBar progressBar) {  
        super();  
        this.textView = textView;  
        this.progressBar = progressBar;  
    }  
  
  
    /**  
     * �����Integer������ӦAsyncTask�еĵ�һ������   
     * �����String����ֵ��ӦAsyncTask�ĵ���������  
     * �÷�������������UI�̵߳��У���Ҫ�����첽�����������ڸ÷����в��ܶ�UI���еĿռ�������ú��޸�  
     * ���ǿ��Ե���publishProgress��������onProgressUpdate��UI���в���  
     */  
    @Override  
    protected String doInBackground(Integer... params) {  
        NetOperator netOperator = new NetOperator();  
        int i = 0;  
        for (i = 10; i <= 100; i+=10) {  
            netOperator.operator();  
            publishProgress(i);  
        }  
        return i + params[0].intValue() + "";  
    }  
  
  
    /**  
     * �����String������ӦAsyncTask�еĵ�����������Ҳ���ǽ���doInBackground�ķ���ֵ��  
     * ��doInBackground����ִ�н���֮�������У�����������UI�̵߳��� ���Զ�UI�ռ��������  
     */  
    @Override  
    protected void onPostExecute(String result) {  
        textView.setText("�첽����ִ�н���" + result);  
    }  
  
  
    //�÷���������UI�̵߳���,����������UI�̵߳��� ���Զ�UI�ռ��������  
    @Override  
    protected void onPreExecute() {  
        textView.setText("��ʼִ���첽�߳�");  
    }  
  
  
    /**  
     * �����Intege������ӦAsyncTask�еĵڶ�������  
     * ��doInBackground�������У���ÿ�ε���publishProgress�������ᴥ��onProgressUpdateִ��  
     * onProgressUpdate����UI�߳���ִ�У����п��Զ�UI�ռ���в���  
     */  
    @Override  
    protected void onProgressUpdate(Integer... values) {  
        int vlaue = values[0];  
        progressBar.setProgress(vlaue);  
    }  
  
}  
