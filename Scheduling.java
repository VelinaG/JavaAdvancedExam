import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[] threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        for (int task : tasks) {
            tasksStack.push(task);
        }

        for (int thread : threads) {
            threadsQueue.offer(thread);
        }

        int taskToBeKilled = Integer.parseInt(scanner.nextLine());

        while (tasksStack.peek() != taskToBeKilled){
            if (threadsQueue.poll() >= tasksStack.peek()){
                tasksStack.pop();
            }
        }

        int threadThatKilled = threadsQueue.peek();

        System.out.printf("Thread with value %d killed task %d", threadThatKilled, taskToBeKilled);
        System.out.println();
        for (Integer thread : threadsQueue) {
            System.out.print(thread + " ");
        }


    }
}
