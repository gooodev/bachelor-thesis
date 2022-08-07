public class test2{
    public static void main(String[] args){
        double initial = 100;
        double r = 0.05;
        double σ = 0.4;
        double Δt = 0.0833;
        double K = 100;
        int times = 12;
        int sample = 1000;
        int bundle = 20;
        Printer.numberPrint(Tilley.americanPutValue(50, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(60, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(70, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(80, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(90, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(100, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(110, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(120, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(130, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(140, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
        Printer.numberPrint(Tilley.americanPutValue(150, r, σ, Δt, K, times, sample, bundle), "Tilley.csv");
    }
}