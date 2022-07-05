/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webscrapping;

/**
 *
 * @author Nabeel Nawab
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class Crawler {
    String text = "Story,Label\n";

    public void crawler(String url,String label) throws Exception{
        try{
            Document doc = Jsoup.connect(url).get();
            String html = doc.html();
            parse(html,"qa-heading-link",label);

        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    public void parse(String html, String id,String label) throws Exception{
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        Elements e = body.getElementsByClass(id);
        for(Element x:e){
            text += x.text() +","+label+"\n";
        }
    }
    public void write() throws Exception{
        try {
            FileWriter fw = new FileWriter("Crawler.csv");
            fw.write(text);
            fw.close();
        }catch (Exception e){}
    }
}
