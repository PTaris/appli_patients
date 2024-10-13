package fr.bordeaux.isped.sitis.exam_prog301.domain;

public enum RandomBloodTypeEnum {
    B,A,AB;

    public static String randomBloodTypeEnum(int index){
         return values()[index].name();
         // .name() to return the value of my class as a String thanks to an index
    }

}
