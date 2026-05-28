package edu.ucr.cs.cs167.lab3;

import java.util.function.Function;

public class App {

    // Part I
    public static void printEvenNumbers(int from, int to) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    public static void printNumbersDivisibleByThree(int from, int to) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }

    // Part II
    static class IsEven implements Function<Integer, Boolean> {
        @Override
        public Boolean apply(Integer x) {
            return x % 2 == 0;
        }
    }

    static class IsDivisibleByThree implements Function<Integer, Boolean> {
        @Override
        public Boolean apply(Integer x) {
            return x % 3 == 0;
        }
    }

    public static void printNumbers(int from, int to, Function<Integer, Boolean> filter) {
        System.out.printf("Printing numbers in the range [%d,%d]\n", from, to);
        for (int i = from; i <= to; i++) {
            if (filter.apply(i)) {
                System.out.println(i);
            }
        }
    }

    // Part V
    @SafeVarargs
    public static Function<Integer, Boolean> combineWithAnd(Function<Integer, Boolean>... filters) {
        return x -> {
            for (Function<Integer, Boolean> f : filters) {
                if (!f.apply(x)) {
                    return false;
                }
            }
            return true;
        };
    }

    @SafeVarargs
    public static Function<Integer, Boolean> combineWithOr(Function<Integer, Boolean>... filters) {
        return x -> {
            for (Function<Integer, Boolean> f : filters) {
                if (f.apply(x)) {
                    return true;
                }
            }
            return false;
        };
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Error: At least three parameters
             expected, from, to, and base.");
            System.exit(1);
        }

        int from = Integer.parseInt(args[0]);
        int to = Integer.parseInt(args[1]);
        String baseStr = args[2];

        // Part I logic (commented out as requested for grading)
        /*
        int base1 = Integer.parseInt(baseStr);
        if (base1 == 2) {
            printEvenNumbers(from, to);
        } else if (base1 == 3) {
            printNumbersDivisibleByThree(from, to);
        }
        */

        // Part II logic (commented out as requested for grading)
        /*
        int base = Integer.parseInt(baseStr);
        Function<Integer, Boolean> filter;
        if (base == 2) {
            filter = new IsEven();
        } else {
            filter = new IsDivisibleByThree();
        }
        printNumbers(from, to, filter);
        */

        // Part III logic (commented out as requested for grading)
        /*
        int base = Integer.parseInt(baseStr);
        Function<Integer, Boolean> divisibleByFive = new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer x) {
                return x % 5 == 0;
            }
        };
        Function<Integer, Boolean> divisibleByTen = x -> x % 10 == 0;
        if (base == 5) {
            printNumbers(from, to, divisibleByFive);
        } else if (base == 10) {
            printNumbers(from, to, divisibleByTen);
        }
        */

        // Part IV logic (commented out as requested for grading)
        /*
        int base = Integer.parseInt(baseStr);
        Function<Integer, Boolean> divisibleByBase = x -> x % base == 0;
        printNumbers(from, to, divisibleByBase);
        */

        // Part V logic
        boolean isAnd = baseStr.contains(",");
        boolean isOr = baseStr.contains("v");

        if (isAnd || isOr) {
            String separator = isAnd ? "," : "v";
            String[] baseParts = baseStr.split(separator);
            
            @SuppressWarnings("unchecked")
            Function<Integer, Boolean>[] filters = new Function[baseParts.length];
            for (int i = 0; i < baseParts.length; i++) {
                int b = Integer.parseInt(baseParts[i]);
                filters[i] = x -> x % b == 0;
            }

            Function<Integer, Boolean> finalFilter;
            if (isAnd) {
                finalFilter = combineWithAnd(filters);
            } else {
                finalFilter = combineWithOr(filters);
            }
            printNumbers(from, to, finalFilter);
        } else {
            // Single base (Part IV, with Part III examples for bases 5 and 10)
            int base = Integer.parseInt(baseStr);
            Function<Integer, Boolean> filter;
            if (base == 5) {
                filter = new Function<Integer, Boolean>() {
                    @Override
                    public Boolean apply(Integer x) {
                        return x % 5 == 0;
                    }
                };
            } else if (base == 10) {
                filter = x -> x % 10 == 0;
            } else {
                filter = x -> x % base == 0;
            }
            printNumbers(from, to, filter);
        }
    }
}
