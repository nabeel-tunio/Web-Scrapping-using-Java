/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webscrapping;

/**
 *
 * @author Nabeel Nawab
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class task {


    public String[] maxAndMinStory()
    {
        int max=Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        String maxx =" ";
        String minn = "";
        try {
            int i = 1;
            BufferedReader reader = new BufferedReader(new FileReader("Crawler.csv"));

            String data = reader.readLine();
            data = reader.readLine();
            while (data!=null)
            {
                //if(!(data.contains("pakistan") || data.contains("Aas Paas") || data.contains("world") || data.contains("Khel") || data.contains("Fun Fankar") || data.contains("science"))) {
                  //  if (!(Objects.equals(data, "1,2,3,4,5,6"))) {
                        String[] dataArray = data.split(",");
                        for (String value : dataArray) {
                            if (value.length() > max) {
                                max = value.length();
                                maxx = value;
                            }
                            if (value.length() < min) {
                                min = value.length();
                                minn = value;
                            }
                        }
                    //}
                //}
                i++;
                data = reader.readLine();
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return new String[]{minn,maxx};
    }



    //------------------------------------------------------------------------------------------------

    public int calculateUniqueWords()
    {
        function f = new function();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Crawler.csv"));
            String data = reader.readLine();
            while (data!=null)
            {

                //if(!("1,2,3,4,5,6").equals(data)){
                    f.calculateUniqueWords(data);
               // }
                data= reader.readLine();
            }
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return f.uniqueWords;
    }



    //-------------------------------------------------------------------------------------------------

    public int[] calculateStoriesInFile()
    {
        int []stories = new int[6];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Crawler.csv"));
            String data = reader.readLine();
            while (data!=null)
            {
                if(!((Objects.equals(data,"1,2,3,4,5,6")||("pakistan,Aas Paas,world,Khel,Fun Fankar,science").equals(data))))
                {
                    String []dataArray = data.split(",");
                    if(!Objects.equals(dataArray[0], "1"))
                    {
                        stories[0]+=1;
                    }if(!Objects.equals(dataArray[1], "2"))
                {
                    stories[1]+=1;
                }if(!Objects.equals(dataArray[2], "3"))
                {
                    stories[2]+=1;
                }if(!Objects.equals(dataArray[3], "4"))
                {
                    stories[3]+=1;
                }if(!Objects.equals(dataArray[4], "5"))
                {
                    stories[4]+=1;
                }if(!Objects.equals(dataArray[5], "6"))
                {
                    stories[5]+=1;
                }
                }
                data = reader.readLine();
            }

            reader.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return stories;
    }


    //-----------------------------------------------------------------------------------------

    public String [][] countTopFrequency()
    {
        HashMap<String , Integer > hm = new HashMap<>();
        String [][] topWords = new String[10][2];
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Crawler.csv"));
            String currentLine = reader.readLine();
            while(currentLine != null)
            {
                String[] words = currentLine.split(" ");

                for(String word:words)
                {
                    if(hm.containsKey(word))
                    {
                        hm.put(word,hm.get(word)+1);
                    }
                    else{
                        hm.put(word , 1);
                    }
                }
                currentLine = reader.readLine();

            }

            for(int i = 0 ; i < 10 ; i++){
                String repeated = null;
                int count = 0;
                Set<Map.Entry<String,Integer>> entryset = hm.entrySet();
                for(Map.Entry<String , Integer> entry:entryset)
                {
                    if(entry.getValue()>count)
                    {
                        repeated = entry.getKey();
                        count = entry.getValue();

                    }

                }
                topWords[i][0] = repeated;
                topWords[i][1] = String.valueOf(count);
                hm.replace(repeated , 0);
            }

        } catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return topWords;
    }




}
