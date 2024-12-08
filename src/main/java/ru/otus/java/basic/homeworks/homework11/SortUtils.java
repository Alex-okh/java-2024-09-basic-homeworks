package ru.otus.java.basic.homeworks.homework11;

/**
 * Методы сортировки массивов
 * bubbleSort - Пузырьковая сортировка
 * quickSort - быстрая сортировка
 */
public class SortUtils {

    /**
     * Пузырьковая сортировка массива
     *
     * @param array Массив int[] для сортировки. сортировка происходит внутри массива.
     */
    public static void bubbleSort(int[] array) {
        int temp;
        boolean changed = true;

        while (changed) {
            changed = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    changed = true;
                }
            }
        }
    }

    /**
     * Быстрая сортировка массива
     *
     * @param arr  массив int[] для сортировки
     * @param low  индекс нижней границы диапазона сортировки
     * @param high индекс верхней границы диапазона сортировки
     *             для сортировки всего массива low = 0 high = arr.length
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = splitArray(arr, low, high);


            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Вспомогательный метод для quickSort. Делит массив на две части - меньше и больше последнего (опорного) элемента.
     *
     * @param arr  сортируемый массив int[]
     * @param low  индекс нижней границы диапазона сортировки
     * @param high индекс верхней границы диапазона сортировки
     * @return Новое значение индекса опорного элемента.
     */
    private static int splitArray(int[] arr, int low, int high) {
        int pivot = arr[high];
        int insertPoint = (low - 1);
        for (int viewPoint = low; viewPoint < high; viewPoint++) {
            if (arr[viewPoint] < pivot) {
                insertPoint++;

                int temp = arr[insertPoint];
                arr[insertPoint] = arr[viewPoint];
                arr[viewPoint] = temp;
            }
        }


        int temp = arr[insertPoint + 1];
        arr[insertPoint + 1] = arr[high];
        arr[high] = temp;


        return insertPoint + 1;
    }

    /**
     * Создает массив случайных значений. Для целей тестирования.
     *
     * @param size размер массива
     * @param min  нижняя граница диапазона значений
     * @param max  верхняя граница диапазона значений
     * @return массив int[] размера size со значениями от min до max
     */
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = min + (int) (Math.random() * (max - min));
        }
        return array;
    }
}



