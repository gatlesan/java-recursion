package dp;

public class NinjaThreeTasks {

    public static void main(String[] args) {
        int topTasks = 3;
        int[][] matrix = {{8, 3, 7}, {10, 1, 6}, {3, 4, 6}, {2, 1, 3}};
        System.out.println(maxPoints(matrix.length - 1, 3, matrix, topTasks));
        int[][] memo = new int[matrix.length][4];
        System.out.println(maxPointsMemo(matrix.length - 1, 3, matrix, topTasks, memo));
        int[][] memo1 = new int[matrix.length][4];
        System.out.println(maxPointsTab(matrix, topTasks, memo1));
    }

    private static int maxPoints(int day, int prevTask, int[][] matrix, int tasks) {

        if (day == 0) {
            int max = 0;
            for (int i = 0; i < tasks; i++) {
                if (i != prevTask) {
                    max = Math.max(matrix[day][i], max);
                }
            }
            return max;
        }

        int maxTask = 0;
        for (int i = 0; i < tasks; i++) {
            if (i != prevTask) {
                int task = matrix[day][i] + maxPoints(day - 1, i, matrix, tasks);
                maxTask = Math.max(task, maxTask);
            }
        }
        return maxTask;
    }

    private static int maxPointsMemo(int day, int prevTask, int[][] matrix, int tasks, int[][] memo) {

        if (day == 0) {
            int max = 0;
            for (int i = 0; i < tasks; i++) {
                if (i != prevTask) {
                    max = Math.max(matrix[day][i], max);
                }
            }
            return max;
        }

        if (memo[day][prevTask] > 0)
            return memo[day][prevTask];

        int maxTask = 0;
        for (int i = 0; i < tasks; i++) {
            if (i != prevTask) {
                int task = matrix[day][i] + maxPoints(day - 1, i, matrix, tasks);
                maxTask = Math.max(task, maxTask);
            }
        }
        memo[day][prevTask] = maxTask;
        return maxTask;
    }

    private static int maxPointsTab(int[][] matrix, int tasks, int[][] memo) {

        memo[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        memo[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        memo[0][2] = Math.max(matrix[0][0], matrix[0][1]);

        // bottom up day should start from 1 as we already populated for day 0
        for (int day = 1; day < matrix.length; day++) {

            for (int prevTask = 0; prevTask < tasks; prevTask++) {
                int maxTask = 0;
                for (int i = 0; i < tasks; i++) {
                    if (i != prevTask) {
                        int task = matrix[day][i] + memo[day - 1][i];
                        maxTask = Math.max(task, maxTask);
                    }
                }
                memo[day][prevTask] = maxTask;
            }

        }

        return memo[matrix.length-1][2];

    }

    //todo space optimization using 1d array
}
