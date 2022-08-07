public class test3{
    public static void main(String[] args){
        double[][] sample = new double[100][3];
        double[] high = new double[100];
        double[] low = new double[100];
        double[] point = new double[100];
        double[] p = new double[7];
        double s0 = Double.parseDouble(args[0]);

        for(int i = 0; i < 100; i++){
            sample[i] = RandomTree.calcParameter(s0);
            low[i] = sample[i][0];
            high[i] = sample[i][1];
            point[i] = sample[i][2];
        }
        p[0] = Stat.calcAverage(low);
        p[1] = Stat.calcAverage(high);
        p[2] = Stat.calcAverage(point);
        p[3] = Stat.calcErr(low);
        p[4] = Stat.calcErr(high);
        p[5] = Math.max(p[0] - 1.96 * (p[3] / Math.sqrt(100)), 100 - s0);
        p[6] = p[1] + 1.96 * (p[4] / Math.sqrt(100));
        Printer.arrayPrint(p, "Random.csv");
    }
}