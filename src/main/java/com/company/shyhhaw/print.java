package com.company.shyhhaw;

import java.util.ArrayList;

public class print {
    public  void Print(ArrayList<Data> allPersonalInformation){
        System.out.println("| NO | Login                           | Number Of Respositories | Number Of Followers | Number Of Project | Number Of Following |");
        System.out.println("|----|---------------------------------|-------------------------|---------------------|-------------------|---------------------|");

        for(int x=0;x<allPersonalInformation.size();x++){
        System.out.printf("|%-4s|%-33s|%-25s|%-21s|%-19s|%-21s|\n",x+1,allPersonalInformation.get(x).getLogin(),allPersonalInformation.get(x).getNumRespo(),allPersonalInformation.get(x).getNumFollower(),allPersonalInformation.get(x).getNumProject(),allPersonalInformation.get(x).getNumFollowing());
    }


        System.out.println("|----|---------------------------------|-------------------------|---------------------|-------------------|---------------------|");


}
}
