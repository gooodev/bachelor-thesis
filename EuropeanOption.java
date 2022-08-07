/*
 *EuropeanOption.java
 *Copyright (C) 2016 Sasaki, R.
 *ヨーロピアン・オプション価格の算出
 */

public class EuropeanOption{
    //ヨーロピアン・プット・オプションの価格を計算
    public static double[] europeanPutValue(double initial, double r, double σ, double Δt, double K, int times, int sample){
        double[] value = new double[2];
        //株価パスを生成
        double[][] stockPaths = Stock.pathsMaker(initial, r, σ, Δt, times, sample);
        double[] put = new double[sample];
        //各パスに対する満期でのペイオフを計算
        for(int i = 0; i < sample; i++){
            put[i] = Math.max(K - stockPaths[i][times - 1], 0);
        }
        //オプション価格を計算
        value[0] = Stat.calcAverage(put) * Math.exp(-r * Δt * times);
        //オプション価格の標準誤差を計算
        value[1] = Stat.calcErr(put);
        return value;
    }
    //ヨーロピアン・プット・オプションの価格を計算
    public static double[] europeanCallValue(double initial, double r, double σ, double Δt, double K, int times, int sample){
        double[] value = new double[2];
        //株価パスを生成
        double[][] stockPaths = Stock.pathsMaker(initial, r, σ, Δt, times, sample);
        double[] call = new double[sample];
        //各パスに対する満期でのペイオフを計算
        for(int i = 0; i < sample; i++){
            call[i] = Math.max(stockPaths[i][times - 1] - K, 0);
        }
        //オプション価格を計算
        value[0] = Stat.calcAverage(call) * Math.exp(-r * Δt * times);
        //オプション価格の標準誤差を計算
        value[1] = Stat.calcErr(call);
        return value;
    }
}