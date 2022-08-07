/*
 *Stat.java
 *Copyright (C) 2016 Sasaki, R.
 *各種統計量の算出
 */

import java.util.Random;
import java.util.function.*;

public class Stat{
    //(3.32)より、一様乱数列（サンプル数12）から、標準正規乱数列を生成
    public static double normdistMaker(){
        double[] rnd = new double[12];
        for(int i = 0; i < 12; i++){
            rnd[i] = Math.random();
        }
        return calcSum(rnd) - 6;
    }
    //配列内のサンプル値の総和を算出する。
    public static double calcSum(double[] sample){
        double sum = 0;
        for(double a : sample) sum += a;
        return sum;
    }
    //配列内のサンプル値の平均を算出する。
    public static double calcAverage(double[] sample){
        return calcSum(sample) / sample.length;
    }
    //配列内のサンプル値の標準誤差を算出する。
    public static double calcErr(double[] sample){
        double sd = 0;
        double average = calcAverage(sample);
        for(double a : sample) sd += Math.pow(a - average,2);
        return Math.sqrt((sd / (sample.length - 1)) / sample.length);
    }
}