package com.java.datastructure;

import java.io.File;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalField;

public class DateTest {
    public static void main(String[] args) {
//        Timestamp t1 = Timestamp.valueOf("2018-06-20 08:07:08.111");
//        Timestamp t2 = Timestamp.valueOf("2018-02-23 14:57:26.821");
//    //    System.out.println((t2.getTime() - t1.getTime()) / (1000 * 60));
//        Date date = parseDateTime("2018-06-20 08:07:08+0000");
//
//        System.out.println(date);
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime newTime = now.minusDays(10);
//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime zdt = newTime.atZone(zoneId);
//        Date date = Date.from(zdt.toInstant());
//        System.out.println(date);
        //String conflictPCs = " 1,    2";
//        String conflictPCs = "";
//        List<String> conflictPCList = Arrays.asList(conflictPCs.split(",")).stream().map(String::trim)
//                .filter(e -> !e.trim().isEmpty()).collect(Collectors.toList());
//        System.out.println(conflictPCList);
        
//        List<String> a = new ArrayList<>();
//        a.add("a");
//        a.add("b");
//        a.add("C");
//        a.add("A");
//        List<String> b = new ArrayList<>();
//        b.add("a");
//        b.add("b");
//        b.add("c");
//        System.out.println(a.removeAll(b));
//        System.out.println(a.toString());
        
//        String path = "/asd/1";
//        System.out.println(getNameFromPath(path));
        
//        List<String> originalList = new ArrayList<String>();
//        originalList.add("p2");
//        originalList.add("p3");
//        List<String> finalList = new ArrayList<String>();
//        finalList.add("p2");
//        finalList.add("p3");
//        Map<String, List<String>> pcDependentPCMap = new HashMap<String, List<String>>();
//        List<String> p2List = new ArrayList<String>();
//        p2List.add("p4");
//        pcDependentPCMap.put("p2", p2List);
//        List<String> p4List = new ArrayList<String>();
//        p4List.add("p5");
//        p4List.add("p6");
//        pcDependentPCMap.put("p4", p4List);
//        getAllDependentOnChain(originalList, pcDependentPCMap, finalList);
//        System.out.println(finalList.toString());
        
//        Set<String> s1 = new HashSet<String>();
//        s1.add("p1");
//        List<String> l1 = new ArrayList<String>();
//        l1.add("p1");
//        l1.add("P2");
//        s1.addAll(l1);
//        System.out.println(s1.toString());
        
//        BlockingQueue<Integer> taskRoundQueue = new LinkedBlockingQueue<Integer>();
//        taskRoundQueue.add(1);
//        taskRoundQueue.add(2);
//        taskRoundQueue.add(1);
//        System.out.println(taskRoundQueue);
//        taskRoundQueue.remove(1);
//        System.out.println(taskRoundQueue);
        
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if (item.equals("2")) {
                list.remove(item);
            }
        }
    }
    
    private static void getAllDependentOnChain(List<String> originalList, Map<String, List<String>> pcDependentPCMap,
            List<String> finalList) {
        if (originalList != null) {
            for (String pc : originalList) {
                List<String> dependentList = pcDependentPCMap.get(pc);
                if (dependentList != null) {
                    finalList.addAll(dependentList);
                    getAllDependentOnChain(dependentList, pcDependentPCMap, finalList);
                }
            }
        }
    }
    
    private static String getNameFromPath(String path) {
        int lastIndex = path.lastIndexOf(File.separator);
        if (path != null && path.length() > 0) {
            int length = path.length();
            if (lastIndex > -1 && lastIndex + 1 < length) {
                return path.substring(lastIndex + 1, length);
            }
        }
        return "";
    }

    public static Date parseDateTime(String dateStr) {
        if (dateStr != null && !dateStr.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
           // TimeZone tz = TimeZone.getDefault();
          //  System.out.println(tz);
            //TimeZone tz = TimeZone.getTimeZone("GMT+08:00");
           // dateFormat.setTimeZone(tz);
            try {
                return dateFormat.parse(dateStr);
            } catch (ParseException arg2) {
                return null;
            }
        } else {
            return null;
        }
    }
}
