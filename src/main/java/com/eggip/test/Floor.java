//package com.eggip.test;
//
//
//import java.util.List;
//
//public class Floor {
//
//    int static int[] cost = {2, 3, 1, 2};
//
//    int floorNumber = 1;//从零层开始
//    int costNumber = 0;//从第0阶开始
//
//    public List minFloor1(int floor, int cost, List list) {
//        if (floorNumber == floor) {
//            list.add(costNumber);
//            return list;
//        }
//        if (floorNumber != floor && costNumber > cost) {
//            return null;//超过了cost，没有到达顶层
//        }
//        costNumber++;//一阶一阶的消耗
//        list.add(costNumber);
//        if (costNumber > cost) {
//            return minFloor1(++floorNumber, cost, list);
//        } else {
//            return minFloor1(floorNumber, cost, list);
//        }
//    }
//
////    public List minFloor2(int n, List list) {
////        if (i == n) {
////            list.add(i);
////            return list;
////        }
////        return   minFloor1(i+2,list);
////
////    }
////     int k=1;
////    public List minFloor3(int n, List list) {
////        return null;
////
////    }
////
////    public List minFloor14(int n, List list) {
////
////        return null;
////    }
//
//}
