package striver_sheet.greedy_algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSequencingProblem {

    public static void main(String[] args) {

        //*** sort the jobs desc order based on profits and do the job with the highest profit on the last day of deadline
        //*** like wise do the same for the rest of the jobs


        List<List<Integer>> jobs = Arrays.asList(Arrays.asList(1, 4, 20), Arrays.asList(2, 1, 10), Arrays.asList(3, 4, 40), Arrays.asList(4, 1, 30));

        List<Job> jobList = new ArrayList<>();
        int maxDeadline = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job job = new Job(jobs.get(i).get(0), jobs.get(i).get(1), jobs.get(i).get(2));
            maxDeadline = maxDeadline > jobs.get(i).get(1) ? maxDeadline : jobs.get(i).get(1);
            jobList.add(job);
        }

        Collections.sort(jobList);
        System.out.println(jobList);
        System.out.println(maxProfit(jobList, maxDeadline));

    }

    //*** assumption jobID > 0
    private static int maxProfit(List<Job> jobList, int maxDeadline) {
        int maxProfit = 0;
        int[] d = new int[maxDeadline + 1];
        List<Integer> jobSeq = new ArrayList<>();
        for (int i = 0; i < jobList.size(); i++) {
            int deadline = jobList.get(i).deadline;
            if (d[deadline] == 0) {
                d[deadline] = jobList.get(i).jobId;
                maxProfit += jobList.get(i).profit;
                jobSeq.add(jobList.get(i).jobId);
            } else if (deadline > 1) {
                while (d[deadline] != 0) {
                    deadline--;
                }
                d[deadline] = jobList.get(i).jobId;
                maxProfit += jobList.get(i).profit;
                jobSeq.add(jobList.get(i).jobId);
            }
        }
        System.out.println(jobSeq);
        return maxProfit;
    }
}


class Job implements Comparable<Job> {
    int jobId;
    int profit;
    int deadline;

    Job(int jobId, int deadline, int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public int compareTo(Job job) {
        if (job.profit == this.profit) {
            return 0;
        } else if (job.profit < this.profit) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", profit=" + profit +
                ", deadline=" + deadline +
                '}';
    }
}