/*
 *Stock.java
 *Copyright (C) 2016 Sasaki, R.
 *株価パスの生成
 */

public class Stock{
    //(3.29)より、次期の株価を計算する。
    public static double nextStock(double S, double r, double σ, double Δt){
        double stock = S * Math.exp((r - (Math.pow(σ,2) / 2)) * Δt + σ * Math.sqrt(Δt) * Stat.normdistMaker());
        return stock;
    }
    //株価のパスを生成し、配列で返す。
    public static double[] onePathMaker(double initial, double r, double σ, double Δt, int times){
        double[] stockPath = new double[times];
        stockPath[0] = initial;
        for(int i = 0; i < (times - 1); i++){
            stockPath[i + 1] = nextStock(stockPath[i], r, σ, Δt);
        }
        return stockPath;
    }
    //指定されたサンプル数で株価のパスを生成し、2次元配列で返す。
    public static double[][] pathsMaker(double initial, double r, double σ, double Δt, int times, int sample){
        double[][] stockPath = new double[sample][times];
        for(int i = 0; i < sample; i++){
            double[] onePath = onePathMaker(initial, r, σ, Δt, times);
            for(int j = 0; j < times; j++){
                stockPath[i][j] = onePath[j];
            }
        }
        return stockPath;
    }
    //指定された分岐数での翌期の株価パスを生成し、配列で返す。
    public static double[] nextBranch(double S, double r, double σ, double Δt, int branch){
        double[] s = new double[branch];
        for(int i = 0; i < branch; i++){
            s[i] = nextStock(S, r, σ, Δt);
        }
        return s;
    }
}