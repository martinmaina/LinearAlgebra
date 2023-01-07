
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Martin Maina
 */
public class LinearAlgebra {

    /**
     * Method to get the dot product of any dimension of vectors (2 or 3) of two
     * vectors.
     *
     * @param vectorDimension
     * @param numberOfvectors
     * @param vectors
     * @return
     */
    public static Object dotProduct(int vectorDimension, int numberOfvectors, String[] vectors) {
        int result = 0;
        int vector1[] = getElementsOfAnArray(vectorDimension, vectors[0]);
        int vector2[] = getElementsOfAnArray(vectorDimension, vectors[1]);
        for (int i = 0; i < vectorDimension; i++) {
            result += (vector1[i] * vector2[i]);
        }

        return result;
    }

    /**
     * Method to get the cross product of 3dimension of two vectors
     *
     * @param vectorDimension
     * @param vectors
     * @return
     */
    public static Object crossProduct(int vectorDimension, String[] vectors) {
        String result = "";
        int vector1[] = getElementsOfAnArray(vectorDimension, vectors[0]);
        int vector2[] = getElementsOfAnArray(vectorDimension, vectors[1]);
        result += Arrays.toString(vector1) + " x " + Arrays.toString(vector2) + " = ";
        if (((vector1[0] * vector2[2]) - (vector2[0] * vector1[2])) < 0 && (((vector1[0] * vector2[1]) - (vector2[0] * vector1[1])) < 0)) {
            result += (vector1[1] * vector2[2]) - (vector2[1] * vector1[2]) + "i +" + -1 * ((vector1[0] * vector2[2]) - (vector2[0] * vector1[2])) + "j - " + -1 * ((vector1[0] * vector2[1]) - (vector2[0] * vector1[1])) + "k";
        } else if (((vector1[0] * vector2[2]) - (vector2[0] * vector1[2])) < 0) {
            result += (vector1[1] * vector2[2]) - (vector2[1] * vector1[2]) + "i +" + -1 * ((vector1[0] * vector2[2]) - (vector2[0] * vector1[2])) + "j + " + ((vector1[0] * vector2[1]) - (vector2[0] * vector1[1])) + "k";
        } else {
            result += (vector1[1] * vector2[2]) - (vector2[1] * vector1[2]) + "i -" + ((vector1[0] * vector2[2]) - (vector2[0] * vector1[2])) + "j + " + ((vector1[0] * vector2[1]) - (vector2[0] * vector1[1])) + "k";
        }

        return result;
    }

    /**
     * Let P=(x1,y1,z1) and Q=(x2,y2,z2) be points on a line L, then V =
     * (x2-x1)i+(y2-y1)j +(z2-z1)k is a vector parallel to L, Let R =(x,y,z) be
     * another point on the line, then PR is parallel to PQ which is parallel to
     * V, so PR = tV OR = OP + PR =(x1i+y1j+z1k) + t{(x1-x1)i+(y2-y1)j+(z2-z1)k}
     * x = x1 + t(x2-x1), y = y1 + t(y2-y1), z = z1 + t(z2-z1) are the
     * parametric equations of the Line R.
     *
     * @param dimension
     * @param vectors
     * @return
     */
    public static Object parametricEquationsOfALine(int dimension, String[] vectors) {
        String dimes[] = {"x", "y", "z", "l", "m", "n"};
        String result = "";
        int pointP[] = getElementsOfAnArray(dimension, vectors[0]);
        int pointQ[] = getElementsOfAnArray(dimension, vectors[1]);

        for (int i = 0; i < dimension; i++) {
            if ((pointP[i] - pointQ[i]) == 0) {
                result += "" + dimes[i] + " = " + pointP[i] + ", ";
            } else {
                if ((pointQ[i] - pointP[i]) < 0) {
                    result += "" + dimes[i] + " = " + pointP[i] + " - " + -1 * (pointQ[i] - pointP[i]) + "t, ";
                } else {
                    result += "" + dimes[i] + " = " + pointP[i] + " + " + (pointQ[i] - pointP[i]) + "t, ";
                }
            }
        }
        return result;
    }

