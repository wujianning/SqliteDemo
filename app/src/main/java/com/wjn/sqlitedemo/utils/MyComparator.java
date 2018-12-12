package com.wjn.sqlitedemo.utils;

import com.wjn.sqlitedemo.bean.Person;

import java.util.Comparator;

public class MyComparator implements Comparator<Person> {

    @Override
    public int compare(Person person, Person t1) {
        int flag = person.getAge().compareTo(t1.getAge());

        /**
         *  return -1 表示放在红黑树的左边,即逆序输出
         *  return 1 表示放在红黑树的右边，即顺序输出
         *  return 0 表示元素相同，仅存放第一个元素
         * */

        if (flag > 0) {
            return 1;
        } else if (flag == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
