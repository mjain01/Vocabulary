package monil.vocabbuilder;

import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by hello on 03-03-2017.
 */
public class Logic {

    static     ArrayList<Database_Cell> white_container = new ArrayList<Database_Cell>();
    static     ArrayList<Database_Cell> red_container = new ArrayList<Database_Cell>();
    static     ArrayList<Database_Cell> grey_container = new ArrayList<Database_Cell>();
    static     ArrayList<Database_Cell> green_container = new ArrayList<Database_Cell>();
    static     ArrayList<Database_Cell> yellow_container = new ArrayList<Database_Cell>();
    static     ArrayList<ArrayList> color_containers = new ArrayList<ArrayList>();
    static     ArrayList<String> option_container = new ArrayList<String>();
    static     Database_Cell database_cell;
    static     int list_no;
    static     int color_container_no;
    static     int container_index;



    public static void firstTime(int list_no_passed)
    {
        list_no=list_no_passed;
        loadingContainers();
        addColorContainers();
        if(green_container.size()==Database.data_count)
        {
            /* DISPLAY SOME MESSAGE AND RESTART*/
            Database.colorToWhite(list_no);
            addColorContainers();
        }
        shuffleContainers();

        run();

    }



    public static void loadingContainers()
    {

        white_container=Database.loadContainer(list_no,"0");
        red_container=Database.loadContainer(list_no,"2");
        grey_container=Database.loadContainer(list_no,"1");
        green_container=Database.loadContainer(list_no,"4");
        yellow_container=Database.loadContainer(list_no,"3");

    }



    public static void shuffle(ArrayList<Database_Cell> container)//check whether pass by reference works or not!
    {
        long seed = System.nanoTime();
        Collections.shuffle(container, new Random(seed));
    }



    public static void shuffle(ArrayList<String> container,String x)//DO NOT REMOVE THIS IT IS FOR OPTION SHUFFLING
    {
        long seed = System.nanoTime();
        Collections.shuffle(container, new Random(seed));
    }



    public static void addColorContainers()
    {
        color_containers.add(white_container);
        color_containers.add(grey_container);
        color_containers.add(red_container);
        color_containers.add(yellow_container);
        color_containers.add(green_container);
    }



    public static void shuffleContainers()
    {
        shuffle(white_container);
        shuffle(grey_container);
        shuffle(red_container);
        shuffle(yellow_container);
        shuffle(green_container);
    }



    public static void run()
    {
        color_container_no=getColorContainerNo();
        container_index=choose(color_containers.get(color_container_no).size());

        ArrayList<Database_Cell>dummy_color_container=color_containers.get(color_container_no);
        Database_Cell dummy_database_cell=dummy_color_container.get(container_index);

        database_cell =dummy_database_cell;
        sendData();
    }



    public static int getColorContainerNo()
    {   int container_number;

        do {
            container_number = choose(4);
        } while (check_container(container_number));//IMP: check whether the container is empty or not

        return container_number;
    }



    public static int choose(int size) {
        double random = (Math.random() * 1000) % size;
        return (int) random;
    }



    public static boolean check_container(int no) {

        if (color_containers.get(no).size() > 0)
            return false;

             else
            return true;
    }



    public static void sendData()
    {   Data.word_data=database_cell.word;

        getOptions();
        Data.option1_data=option_container.get(0);
        Data.option2_data=option_container.get(1);
        Data.option3_data=option_container.get(2);
        Data.option4_data=option_container.get(3);

        Data.marked_data=database_cell.checked;
        Data.color_data=database_cell.color;
        Data.example_data=database_cell.example;
        Data.meaning_data=database_cell.meaning;
        Data.group_data=database_cell.group;
    }



    public static void getOptions()
    {   int i=0;   Database_Cell option_dummy;

        option_container.clear();

        option_container.add(database_cell.group);

         while(i<=2)
         {
            int container_number_option=getColorContainerNo();
            int index_option=choose(color_containers.get(container_number_option).size());
            option_dummy=(Database_Cell)color_containers.get(container_number_option).get(index_option);

            if(!option_container.contains(option_dummy.group))
            {
                 option_container.add(option_dummy.group);
                i++;
            }
        }
        shuffle(option_container,"");
    }



    public static int getColor(String color)
        {

            if(color.equals("0"))
           return Color.parseColor("#fefefe");

       else if(color.equals("1"))
       return Color.parseColor("#d3d3d3");

       else if(color.equals("2"))
       return Color.parseColor("#ff4a4a");

       else if(color.equals("3"))
       return Color.parseColor("#f1fff706");

       return Color.parseColor("#d40aff06");
   }



    public static boolean setMarked()
    {
        if(Data.marked_data=="-1")
           return false;

        else
            return true;
    }

}
