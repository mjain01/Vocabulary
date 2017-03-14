package monil.vocabbuilder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static Button learn;
    static Button play;
    static Button exit;
    static Button list1;
    static Button list2;
    static Button list3;
    static Button list4;
    static Button list5;
    static Button list6;
    static Button list7;
    static Button list8;
    static Button list9;
    static Button list10;
    static Button list11;
    static Button list12;
    static Button list13;
    static Button list14;
    static RelativeLayout list_view;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineObjects();
        intent=new Intent(this,Play_Game.class);
        call();
    }
    public void call() {
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.list);
                listDefineObjects();
                listCall();


            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void listCall()
    {
        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            intent.putExtra("monil.vocabbuilder","1");
                //intent.putExtra("monil.vocabbuilder1","marked");
                startActivity(intent);
            }
        });
        list2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","2");
                startActivity(intent);

            }
        });
        list3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","3");
                startActivity(intent);

            }
        });
        list4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","4");
                startActivity(intent);

            }
        });
        list5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","5");
                startActivity(intent);

            }
        });
        list6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","6");
                startActivity(intent);

            }
        });
        list7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","7");
                startActivity(intent);

            }
        });
        list8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","8");
                startActivity(intent);

            }
        });
        list9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","9");
                startActivity(intent);

            }
        });
        list10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","10");
                startActivity(intent);

            }
        });
        list11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","11");
                startActivity(intent);

            }
        });
        list12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","12");
                startActivity(intent);

            }
        });
        list13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","13");
                startActivity(intent);

            }
        });
        list14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("monil.vocabbuilder","14");
                startActivity(intent);

            }
        });
    }
    public void defineObjects()
    {
        learn=(Button)findViewById(R.id.learn);
        play=(Button)findViewById(R.id.play);
        exit=(Button)findViewById(R.id.exit);

    }
    public void listDefineObjects()
    {
        list1=(Button)findViewById(R.id.list1);
        list2=(Button)findViewById(R.id.list2);
        list3=(Button)findViewById(R.id.list3);
        list4=(Button)findViewById(R.id.list4);
        list5=(Button)findViewById(R.id.list5);
        list6=(Button)findViewById(R.id.list6);
        list7=(Button)findViewById(R.id.list7);
        list8=(Button)findViewById(R.id.list8);
        list9=(Button)findViewById(R.id.list9);
        list10=(Button)findViewById(R.id.list10);
        list11=(Button)findViewById(R.id.list11);
        list12=(Button)findViewById(R.id.list12);
        list13=(Button)findViewById(R.id.list13);
        list14=(Button)findViewById(R.id.list14);

    }

}
