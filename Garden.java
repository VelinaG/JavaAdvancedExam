import java.util.Arrays;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int gardenRow = values[0];
        int gardenCol = values[1];

        int[][] garden = new int[gardenRow][gardenCol];


        String input = scanner.nextLine();

        while (!input.equals("Bloom Bloom Plow")) {
            values = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int flowerRow = values[0];
            int flowerCol = values[1];

            for (int row = 0; row < garden.length; row++) {
                garden[row][flowerCol] += 1;
            }

            for (int col = 0; col < garden[flowerRow].length; col++) {
                garden[flowerRow][col] += 1;
            }

            garden[flowerRow][flowerCol] -= 1;

            input = scanner.nextLine();
        }







        for (int row = 0; row < garden.length; row++) {
            for (int col = 0; col < garden[row].length; col++) {
                System.out.print(garden[row][col] + " ");
            }
            System.out.println();
        }


    }
}