    /**
     * The parametric equations of a line are; x = x1 + t(x2-x1), y = y1 +
     * t(y2-y1), z = z1 + t(z2-z1) Let x2-x1=a, y2-y1=b and z2-z1=c, then if abc
     * != 0, then solving for t we obtain (x-x1)/a = (y-y1)/b = (z-z1)/c, (a, b
     * & c) are called the directional numbers of the vector V, (Q-P)
     *
     * @param dimension
     * @param vectors
     * @return
     */
    public static Object symmetricEquationsOfALine(int dimension, String[] vectors) {
        String result = "";
        String dimes[] = {"x", "y", "z", "l", "m", "n"};

        int abc[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int pointP[] = getElementsOfAnArray(dimension, vectors[0]);
        int pointQ[] = getElementsOfAnArray(dimension, vectors[1]);
        for (int i = 0; i < dimension; i++) {
            abc[i] = pointQ[i] - pointP[i];
            if (abc[i] == 0) {
                result += ",  " + dimes[i] + " = " + pointP[i] + ",  ";
            } else {
                if (pointP[i] < 0) {
                    pointP[i] *= -1;
                    result += "= ( " + dimes[i] + " + " + pointP[i] + " ) / " + abc[i] + "  ";
                } else {
                    result += "= ( " + dimes[i] + " - " + pointP[i] + " ) / " + abc[i] + "  ";
                }

            }
        }
        return result;
    }

    public static boolean verifyEquationsAreOnALine(int dimension, String[] vectors) {
        boolean answer = true;

        int result1[] = {0, 0, 0};
        int result2[] = {0, 0, 0};

        String dimes[] = {"x", "y", "z", "l", "m", "n"};
        int abc[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int pointP[] = getElementsOfAnArray(dimension, vectors[0]);
        int pointQ[] = getElementsOfAnArray(dimension, vectors[1]);
        for (int i = 0; i < dimension; i++) {
            abc[i] = pointQ[i] - pointP[i];
            if (abc[i] == 0) {
                System.out.println(dimes[i] + " = " + pointP[i] + " is // to plane " + dimes[dimension - i - 1] + "" + dimes[dimension - i]);
                //Check this a
                return true;
            } else {
                result1[i] = (pointP[i] - pointP[i]) / abc[i];
                result1[i] = (pointQ[i] - pointP[i]) / abc[i];
            }
        }
        for (int i = 0; i < result1.length - 1; i++) {
            if (result1[i] != result1[i + 1] || result2[i] != result2[i + 1]) {
                answer = false;
            }

        }
        return answer;
    }

    public static int[] getElementsOfAnArray(int dimension, String vector) {
        int result[] = {0, 0, 0};
        String elements[] = vector.split(",");
        for (int i = 0; i < vector.split(",").length; i++) {
            result[i] = Integer.parseInt(elements[i]) + 0;
        }

        return result;
    }

    public static int[] getElementsOfAnArray4D(int dimension, String vector) {
        int result[] = {0, 0, 0, 0};
        String elements[] = vector.split(",");
        for (int i = 0; i < vector.split(",").length; i++) {
            result[i] = Integer.parseInt(elements[i]) + 0;
        }

        return result;
    }

    /**
     * A program to calculate the parametric equations of a line and Symmetric
     * equations Also checks if the points given are on the Line (R)
     *
     * @param args
     */
    public static void main(String[] args) {

        String vectorsString[] = {"", ""};
        System.out.println("Enter the point of vector one e.g 1,2,3");
        Scanner scan = new Scanner(System.in);
        String data = scan.next();
        System.out.println("Enter the point of vector two e.g 4,5,6");
        data += "\n" + scan.next();
        vectorsString[0] = data.split("\n")[0];
        vectorsString[1] = data.split("\n")[1];
        String vectors[] = {vectorsString[0], vectorsString[1]};

        Object methods[] = {dotProduct(3, 2, vectors), crossProduct(3, vectors), parametricEquationsOfALine(3, vectors), symmetricEquationsOfALine(3, vectors)};

        System.out.println("Vector 1 entered is (" + vectorsString[0] + ")");
        System.out.println("Vector 2 entered is (" + vectorsString[1] + ")");

        int option;
        String options[] = {"Dot product", "Cross product", "Parametric Equations", "Symmetric Equations"};
        System.out.println("What do you want?");
        for (int i = 0; i < options.length; i++) {
            System.out.println(i+1 + ". " + options[i]);
        }
        option = scan.nextInt();

        System.out.println(options[option-1] + " = " + methods[option - 1]);
        /**
         * System.out.println("Parametric Equations: " +
         * parametricEquationsOfALine(3, vectors));
         * System.out.println("Symmetric Equations: " +
         * symmetricEquationsOfALine(3, vectors)); if
         * (verifyEquationsAreOnALine(3, vectors)) { System.out.println("Point "
         * + Arrays.toString(getElementsOfAnArray(3, vectors[0])) + " and Point
         * " + Arrays.toString(getElementsOfAnArray(3, vectors[1])) + " are on
         * the line"); } else { System.out.println("Point " +
         * Arrays.toString(getElementsOfAnArray(3, vectors[0])) + " and Point "
         * + Arrays.toString(getElementsOfAnArray(3, vectors[1])) + " are not on
         * the line"); }
         *
         */
    }
}

