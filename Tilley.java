/*
 *Tilley.java
 *Copyright (C) 2016 Sasaki, R.
 *Tilley(1993)によるアメリカン・プット・オプションの価格算出
 */
public class Tilley{
    public static double americanPutValue(double initial, double r, double σ, double Δt, double K, int times, int sample, int bundle){      
        double[][] S = Stock.pathsMaker(initial, r, σ, Δt, times, sample);//株価S(k,t)
        double[][] I = new double[sample][times];//ペイオフI(k,t)
        double[][] B = new double[bundle][(sample / bundle)];//バンドルB(N,P)
        double[][] H = new double[sample][times];//保有価値H(k,t)
        double[][] V = new double[sample][times];//オプション価格V(k,t)
        int[][] x = new int[sample][times];//一時的な定義関数x(k,t)
        int[][] y = new int[sample][times];//明確な定義関数y(k,t)
        int[] k = new int[times];//最適行使境界k(k)
        int[][] z = new int[sample][times];//最終的な定義関数z(k,t)

        //時点Tの株価をソートする
        sortArray(S, times - 1);
        //時点TのオプションのペイオフI(k,T)を計算する。(満期時点では、オプション価値V(k,T)=I(k,T)となる。)
        for(int i = 0; i < sample; i++){
            I[i][times - 1] = Math.max(K - S[i][times - 1], 0);
            V[i][times - 1] = I[i][times - 1];
        }
        
        for(int t = times - 2; t >= 0; t--){    
            //時点tの株価をソートする
            sortArray(S, t);
            //時点tのオプションのペイオフI(k,t)を計算する。
            for(int i = 0; i < sample; i++){
                I[i][t] = Math.max(K - S[i][t], 0);
            }        
            //オプションのペイオフを、(sample / bundle)の数ごとにbundle個の束にまとめる。
            for(int i = 0; i < bundle; i++){
                for(int j = 0; j < (sample / bundle); j++){
                    B[i][j] = I[j + (i * (sample / bundle))][t + 1];
                }
            }
            //(4.6)より、保有価値H(k,t)を計算する。
            for(int i = 0; i < sample; i++){
                H[i][t] = Stat.calcAverage(B[i / (sample / bundle)]) * Math.exp(-r * Δt);
            }
            //(4.7)より、定義関数x(k,t)を計算する。
            for(int i = 0; i< sample; i++){
                if(H[i][t] < I[i][t]) x[i][t] = 1;//行使
                else x[i][t] = 0;//保有
            }
            //x(k,t)から、時点tでの最適行使境界k(t)を決定する。
            for(int i = 0; i < sample - 2; i++){
                if(x[i][t] == 1 && x[i + 1][t] == 1 && x[i + 2][t] == 1){
                    k[t] = i;
                    break;
                }
                else k[t] = t;
            }
            //最適行使境界をもとに、(4.8)を用いて行使関数y(k,t)を計算する。
            for(int i = 0; i < sample; i++){
                if(i > k[t]) y[i][t] = 1;
                else y[i][t] = 0;
            }
            //y(k,t)をもとに、(4.9)を用いてオプション価格V(k,t)を計算する。
            for(int i = 0; i < sample; i++){
                if(y[i][t] == 1) V[i][t] = I[i][t];
                else V[i][t] = H[i][t];
            }
        }
        //最終的な行使関数の決定
        for(int i = 0; i < sample; i++){
            for(int j = (times - 1); j >= 0; j--){
                if(y[i][j] == 1){
                    z[i][j] = 1;
                    break;
                }
                else z[i][j] = 0;
            }
        }
        //オプションの現在価格を計算
        double[][] mult = new double[sample][times];
        double[] sum = new double[sample];
        for(int i = 0; i < sample; i++){
            for(int j = 0; j < times; j++){
                mult[i][j] = z[i][j] * I[i][j] * Math.exp(-r * Δt * j);
            }
            sum[i] = Stat.calcSum(mult[i]);
        }
        return Stat.calcAverage(sum);
    }
    //株価S(k,t)の時点tにおいて降順にソートする。
    public static double[][] sortArray(double[][] array, int index){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i + 1; j < array.length; j++){
                if(array[i][index] < array[j][index]){
                    double[] temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }    
}