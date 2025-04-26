package javabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
* stream流是java1.8新增的一套api，目的是便于操作集合或者数组数据
* silter,map,sorted->支持自定义构造器，limit，skip
* */
public class StreamOperate {

    public void test1(){
        //使用stream流过滤出数据并且生成新的List
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("赵敏");
        list.add("周芷若");
        list.add("张强");
        list.add("张三丰");
        list.add(null);
        //使用遍历
        List<String> newList = new ArrayList<>();
        for(String temp:list){
            if(!temp.isEmpty()&&temp.contains("张")){
                newList.add(temp);
            }
        }
        //使用stream流
        List<String> newList2 = list.stream()
                .filter(Objects::nonNull)
                .filter(item->item.contains("张"))
                .collect(Collectors.toList());
    }
}
