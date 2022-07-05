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
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class function
{
   public  int uniqueWords=0;


    public void calculateUniqueWords(String data)
    {
        boolean status;
        data = data.replaceAll("[^A-Za-z0-9]"," ");
        String []words = data.split(" ");
        for(int i=0;i<words.length;i++)
        {
            status = true;
            for(int j=0;j<words.length;j++)
            {
                if(i!=j)
                {
                    if(Objects.equals(words[i], words[j]))
                    {
                        status = false;
                        break;
                    }
                }
            }
            if(status){

                this.uniqueWords++;
            }
        }
    }
}
