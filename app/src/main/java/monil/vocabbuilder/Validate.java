package monil.vocabbuilder;

/**
 * Created by hello on 03-03-2017.
 */
public class Validate {
    public static void checkAnswer(int option_no)
    {
         if(option_no==5)
    {
        int i;
        for( i=0;i<=4;i++)
        {
            if(Logic.color_containers.get(i).contains(Logic.database_cell))
            {
                Logic.color_containers.get(i).remove(Logic.database_cell);
                Logic.database_cell.color="1";
                Database.changeWordColor(Logic.list_no, Logic.database_cell.word, "1");
                break;
            }
        }
        Logic.color_containers.get(1).add(Logic.database_cell);
    }
     else   if(Data.group_data.equals(Logic.option_container.get(option_no-1)))
        {
            changeColor(true,option_no-1);
        }

        else
        {
            changeColor(false,option_no-1);
        }
    }
    public static void changeColor(boolean is_correct,int no)
    {
        if(is_correct)
        {
            if(Logic.database_cell.color.equals("0")||Logic.database_cell.color.equals("3"))
            {
                Logic.white_container.remove(Logic.database_cell);
                Logic.green_container.add(Logic.database_cell);
                if(Logic.database_cell.color.equals("3")) {
                    Logic.yellow_container.remove(Logic.database_cell);
                    Logic.green_container.add(Logic.database_cell);
                }
                Logic.database_cell.color="4";
                Data.color_data="4";
                /* change in database*/
                Database.changeWordColor(Logic.list_no, Logic.database_cell.word, "4");
            }
            else if(Logic.database_cell.color.equals("1"))
            {
                Logic.grey_container.remove(Logic.database_cell);
                Logic.yellow_container.add(Logic.database_cell);
                Logic.database_cell.color="3";
                Data.color_data="3";
                /* change in database*/
                Database.changeWordColor(Logic.list_no, Logic.database_cell.word, "3");
            }
            else if(Logic.database_cell.color.equals("2"))
            {
                Logic.red_container.remove(Logic.database_cell);
                Logic.yellow_container.add(Logic.database_cell);
                Logic.database_cell.color="3";
                Data.color_data="3";
                /* change in database*/
                Database.changeWordColor(Logic.list_no, Logic.database_cell.word, "3");
            }
        }
        else
        {

            if(Logic.database_cell.color.equals("0")||Logic.database_cell.color.equals("3"))
            {
                Logic.white_container.remove(Logic.database_cell);
                Logic.red_container.add(Logic.database_cell);
                if(Logic.database_cell.color.equals("3"))
                {
                    Logic.yellow_container.remove(Logic.database_cell);
                    Logic.red_container.add(Logic.database_cell);
                }
                Logic.database_cell.color="2";
                Data.color_data="2";
                /* change in database*/
                Database.changeWordColor(Logic.list_no, Logic.database_cell.word, "2");
            }
            else if(Logic.database_cell.color.equals("1"))
            {
                Logic.grey_container.remove(Logic.database_cell);
                Logic.red_container.add(Logic.database_cell);
                Logic.database_cell.color="2";
                Data.color_data="2";
                /* change in database*/
                Database.changeWordColor(Logic.list_no, Logic.database_cell.word, "2");
            }
            else if(Logic.database_cell.color.equals("2"))
            {
                //  DO NOTHING
                        }
        }
        }
    }