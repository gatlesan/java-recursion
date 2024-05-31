package striver_sheet.greedy_algos;

import java.util.*;

public class NMeetingsInRoom {

    public static void main(String[] args) {

        //*** start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
        //*** start is when the meeting has started and end is when the meeting is ended
        //*** find all possible meetings and return the order of meetings output: 1 2 4 5
        //*** can't use map both HashMap and TreeMap removes duplicates

        List<Integer> start = Arrays.asList(1, 3, 5, 0, 8, 5);
        List<Integer> end =   Arrays.asList(2, 4, 7, 5, 9, 9);
        printMeetingOrder(start, end);


    }

    //*** Intuition --> if end times are sorted we can compare if next meeting s > e to check if that meeting is possible
    // list -> {s, e, order}
    //O(n) + O(nlog(n)) + O(n)
    private static void printMeetingOrder(List<Integer> start, List<Integer> end) {

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < end.size(); i++) {
            Meeting meeting = new Meeting(start.get(i), end.get(i), i + 1);
            meetings.add(meeting);
        }
        //sort based on end time...
        Collections.sort(meetings);
        List<Integer> order = new ArrayList<>();
        int pend = meetings.get(0).order;
        order.add(meetings.get(0).order);
        for(int i=1;i<meetings.size();i++) {
            if(meetings.get(i).start > pend) {
                order.add(meetings.get(i).order);
                pend = meetings.get(i).end;
            }
        }

        System.out.println(order);
    }
}


class Meeting implements Comparable<Meeting> {

    int start;
    int end;
    int order;

    Meeting(int start, int end, int order) {
        this.start = start;
        this.end = end;
        this.order = order;
    }

    @Override
    public int compareTo(Meeting o) {
        if (o.end == this.end)
            return 0;
        else if (o.end < this.end)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "start=" + start +
                ", end=" + end +
                ", order=" + order +
                '}';
    }
}
