package org.bootcamp.javaActivity1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class BadCodeStudentRegistration {
    public static void main(String[] args) {
        var s = new BadCodeStudentRegistration();
        s.rs();
    }

    //register students
    public void rs() {
        var sc = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        var n = sc.nextInt();
        sc.nextLine(); // consume newline

        //student list
        var sl = new ArrayList<Map<String, String>>();
        for (int i = 0; i < n; i++) {
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            System.out.println("Enter name: ");
            stringStringHashMap.put("name", sc.nextLine());
            System.out.println("Enter age: ");
            stringStringHashMap.put("age", sc.nextLine());
            System.out.println("Enter grade: ");
            stringStringHashMap.put("grade", sc.nextLine());
            sl.add(stringStringHashMap);
        }

        //write data
        wrs(sl);

        //read data
        var rl = rrs();
        for (var st : rl) {
            if (!np(st)) {
                System.out.println("Student: " + st);
            }
        }
    }

    public boolean np(Map<String, String> st) {
        var g = st.get("grade");
        switch (g) {
            case "A":
                return false;
            case "B":
                return false;
            case "C":
                return true;
            default:
                return true;
        }
    }

    public void wrs(List<Map<String, String>> sl) {
        var sb = new StringBuilder();
        for(int i=0; i<sl.size(); i++){
            var st = sl.get(i);
            sb.append(st.get("name")).append(",").append(st.get("age")).append(",").append(st.get("grade")).append("\n");
        }
        try {
            Files.writeString(Paths.get("students.txt"), sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, String>> rrs() {
        var rl = new ArrayList<Map<String, String>>();
        try {
            var ls = Files.readString(Paths.get("students.txt")).split("\n");
            for (var l : ls) {
                var p = l.split(",");
                var st = new HashMap<String, String>();
                st.put("name", p[0]);
                st.put("age", p[1]);
                st.put("grade", p[2]);
                rl.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rl;
    }
}
