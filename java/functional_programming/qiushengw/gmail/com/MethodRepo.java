package qiushengw.gmail.com;

public class MethodRepo {
    public static boolean lessthen4(String str){
        return str==null?false:str.length()<4;
    }


    public int bigerthen4(String str){
        return str==null?-1:str.length();
    }
}

