import java.util.Random;

public class ExtraSortingAlgorithms {
    //Bogo Sort
    public static void bogoSort(int[] array) {
        while (!isSorted(array)) {
            shuffle(array);
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
              return false;
            }
        }

        return true;
    }

    public static void shuffle(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--){
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }

    //Stalin sort
    public static void stalinSort(int[] array) {
        int goal = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == goal) {
                array[i] = 0;
                array[goal - 1] = goal;
                goal++;
            }else{
                array[i] = 0;
            }
        }
    }
}
