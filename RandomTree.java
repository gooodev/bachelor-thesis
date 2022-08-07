/*
 *RandomTree.java
 *Copyright (C) 2016 Sasaki, R.
 *Broadie and Glasserman(1997)によるアメリカン・プット・オプションの価格算出
 */
public class RandomTree{
    //与えられた条件における、ランダム・ツリー法でのlow-estimator, high-estimator, 点推定値の計算結果を返す。
    public static double[] calcParameter(double s0, double r, double σ, double Δt, double K, int times, int branch){
        //ランダムツリーの各ノードでの株価、およびオプションペイオフの計算
        double[] s1 = new double[branch];//時点1における各ノードの株価
        double[][] s2 = new double[branch][branch];//時点2における各ノードの株価
        double[][][] s3 = new double[branch][branch][branch];//満期における各ノードの株価
        double h0 = Math.max(K - s0, 0);//時点0におけるペイオフ
        double[] h1 = new double[branch];//時点2における各ノードのペイオフ
        double[][] h2 = new double[branch][branch];//時点2における各ノードのペイオフ
        double[][][] h3 = new double[branch][branch][branch];//満期における各ノードのペイオフ

        //翌期のパスの発生と、ペイオフの計算
        s1 = Stock.nextBranch(s0, r, σ, Δt, branch);
        h1 = putPayOff(s1, K);
        for(int i = 0; i < branch; i++){
            s2[i] = Stock.nextBranch(s1[i], r, σ, Δt, branch);
            h2[i] = putPayOff(s2[i], K);
        }
        for(int i = 0; i < branch; i++){
            for(int j = 0; j < branch; j++){
                s3[i][j] = Stock.nextBranch(s2[i][j], r, σ, Δt, branch);
                h3[i][j] = putPayOff(s3[i][j], K);
            }
        }

        //(4.12)(4.13)を用いた、high-estimatorの計算
        double high0;
        double[] high1 = new double[branch];
        double[][] high2 = new double[branch][branch];
        double[][][] high3 = new double[branch][branch][branch];
        high3 = h3;
        for(int i = 0; i < branch; i++){
            for(int j = 0; j < branch; j++){
                high2[i][j] = Math.max(h2[i][j], Stat.calcAverage(high3[i][j]) * Math.exp(-r * Δt));
            }
        }
        for(int i = 0; i < branch; i++){
            high1[i] = Math.max(h1[i], Stat.calcAverage(high2[i]) * Math.exp(-r * Δt));
        }
        high0 = Math.max(h0, Stat.calcAverage(high1) * Math.exp(-r * Δt));

        //(4.14)(4.15)(4.16)を用いた、low-estimatorの計算
        double low0;
        double[] low1 = new double[branch];
        double[][] low2 = new double[branch][branch];
        double[][][] low3 = new double[branch][branch][branch];
        double η0;
        double[] η1 = new double[branch];
        double[][] η2 = new double[branch][branch];
        double[][][] η3 = new double[branch][branch][branch];
        low3 = h3;
        for(int i = 0; i < branch; i++){
            for(int j = 0; j < branch; j++){
                for(int k = 0; k < branch; k++){
                    double temp = (1 / (branch - 1)) * (Stat.calcSum(low3[i][j]) - low3[i][j][k]) * Math.exp(-r * Δt);
                    if(h2[i][j] >= temp) η3[i][j][k] = h3[i][j][k];
                    else η3[i][j][k] = low3[i][j][k] * Math.exp(-r * Δt);
                }
            }
        }
        for(int i = 0; i < branch; i++){
            for(int j = 0; j < branch; j++){
                low2[i][j] = Stat.calcAverage(η3[i][j]);
            }
        }
        for(int i = 0; i < branch; i++){
            for(int j = 0; j < branch; j++){
                double temp = (1 / (branch - 1)) * (Stat.calcSum(low2[i]) - low2[i][j]) * Math.exp(-r * Δt);
                if(h1[i] >= temp) η2[i][j] = h2[i][j];
                else η2[i][j] = low2[i][j] * Math.exp(-r * Δt);
            }
        }
        for(int i = 0; i < branch; i++){
            low1[i] = Stat.calcAverage(η2[i]);
        }
        for(int i = 0; i < branch; i++){
            double temp = (1 / (branch - 1)) * (Stat.calcSum(low1) - low1[i]) * Math.exp(-r * Δt);
            if(h0 >= temp) η1[i] = h1[i];
            else η1[i] = low1[i] * Math.exp(-r * Δt);
        }
        low0 = Stat.calcAverage(η1);


        double[] parameter = new double[4];
        parameter[0] = low0;
        parameter[1] = high0;
        //(4.19)を用いた、点推定の計算
        parameter[2] = ((Math.max(h0, low0) + high0) / 2);
        return parameter;
    }

    //与えられた株価の配列すべてに対する、行使価格Kのプットオプションのペイオフを返す。
    public static double[] putPayOff(double[] S, double K){
        double[] payOff = new double[S.length];
        for(int i = 0; i < S.length; i++){
            payOff[i] = Math.max(K - S[i], 0);
        }
        return payOff;
    }
}