package javacrawling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class movie {
private static BufferedWriter out;

//#content > div.article > div:nth-child(1) > div.lst_wrap > ul > li:nth-child(1) > dl > dd.star > dl.info_star > dd > div > a > span.num
   public static void main(String[] args) {
      // int count = 0;
      // while (count < 30) {
      Document doc = null;
      try {
         out = new BufferedWriter(new FileWriter("movie22.txt", true));
         doc = Jsoup.connect("https://movie.naver.com/movie/running/current.nhn").get();
         Elements lists = doc.select("li > dl");
         int index = 0;
         for (Element list : lists) {
            index += 1;
            String title = list.select("dt.tit a").text();
            Float rate = new Float(list.select("a span.num").text());
            String genre = list.select("dd:nth-child(3) > dl > dd:nth-child(2) > span.link_txt > a:nth-child(n)")
                  .text().replaceAll(" ", "#");
            String director = list.select("dd:nth-child(3) > dl > dd:nth-child(4) > span > a").text();
            String actor = list.select("dd:nth-child(3) > dl > dd:nth-child(6) > span > a:nth-child(n)").text()
                  .replaceAll(" ", "#");
            Object[] movieCurrentList = new Object[6];
            movieCurrentList[0] = index;
            movieCurrentList[1] = title;
            movieCurrentList[2] = rate;
            movieCurrentList[3] = genre;
            movieCurrentList[4] = director;
            movieCurrentList[5] = actor;
            
            
            System.out.println(movieCurrentList[0] + "|" + movieCurrentList[1] + "|" + movieCurrentList[2] + "|" + movieCurrentList[3] + "|" + movieCurrentList[4]+ "|"  + movieCurrentList[5] +"\n");
            out.write(movieCurrentList[0] + "|" + movieCurrentList[1] + "|" + movieCurrentList[2] + "|" + movieCurrentList[3] + "|" + movieCurrentList[4]+ "|"  + movieCurrentList[5] + "\n");
            out.flush();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      // count += 1;
   }
}