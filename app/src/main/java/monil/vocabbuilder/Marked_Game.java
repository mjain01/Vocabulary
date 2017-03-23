package monil.vocabbuilder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Marked_Game extends AppCompatActivity {
    static Button option1_display;
    static Button option2_display;
    static Button option3_display;
    static Button option4_display;
    static Button not_sure_display;
    static Button next;
    static TextView word1_display;
    static TextView word2_display;
    static TextView meaning_display;
    static TextView example_display;
    static TextView group_display;
    Bundle list;
    static String  list_no;
    static CheckBox marked_list;
    @Override



    public void onCreate(Bundle savedInstanceState)
    {
        Intent intent;
        savedInstanceState=null;
        super.onCreate(savedInstanceState);
        Database db=new Database(this);
        setContentView(R.layout.question);
        list=getIntent().getExtras();
        list_no=list.getString("monil.vocabbuilder");

        defineQuestion();
        Logic.firstTime(Integer.parseInt(list_no));
        listenerQuestion();
        setQuestion();
    }



    public void defineQuestion()
    {
        option1_display=(Button)findViewById(R.id.option1_diplay);
        option2_display=(Button)findViewById(R.id.option2_display);
        option3_display=(Button)findViewById(R.id.option3_display);
        option4_display=(Button)findViewById(R.id.option4_display);
        not_sure_display=(Button)findViewById(R.id.not_sure_display);
        word1_display=(TextView)findViewById(R.id.word1_display);
        // word1_display.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }



    public void defineAnswer()
    {
        word2_display=(TextView)findViewById(R.id.word2_display);
        meaning_display=(TextView)findViewById(R.id.meaning_display);
        example_display=(TextView)findViewById(R.id.example_display);
        group_display=(TextView)findViewById(R.id.answer_display);
        next=(Button)findViewById(R.id.next);
        marked_list=(CheckBox)findViewById(R.id.marked_display);
        word2_display.setBackgroundColor(Logic.getColor(Data.color_data));
    }



    public void setAnswer()
    {
        word2_display.setText(Data.word_data);
        meaning_display.setText(Data.meaning_data);
        example_display.setText(Data.example_data);
        group_display.setText(Data.group_data);
        word2_display.setBackgroundColor(Logic.getColor(Data.color_data));
        marked_list.setChecked(Logic.setMarked());
    }



    public void setQuestion()
    {
        option1_display.setText(Data.option1_data);
        option2_display.setText(Data.option2_data);
        option3_display.setText(Data.option3_data);
        option4_display.setText(Data.option4_data);
        not_sure_display.setText("NOT SURE");
        word1_display.setText(Data.word_data);
        word1_display.setBackgroundColor(Logic.getColor(Data.color_data));
    }



    public void answerListener()
    {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.question);
                defineQuestion();
                listenerQuestion();
                setQuestion();
                nextQuestion();
            }
        });

        marked_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Data.marked_data=="-1")
                {
                    Data.marked_data="1";
                    Database.changeMarked(list_no,Data.word_data,"1");
                }
                else
                {
                    Data.marked_data="-1";
                    Database.changeMarked(list_no,Data.word_data,"-1");
                }
            }
        });

    }



    public void listenerQuestion()
    {
        option1_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.answer);
                defineAnswer();
                validate(v, 1);
                setAnswer();
                answerListener();
            }
        });

        option2_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.answer);
                defineAnswer();
                validate(v, 2);
                setAnswer();
                answerListener();
            }
        });

        option3_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.answer);
                defineAnswer();
                validate(v, 3);
                setAnswer();
                answerListener();
            }
        });

        option4_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.answer);
                defineAnswer();
                validate(v, 4);
                setAnswer();
                answerListener();
            }
        });

        not_sure_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.answer);
                defineAnswer();
                validate(v, 5);
                setAnswer();
                answerListener();
            }
        });

    }



    public void nextQuestion()
    {
        Logic.run();
        setQuestion();
    }
    public void validate(View v,int option_no)
    {
        Validate.checkAnswer(option_no);
    }

}
