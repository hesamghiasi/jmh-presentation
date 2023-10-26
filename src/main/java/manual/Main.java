package manual;

import static manual.WrongBench.bench;

public class Main {


    static final long RUN_MILLIS = 4000;
    static final int REPEAT = 2;
    static final int WARMUP = 5;
    static final int LOOP = 10_000;

    static double last = 0.0d;


    public static void main(String... args) {
//        bench("nothing", RUN_MILLIS, LOOP, WARMUP, REPEAT, Main::nothing);
//        bench("distance", RUN_MILLIS, LOOP, WARMUP, REPEAT, () -> distance(0.0d, 0.0d, 10.0d, 10.0d));
//        bench("constant", RUN_MILLIS, LOOP, WARMUP, REPEAT, () -> constant(0.0d, 0.0d, 10.0d, 10.0d));


            bench("distance_use_return", RUN_MILLIS, LOOP, WARMUP, REPEAT, () -> last = distance(0.0, 0.0, 10.0, 10.0));
            System.out.println(last);

//        bench("distance", RUN_MILLIS, LOOP, WARMUP, REPEAT, () -> distance(0.0d, 0.0d, 10.0d, 10.0d));
//        bench("constant", RUN_MILLIS, LOOP, WARMUP, REPEAT, () -> constant(0.0d, 0.0d, 10.0d, 10.0d));
//        bench("nothing", RUN_MILLIS, LOOP, WARMUP, REPEAT, Main::nothing);
    }


    static double distance(
            double x1, double y1,
            double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt((dx * dx) +
                (dy * dy));
    }

    static double constant(double x1, double y1, double x2, double y2) {
        return 0.0d;
    }

    static void nothing() {

    }
}
