package com.example.algorithm.elementary_1.code08;

import java.util.ArrayList;
import java.util.List;

/*************************************************************************
 ******
 * - Copyright (c) 2023 shangzhao.com
 * - File Name: Test
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2023/4/17   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Test {

    public static void main(String[] args) {
        Employee employee = new Employee(1);
        maxHappy(employee);
    }

    private static int maxHappy(Employee employee) {
        if (employee == null) {
            return 0;
        }
        Info all = process(employee);
        return Math.max(all.yes, all.no);
    }

    private static Info process(Employee employee) {
        if (employee.nexts.isEmpty()) {
            return new Info(employee.happy, 0);
        }
        int yes = employee.happy;
        int no = 0;
        for (Employee next : employee.nexts) {
            Info nextInfo = process(next);
            yes += nextInfo.yes;
            no += Math.max(nextInfo.yes, nextInfo.no);
        }
        return new Info(yes, no);
    }

    public static class Employee {
        public int happy;
        public List<Employee> nexts;

        public Employee(int happy) {
            this.happy = happy;
            this.nexts = new ArrayList<>();
        }
    }

    public static class Info {
        public int yes;
        public int no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }
}
