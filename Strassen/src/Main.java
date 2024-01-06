import java.sql.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<ArrayList<Double>> solution = new ArrayList<>();
    public ArrayList<ArrayList<ArrayList<Double>>> tempSolution = new ArrayList<>();

    public ArrayList<ArrayList<Double>> basicStrassen(ArrayList<ArrayList<Double>> matrix1, ArrayList<ArrayList<Double>> matrix2){
        ArrayList<ArrayList<Double>> basicSolution = new ArrayList<>();
        double n = (matrix1.get(0).get(0) + matrix1.get(1).get(1)) * (matrix2.get(0).get(0) + matrix2.get(1).get(1));
        double p = (matrix1.get(1).get(0) + matrix1.get(1).get(1)) * matrix2.get(0).get(0);
        double q = matrix1.get(0).get(0) * (matrix2.get(0).get(1) - matrix2.get(1).get(1));
        double r = matrix1.get(1).get(1) * (matrix2.get(1).get(0) - matrix2.get(0).get(0));
        double s = (matrix1.get(0).get(0) + matrix1.get(0).get(1)) * matrix2.get(1).get(1);
        double t = (matrix1.get(1).get(0) - matrix1.get(0).get(0)) * (matrix2.get(0).get(0) + matrix2.get(0).get(1));
        double u = (matrix1.get(0).get(1) - matrix1.get(1).get(1)) * (matrix2.get(1).get(0) + matrix2.get(1).get(1));
        ArrayList<Double> row1 = new ArrayList<>();
        row1.add(n+r-s+u);
        row1.add(q+s);
        basicSolution.add(row1);
        ArrayList<Double> row2 = new ArrayList<>();
        row2.add(p+r);
        row2.add(n-p+q+t);
        basicSolution.add(row2);
        return basicSolution;
    }

    public ArrayList<ArrayList<Double>> modifyMatrix(ArrayList<ArrayList<Double>> matrix, int n){
        for (int i = 0; i < matrix.size() ; i++){
            for (int j = matrix.size(); j < n; j++){
                matrix.get(i).add(0.0);
            }
        }
        for (int i = matrix.size(); i < n; i++){
            ArrayList<Double> zeroList = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                zeroList.add(0.0);
            }
            matrix.add(zeroList);

        }


        return matrix;
    }

    public boolean isPowerOfTwo(int n) {
        // Check if the number is positive and has only one bit set
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public int findNextPowerOfTwo(int n) {
        int result = 1;

        while (result <= n) {
            result *= 2;
        }

        return result;
    }

    public ArrayList<ArrayList<Double>> addMatrices(ArrayList<ArrayList<Double>> matrix1, ArrayList<ArrayList<Double>> matrix2){
        /**
         * Adds matrix1 and matrix2
         */
        if (matrix1.size() != matrix2.size()){
            System.out.println("Matrices of different sizes, so not possible to add");
            ArrayList<ArrayList<Double>> i = new ArrayList<>();
            return i;
        }
        ArrayList<ArrayList<Double>> addedMatrix = new ArrayList<>();

        for (int i = 0; i < matrix1.size(); i++){
            ArrayList<Double> temp = new ArrayList<>();
            for (int j = 0; j < matrix1.size(); j++){

                double t = matrix1.get(i).get(j) + matrix2.get(i).get(j);
                temp.add(t);

            }
            addedMatrix.add(temp);
        }
        return addedMatrix;
    }

    public ArrayList<ArrayList<Double>> subtractMatrices(ArrayList<ArrayList<Double>> matrix1, ArrayList<ArrayList<Double>> matrix2){
        /**
         * Subtracts matrix2 from matrix1
         */
        if (matrix1.size() != matrix2.size()){
            System.out.println("Matrices of different sizes, so not possible to subtract");
            ArrayList<ArrayList<Double>> i = new ArrayList<>();
            return i;
        }
        ArrayList<ArrayList<Double>> subtractMatrix = new ArrayList<>();
        for (int i = 0; i < matrix1.size(); i++){
            ArrayList<Double> temp = new ArrayList<>();
            for (int j = 0; j < matrix1.get(i).size(); j++){

                temp.add(matrix1.get(i).get(j) - matrix2.get(i).get(j));
            }
            subtractMatrix.add(temp);
        }
        return subtractMatrix;
    }

    public ArrayList<ArrayList<Double>> strassen(ArrayList<ArrayList<Double>> matrix1, ArrayList<ArrayList<Double>> matrix2){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (matrix1.size() != matrix2.get(0).size()){
            System.out.println("No solution exists!!!");
            return new ArrayList<ArrayList<Double>>();
        }


        if (matrix1.size() == 2){
            return basicStrassen(matrix1, matrix2);
        }

        else{
            ArrayList<ArrayList<Double>> a = new ArrayList<>();
            for (int i = 0; i < matrix1.size()/2; i++){
                ArrayList<Double> temp = new ArrayList<>();
                for (int j = 0; j < matrix1.size()/2; j++){
                    temp.add(matrix1.get(i).get(j));
                }
                a.add(temp);
            }

            ArrayList<ArrayList<Double>> b = new ArrayList<>();
            for (int i = 0; i < matrix1.size()/2; i++){
                ArrayList<Double> temp = new ArrayList<>();
                for (int j = matrix1.size()/2; j < matrix1.size(); j++){
                    temp.add(matrix1.get(i).get(j));
                }
                b.add(temp);
            }

            ArrayList<ArrayList<Double>> c = new ArrayList<>();
            for (int i = matrix1.size()/2; i < matrix1.size(); i++){
                ArrayList<Double> temp = new ArrayList<>();
                for (int j = 0; j < matrix1.size()/2; j++){
                    temp.add(matrix1.get(i).get(j));
                }
                c.add(temp);
            }

            ArrayList<ArrayList<Double>> d = new ArrayList<>();
            for (int i = matrix1.size()/2; i < matrix1.size(); i++){
                ArrayList<Double> temp = new ArrayList<>();
                for (int j = matrix1.size()/2; j < matrix1.size(); j++){
                    temp.add(matrix1.get(i).get(j));
                }
                d.add(temp);
            }

            // For matrix2
            ArrayList<ArrayList<Double>> e = new ArrayList<>();
            for (int i = 0; i < matrix2.size()/2; i++){
                ArrayList<Double> temp = new ArrayList<>();
                for (int j = 0; j < matrix2.size()/2; j++){
                    temp.add(matrix2.get(i).get(j));
                }
                e.add(temp);
            }

            ArrayList<ArrayList<Double>> f = new ArrayList<>();
            for (int i = 0; i < matrix2.size()/2; i++){
                ArrayList<Double> temp = new ArrayList<>();
                for (int j = matrix2.size()/2; j < matrix2.size(); j++){
                    temp.add(matrix2.get(i).get(j));
                }
                f.add(temp);
            }

            ArrayList<ArrayList<Double>> g = new ArrayList<>();
            for (int i = matrix2.size()/2; i < matrix2.size(); i++){
                ArrayList<Double> temp = new ArrayList<>();
                for (int j = 0; j < matrix2.size()/2; j++){
                    temp.add(matrix2.get(i).get(j));
                }
                g.add(temp);
            }

            ArrayList<ArrayList<Double>> h = new ArrayList<>();
            for (int i = matrix2.size()/2; i < matrix2.size(); i++){
                ArrayList<Double> temp = new ArrayList<>();
                for (int j = matrix2.size()/2; j < matrix2.size(); j++){
                    temp.add(matrix2.get(i).get(j));
                }
                h.add(temp);
            }

            ArrayList<ArrayList<Double>> n = strassen(addMatrices(a, d), addMatrices(e, h));


            ArrayList<ArrayList<Double>> p = strassen(addMatrices(c, d), e);

            ArrayList<ArrayList<Double>> q = strassen(a, subtractMatrices(f, h));

            ArrayList<ArrayList<Double>> r = strassen(d, subtractMatrices(g, e));

            ArrayList<ArrayList<Double>> s = strassen(addMatrices(a, b), h);

            ArrayList<ArrayList<Double>> t = strassen(subtractMatrices(c, a), addMatrices(e, f));

            ArrayList<ArrayList<Double>> u = strassen(subtractMatrices(b, d), addMatrices(g, h));

            ArrayList<ArrayList<Double>> t1 = addMatrices(n, r);
            ArrayList<ArrayList<Double>> t11 = addMatrices(t1, u);
            ArrayList<ArrayList<Double>> i = subtractMatrices(t11, s);

            ArrayList<ArrayList<Double>> j = addMatrices(q, s);
            ArrayList<ArrayList<Double>> k = addMatrices(p, r);

            ArrayList<ArrayList<Double>> t2 = addMatrices(q, t);
            ArrayList<ArrayList<Double>> t21 = addMatrices(t2, n);
            ArrayList<ArrayList<Double>> l = subtractMatrices(t21, p);

            for (int element = 0; element < i.size(); element++){

                ArrayList<Double> temp = i.get(element);
                for (int ele = 0; ele < j.get(element).size(); ele++){
                    temp.add(j.get(element).get(ele));
                }
                solution.add(temp);

            }
            for (int element = 0; element < k.size(); element++){
                ArrayList<Double> temp = k.get(element);
                for (int ele = 0; ele < l.get(element).size(); ele++){
                    temp.add(l.get(element).get(ele));
                }
                solution.add(temp);

            }

            return solution;

        }

    }

    

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the dimension of each matrix (n): ");
    int n = scanner.nextInt();

    ArrayList<ArrayList<Double>> matrix1 = new ArrayList<>();
    ArrayList<ArrayList<Double>> matrix2 = new ArrayList<>();

    System.out.println("Enter the first matrix:");
    for (int i = 0; i < n; i++) {
        ArrayList<Double> row = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            row.add(scanner.nextDouble());
        }
        matrix1.add(row);
    }

    System.out.println("Enter the second matrix:");
    for (int i = 0; i < n; i++) {
        ArrayList<Double> row = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            row.add(scanner.nextDouble());
        }
        matrix2.add(row);
    }

    Main m = new Main();
    if (!m.isPowerOfTwo(n)){
        matrix1 = m.modifyMatrix(matrix1, m.findNextPowerOfTwo(n));
        matrix2 = m.modifyMatrix(matrix2, m.findNextPowerOfTwo(n));
    }

//    System.out.println("Matrix1: " + matrix1);
//    System.out.println("Matrix2: " + matrix2);

    System.out.println("Solution: " + m.strassen(matrix1, matrix2));
}
}