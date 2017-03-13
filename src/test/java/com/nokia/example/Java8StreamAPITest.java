package com.nokia.example;


import com.nokia.example.Entity.UTEntity;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class Java8StreamAPITest{

    @Test
    public void ComparatorTest(){
        List<UTEntity> utEntityList = createRandomETEntity();
        for (UTEntity utEntity : utEntityList){
            System.out.println("id:"+utEntity.getId()+" type:"+utEntity.getType());
        }
        Collections.sort(utEntityList, new Comparator<UTEntity>() {
            @Override
            public int compare(UTEntity o1, UTEntity o2) {
                System.out.println(" t:"+o1.getId().compareTo(o2.getId()));
                if(o1.getId() < o2.getId()){
                    return -1;
                }else if(o1.getId()> o2.getId()){
                    return 1;
                }else{
                    return 0;
                }
                //return o1.getId().compareTo(o2.getId());
            }
        });
        for (UTEntity utEntity : utEntityList){
            System.out.println("id:"+utEntity.getId()+" type:"+utEntity.getType());
        }
    }

    @Test
    public void StreamTest(){
        List<UTEntity> utEntityList = createRandomETEntity();
        utEntityList.forEach(utEntity -> System.out.print("  id:"+utEntity.getId()+" type:"+utEntity.getType()));
        System.out.println();
        List<UTEntity> utEntityList1 = utEntityList.stream().filter(
                utEntity -> utEntity.getType() == "grocery")
                .sorted(comparing(UTEntity::getId))
                .collect(Collectors.toList());
        utEntityList1.forEach(utEntity -> System.out.print(" id:"+utEntity.getId()+" type:"+utEntity.getType()));
        System.out.println();
    }

    private List<UTEntity> createRandomETEntity(){
        List<UTEntity> utEntityList = new ArrayList<UTEntity>();
        UTEntity utEntity = null;
        String type[] = {"grocery" , "other"};
        int ids[] = {3,2,30,1,5,8,9,6,4,7,20,15,12,19,17,11,10,16,13,14,18,22,25,29,21,23,28,24,26,27};
        System.out.println("isd length:"+ids.length);
        for(int i=0;i<30;i++){
            utEntity = new UTEntity();
            utEntity.setId(ids[i]);
            utEntity.setType(type[(int)(Math.random()*2)]);
            utEntityList.add(utEntity);
        }
        return utEntityList;
    }

    @Test
    public void mapStreamTest(){
        Map<String , String> map = new HashMap<>();
        map.put("a" , "aaa");
        map.put("b" , "bbb");
        map.forEach((id , val) -> {
            System.out.print("key="+id);
            System.out.println("  value="+val);
        });
    }

    @Test
    public void StreamSortedTest(){
        Stream.of(3,2,30,1,5,8,9,6,4,7,20,15,12,19,17,11,10,16,13,14,18,22,25,29,21,23,28,24,26,27)
                .sorted();

    }

    @Test
    public void fileTest(){
        File file =new File("/Users/hao/Downloads");
        File[] ff=file.listFiles(
                f->f.getName().endsWith(".caj"));  for (File ss: ff) {
            System.out.println(ss.getName());  }
    }
}
