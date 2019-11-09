package com.company.shyhhaw;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GetDataZhambri {
    private static String[] zhambri = new String[5];
    private static int i = 0;

    public static void GetDataZhambri() {

        {
            try {
                String URL = "https://github.com/zhamri";
                Document doc = Jsoup.connect(URL).get();
                String title = doc.title();


                for (int x = 2; x < 7; x++) {
                    Elements information = doc.select("#js-pjax-container > div > div.col-lg-9.col-md-8.col-12.float-md-left.pl-md-2 > div.UnderlineNav.width-full.user-profile-nav.js-sticky.top-0 > nav > a:nth-child(" + x + ") > span");
                    String infor = information.toString();
                    zhambri[i] = infor.replace("<span class=\"Counter hide-lg hide-md hide-sm\">", "").replace("</span>", "");
                    i++;
                }
                System.out.println("| Name                            | Number Of Respositories | Number Of Projet | Number Of Star | Number Of Followers | Number Of Following |");
                System.out.println("|---------------------------------|-------------------------|------------------|----------------|---------------------|---------------------|");
                System.out.printf("|%-33s|%-25s|%-18s|%-16s|%-21s|%-21s|\n", title, zhambri[0], zhambri[1], zhambri[2], zhambri[3], zhambri[4]);
                System.out.println("|---------------------------------|-------------------------|------------------|----------------|---------------------|---------------------|");


            } catch (Exception e) {
                System.out.println("" + e);
            }
        }
    }
}
