public class test{
    public static void main(String[] args){
        double r = 0.05;
        double σ = 0.4;
        double Δt = 0.0833;
        double K = 100;
        int times = 12;

        Printer.arrayPrint(EuropeanOption.europeanPutValue(50, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(60, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(70, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(80, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(90, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(100, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(110, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(120, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(130, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(140, r, σ, Δt, K, times, 10));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(150, r, σ, Δt, K, times, 10));

        Printer.arrayPrint(EuropeanOption.europeanPutValue(50, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(60, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(70, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(80, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(90, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(100, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(110, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(120, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(130, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(140, r, σ, Δt, K, times, 100));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(150, r, σ, Δt, K, times, 100));

        Printer.arrayPrint(EuropeanOption.europeanPutValue(50, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(60, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(70, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(80, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(90, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(100, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(110, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(120, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(130, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(140, r, σ, Δt, K, times, 1000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(150, r, σ, Δt, K, times, 1000));

        Printer.arrayPrint(EuropeanOption.europeanPutValue(50, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(60, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(70, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(80, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(90, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(100, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(110, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(120, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(130, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(140, r, σ, Δt, K, times, 10000));
        Printer.arrayPrint(EuropeanOption.europeanPutValue(150, r, σ, Δt, K, times, 10000));

    }
}
