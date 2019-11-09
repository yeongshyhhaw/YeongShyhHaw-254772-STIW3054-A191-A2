package com.company.shyhhaw;


import org.apache.commons.collections4.Get;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final ArrayList<Data> follower = new ArrayList<Data>();
    private static final ArrayList<Data> personalData = new ArrayList<Data>();


    public static void main(String[] args) throws IOException {
        GetDataZhambri getDataZhambri =new GetDataZhambri();
        getDataZhambri.GetDataZhambri();
        System.out.println();
        System.out.println();
        GetResult gR = new GetResult();
        GetResult2 gR2 = new GetResult2();
        gR.GetData();
        gR2.GetData2();
        follower.addAll(gR.getResult());
        follower.addAll(gR2.getResult2());

        ExecutorService executor = Executors.newFixedThreadPool(follower.size());
        for(int i = 0; i < follower.size(); i++){
            String url = follower.get(i).getURL();
            readPersonalData worker = new readPersonalData(url, personalData);
            executor.execute(worker);
        }
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()){

        }

        print Print = new print();
        Print.Print(personalData);

        Excel excel = new Excel();
        try{
            excel.WriteToExcel(personalData);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void run() {

    }

}
