public class MinMax {
    public int max(int [] array) {
        int max = 0;

        for(int i=0; i<array.length; i++ ) {
            if(array[i]>max) {
                max = array[i];
            }
        }
        return max;
    }
    public int min(int [] array) {
        int min = array[0];

        for(int i=0; i<array.length; i++ ) {
            if(array[i]<min) {
                min = array[i];
            }
        }
        return min;
    }
    public static void main(String args[]) {
        int[] myArray = {23, 92, 56, 39, 93};
        MinMax m = new MinMax();
        System.out.println("Maximum value is::"+m.max(myArray));
        System.out.println("Minimum value is::"+m.min(myArray));
    }
}
