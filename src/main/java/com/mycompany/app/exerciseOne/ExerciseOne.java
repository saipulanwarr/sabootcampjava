package com.mycompany.app.exerciseOne;

import java.util.regex.Pattern;

public class ExerciseOne {
    public void resultReverse(String words){
        System.out.println(getReverseWords(words));
        System.out.println(getReplaceWords(words));
    }

    private String getReverseWords(String str){
        Pattern pattern = Pattern.compile("\\s");
        String[] temp = pattern.split(str);
        String result = "";

        for(int i = 0; i < temp.length; i++){
            if(i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }

        return result;
    }

    private String getReplaceWords(String str){
//        String[][] replacements = {{"kamu", "you"}, {"makanan", "food"}, {"mobil", "car"}};
//
//        String strOutput = str;
//        for(String[] replacement: replacements) {
//            strOutput = strOutput.replace(replacement[0], replacement[1]);
//        }
//
//        return strOutput;

        String reverse = str;

        reverse = reverse.replace("kamu", "you");
        reverse = reverse.replace("makanan", "food");
        reverse = reverse.replace("mobil", "car");
        return reverse;
    }
}
