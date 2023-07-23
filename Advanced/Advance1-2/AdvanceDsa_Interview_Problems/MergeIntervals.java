//package AdvanceDsa_Interview_Problems;
//
//import java.util.ArrayList;
//
//public class MergeIntervals {
//    public static void main(String[] args) {
//        Interval int1 = new Interval(1,3);
//        Interval int2 = new Interval(6,9);
//        Interval newInterval = new Interval(2,5);
//
//        ArrayList<Interval> intervals = new ArrayList<>();
//        intervals.add(int1);
//        intervals.add(int2);
//
//        ArrayList<Interval> output = insert(intervals, newInterval);
//    }
//    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
//        int start = newInterval.start;
//        int end = newInterval.end;
//        ArrayList<Interval> mergedIntervals = new ArrayList<>();
//        Interval tempInterval = new Interval();
//
//        for (int i=0; i<intervals.size(); i++){
//            if(start>intervals.get(i).start && start<intervals.get(i).end){
//                tempInterval.start = intervals.get(i).start;
//                if(end<intervals.get(i).end){
//                    tempInterval.end = intervals.get(i).end;
//                    break;
//                } else if (end>intervals.get(i).end && end<intervals.get(i+1).start) {
//                    tempInterval.end = end;
//                    break;
//                } else if(end>intervals.get(i+1).start && end<intervals.get(i+1).end){
//                    tempInterval.end = intervals.get(i+1).end;
//                    break;
//                }
//            }
//        }
//    }
//}
//
//
////  Definition for an interval.
//   class Interval {
//      int start;
//      int end;
//      Interval() { start = 0; end = 0; }
//      Interval(int s, int e) { start = s; end = e; }
//  }
