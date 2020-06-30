package com.main;
import java.util.*;
import static java.lang.Math.sqrt;

public class knn {
    private List<Double> distanceList;
    private HashMap map;
    String name;
    double large;
    //判断是否有测试数据传入
    private void testMap(HashMap map,int dimension){
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            Object val = entry.getValue();
            List<Double> list = (List<Double>) val;
            int size = list.size();
            if(size != dimension){
                map = new HashMap();
            }
        }
        if(this.map.isEmpty()){
            System.out.println("请输入测试样本");
            System.exit(0);
        }
    }
    //用户输入测试样本
    public void getMap(HashMap map){
        this.map = map;
    }
    //距离式
    public double length(double x1,double y1,double x2,double y2) {
        return sqrt((x2-x1)*(x2-x1) + (y2-y1)*(x2-x1));
    }
    public double length(double x1,double y1,double z1,double x2,double y2,double z2){
        return sqrt((x2-x1)*(x2-x1) + (y2-y1)*(x2-x1)+(z2-z1)*(z2-z1));
    }
    public double length(double x1,double y1,double z1,double t1,double x2,double y2,double z2,double t2){
        return sqrt((x2-x1)*(x2-x1) + (y2-y1)*(x2-x1)+(z2-z1)*(z2-z1) + (t2-t1)*(t2-t1));
    }
    //二维运算
    public void getNearList(double x2,double y2){
        HashMap map = this.map;
        List<Double> distanceList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        testMap(map,2);
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry2 = (Map.Entry) iter.next();
            Object val = entry2.getValue();
            Object key = entry2.getKey();
            nameList.add((String)key);
            List<Double> list = (List<Double>) val;
            double x1,y1;
            x1 = list.get(0);
            y1 = list.get(1);
            double dis = length(x1,y1,x2,y2);
            distanceList.add(dis);
        }
        large = Collections.min(distanceList);
        String name = getName(nameList,distanceList);
        this.name = name;
    }
    //三维运算
    public void getNearList(double x2,double y2,double z2){
        HashMap map = this.map;
        List<Double> distanceList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        testMap(map,3);
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object val = entry.getValue();
            Object key = entry.getKey();
            nameList.add((String)key);
            List<Double> list = (List<Double>) val;
            double x1,y1,z1;
            x1 = list.get(0);
            y1 = list.get(1);
            z1 = list.get(2);
            double dis = length(x1,y1,z1,x2,y2,z2);
            distanceList.add(dis);
        }
        large = Collections.min(distanceList);
        String name = getName(nameList,distanceList);
        this.name = name;
    }
    //四维运算
    public void getNearList(double x2,double y2,double z2,double t2){
        HashMap map = this.map;
        List<Double> distanceList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        testMap(map,4);
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry3 = (Map.Entry) iter.next();
            Object value = entry3.getValue();
            Object name = entry3.getKey();
            nameList.add((String)name);
            List<Double> list = (List<Double>) value;
            double x1,y1,z1,t1;
            x1 = list.get(0);
            y1 = list.get(1);
            z1 = list.get(2);
            t1 = list.get(3);
            double dis = length(x1,y1,z1,t1,x2,y2,z2,t2);
            distanceList.add(dis);
        }
        large = Collections.min(distanceList);
        String name = getName(nameList,distanceList);
        this.name = name;
    }
    //根据对应标识删除数据,并赋给Map
    public void rm(String rmKey){
        HashMap map = this.map;
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            if(key.equals(rmKey)){
                iterator.remove();
            }
        }
        this.map = map;
    }
    private String getName(List<String> nameList,List<Double> distanceList){
        ListIterator<Double> it = distanceList.listIterator();
        int time = 0;
        String name = "";
        while (it.hasNext()){
            time++;
            if(it.next() == large){
                name = nameList.get(time-1);
            }
        }
        return name;
    }

    public void trainMap(HashMap map){
        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            Object value = entry.getValue();
            List<Double> list = (List<Double>) value;

        }

    }

}