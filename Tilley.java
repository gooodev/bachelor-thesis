/*
 *Tilley.java
 *Copyright (C) 2016 Sasaki, R.
 *Tilley(1993)�ɂ��A�����J���E�v�b�g�E�I�v�V�����̉��i�Z�o
 */
public class Tilley{
    public static double americanPutValue(double initial, double r, double ��, double ��t, double K, int times, int sample, int bundle){      
        double[][] S = Stock.pathsMaker(initial, r, ��, ��t, times, sample);//����S(k,t)
        double[][] I = new double[sample][times];//�y�C�I�tI(k,t)
        double[][] B = new double[bundle][(sample / bundle)];//�o���h��B(N,P)
        double[][] H = new double[sample][times];//�ۗL���lH(k,t)
        double[][] V = new double[sample][times];//�I�v�V�������iV(k,t)
        int[][] x = new int[sample][times];//�ꎞ�I�Ȓ�`�֐�x(k,t)
        int[][] y = new int[sample][times];//���m�Ȓ�`�֐�y(k,t)
        int[] k = new int[times];//�œK�s�g���Ek(k)
        int[][] z = new int[sample][times];//�ŏI�I�Ȓ�`�֐�z(k,t)

        //���_T�̊������\�[�g����
        sortArray(S, times - 1);
        //���_T�̃I�v�V�����̃y�C�I�tI(k,T)���v�Z����B(�������_�ł́A�I�v�V�������lV(k,T)=I(k,T)�ƂȂ�B)
        for(int i = 0; i < sample; i++){
            I[i][times - 1] = Math.max(K - S[i][times - 1], 0);
            V[i][times - 1] = I[i][times - 1];
        }
        
        for(int t = times - 2; t >= 0; t--){    
            //���_t�̊������\�[�g����
            sortArray(S, t);
            //���_t�̃I�v�V�����̃y�C�I�tI(k,t)���v�Z����B
            for(int i = 0; i < sample; i++){
                I[i][t] = Math.max(K - S[i][t], 0);
            }        
            //�I�v�V�����̃y�C�I�t���A(sample / bundle)�̐����Ƃ�bundle�̑��ɂ܂Ƃ߂�B
            for(int i = 0; i < bundle; i++){
                for(int j = 0; j < (sample / bundle); j++){
                    B[i][j] = I[j + (i * (sample / bundle))][t + 1];
                }
            }
            //(4.6)���A�ۗL���lH(k,t)���v�Z����B
            for(int i = 0; i < sample; i++){
                H[i][t] = Stat.calcAverage(B[i / (sample / bundle)]) * Math.exp(-r * ��t);
            }
            //(4.7)���A��`�֐�x(k,t)���v�Z����B
            for(int i = 0; i< sample; i++){
                if(H[i][t] < I[i][t]) x[i][t] = 1;//�s�g
                else x[i][t] = 0;//�ۗL
            }
            //x(k,t)����A���_t�ł̍œK�s�g���Ek(t)�����肷��B
            for(int i = 0; i < sample - 2; i++){
                if(x[i][t] == 1 && x[i + 1][t] == 1 && x[i + 2][t] == 1){
                    k[t] = i;
                    break;
                }
                else k[t] = t;
            }
            //�œK�s�g���E�����ƂɁA(4.8)��p���čs�g�֐�y(k,t)���v�Z����B
            for(int i = 0; i < sample; i++){
                if(i > k[t]) y[i][t] = 1;
                else y[i][t] = 0;
            }
            //y(k,t)�����ƂɁA(4.9)��p���ăI�v�V�������iV(k,t)���v�Z����B
            for(int i = 0; i < sample; i++){
                if(y[i][t] == 1) V[i][t] = I[i][t];
                else V[i][t] = H[i][t];
            }
        }
        //�ŏI�I�ȍs�g�֐��̌���
        for(int i = 0; i < sample; i++){
            for(int j = (times - 1); j >= 0; j--){
                if(y[i][j] == 1){
                    z[i][j] = 1;
                    break;
                }
                else z[i][j] = 0;
            }
        }
        //�I�v�V�����̌��݉��i���v�Z
        double[][] mult = new double[sample][times];
        double[] sum = new double[sample];
        for(int i = 0; i < sample; i++){
            for(int j = 0; j < times; j++){
                mult[i][j] = z[i][j] * I[i][j] * Math.exp(-r * ��t * j);
            }
            sum[i] = Stat.calcSum(mult[i]);
        }
        return Stat.calcAverage(sum);
    }
    //����S(k,t)�̎��_t�ɂ����č~���Ƀ\�[�g����B
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