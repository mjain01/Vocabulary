package monil.vocabbuilder;

/**
 * Created by hello on 03-03-2017.
 */
public class Database_Cell {
     String sr;
     String word;
     String word_id;
     String group;
     String group_id;
     String checked;
     String wrong;
     String right;
     String not_sure;
     String color;
     String example;
     String white_pointer;
     String meaning;
    public Database_Cell(
             String sr,
             String word,
             String word_id,
             String group,
             String group_id,
             String checked,
             String meaning,
             String example,
             String white_pointer,
             String color,
             String wrong,
             String not_sure,
             String right
    )
    {

        this.sr= sr;
        this.word= word;
        this.word_id= word_id;
        this.group= group;
        this.group_id= group_id;
        this.checked= checked;
        this.wrong= wrong;
        this.right= right;
        this.white_pointer=white_pointer;
        this.not_sure= not_sure;
        this.color= color;
        this.example= example;
        this.meaning= meaning;
        
    }


}
