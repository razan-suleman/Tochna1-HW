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

    private static int findShortestPathRec(int[][] m, int i, int j, HashSet<Integer> notVisited, int indention) {
//		System.out.println("  ".repeat(indention) + "performing " + i + " -> " + j + " on notVisited=" + notVisited);
		if (i == j) {
			return 0;
		} else if (indention > 10){
			return 0;
		}

		int n = m.length;

		ArrayList<Integer> toVisit = new ArrayList<>();
		for (int index = 0; index < n; index++) {
			int i1 = m[i][index];
//			System.out.println("  ".repeat(indention) + " check inx " + index + " got " + i1);
			if (notVisited.contains(index) && i1 == 1) {
				toVisit.add(index);
			}
		}
//		System.out.println("constructed " + toVisit);

		int latgestPossibleValue = (int) Math.pow(n, 2) + 1;
		int min = latgestPossibleValue;
		for (int node : toVisit) {
			HashSet newNotVisited = new HashSet<>(notVisited);
			newNotVisited.remove(node);
			int shortestPath = findShortestPathRec(m, node, j, newNotVisited, indention + 1);
			if (shortestPath != -1) {
				min = Math.min(shortestPath, min);
			}
		}
		if (min == latgestPossibleValue) {
			return -1;
		}

		return min + 1;
	}

	public static int findShortestPath(int[][] m, int i, int j) {
		HashSet<Integer> notVisited = new HashSet<>();
		for (int index = 0; index < m.length; index++) {
			notVisited.add(index);
		}
		return findShortestPathRec(m, i, j, notVisited, 0);
	}


}
