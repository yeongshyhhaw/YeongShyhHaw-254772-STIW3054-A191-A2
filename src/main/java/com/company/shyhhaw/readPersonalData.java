package com.company.shyhhaw;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class readPersonalData implements Runnable {

    private ArrayList<Data> data = new ArrayList<Data>();
    private final String url;
    private String[] Information = new String[6];

    readPersonalData(String url, ArrayList<Data> data) {
        this.url = url;
        this.data = data;
    }

    public void run() {
        try {
            Document doc = Jsoup.connect(url).get();

            for (int x = 2; x < 7; x++) {
                Elements information = doc.select("#js-pjax-container > div > div.col-lg-9.col-md-8.col-12.float-md-left.pl-md-2 > div.UnderlineNav.width-full.user-profile-nav.js-sticky.top-0 > nav > a:nth-child(" + x + ") > span");
                String infro = information.toString();
                Information[x - 2] = infro.replace("<span class=\"Counter hide-lg hide-md hide-sm\">", "").replace("</span>", "");
            }
            Elements information = doc.select("#js-pjax-container > div > div.h-card.col-lg-3.col-md-4.col-12.float-md-left.pr-md-3.pr-xl-6 > div.clearfix.mb-2 > div.float-left.col-9.col-md-12.pl-2.pl-md-0 > div.vcard-names-container.pt-1.pt-md-3.pb-1.pb-md-3.js-sticky.js-user-profile-sticky-fields > h1 > span.p-nickname.vcard-username.d-block");
            String infro = information.toString();
            Information[5] = infro.replace("<span class=\"p-nickname vcard-username d-block\" itemprop=\"additionalName\">", "").replace("</span>", "");
            data.add(new Data(Information[5], Information[0], Information[3], Information[1], Information[4]));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ArrayList<Data> arrayList() {
        return data;
    }
}
