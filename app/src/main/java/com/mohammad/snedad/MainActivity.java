package com.mohammad.snedad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.listview);
        String[] itme =getResources().getStringArray(R.array.index);
        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,R.layout.row_itme,R.id.textitme,itme);
        listView.setAdapter(arrayAdapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent(MainActivity.this,Webhtml.class);
               intent.putExtra("page",position);
               startActivity(intent);


            }
        });

    }

    public void btn_share(View view) {
    String txtshare="حكايات السندباد" ;
    String sharelink="https://play.google.com/store/apps/details?id=com.mohammad.snedad";
    Intent share=new Intent(Intent.ACTION_SEND);
    share.putExtra(Intent.EXTRA_TEXT,txtshare+"\n"+ sharelink);
    startActivity(share);

    }

    public void btn_morapp(View view) {
        Intent moreapp=new Intent(Intent.ACTION_VIEW);
        moreapp.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Qays3DD"));
        startActivity(moreapp);
    }

    public void btn_email(View view) {
        try {
             String txt= "السلام عليكم ورحمة الله وبركاته" ;
             Intent sendemail = new Intent(Intent.ACTION_SEND);
             sendemail.setData(Uri.parse("mailto:"));
             sendemail.setType("message/rfc822");
             sendemail.putExtra(Intent.EXTRA_EMAIL, "albabam9@gmail.com");
             sendemail.putExtra(Intent.EXTRA_SUBJECT,"تطبيق حكايات السندباد");
             sendemail.putExtra(Intent.EXTRA_TEXT,txt);
             startActivity(sendemail);
           }catch (Exception e)
        {
            Toast.makeText(this, "عذرا لا يوجد تطبيق بريد", Toast.LENGTH_LONG).show();
        }
    }

    public void btn_exit(View view) {
        finish();
    }
}

