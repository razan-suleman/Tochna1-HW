public class ArrayUtils {
    public static void main(String[] args) {
        int res = findShortestPath(
            new int[][] { {0,0,0}, {0,0,0}, {0,0,0} },
            0, 1
        );
        System.out.println(res);
        int res1 = findShortestPath(
                new int[][] { {0,0,0}, {0,0,0}, {0,0,0} },
                1, 1
            );
        System.out.println(res1);
        int res2 = findShortestPath(
                    new int[][] {{0,1,0,0},{0,0,1,0},{0,0,0,1},{1,0,0,0}},
                    0, 2
                );
        System.out.println(res2);
       
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction){
        int n = array.length;
        if (n == 0) return array;
        move %= n;

        int[] src = array.clone();

        if (direction == 'R' || (move < 0 && direction == 'L')) {
            for (int i = 0; i < n; i++)
                array[(i + move) & n] = src[i];
        }
        else if (direction == 'L' || (move < 0 && direction == 'R')) {
            for (int i = 0; i < n; i++)
                array[i] = src[(i + move) % n];
        }
        return array;
    }

    public static int findShortestPath(int[][] m, int i, int j) {
      
    }

}
