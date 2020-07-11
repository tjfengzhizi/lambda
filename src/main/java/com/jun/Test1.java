package com.jun;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author：cj
 * @date：2020-7-10 8:43
 * @desc：
 */
public class Test1 {
    public static void main(String[] args) {
        List<RatePlan> list = Arrays.asList(
                new RatePlan(1,"1","1","大床房1","1","1",60),
                new RatePlan(2,"2","2","大床房2","2","1",70),
                new RatePlan(3,"3","3","大床房3","3","1",80),
                new RatePlan(4,"2","4","大床房4","4","2",90),
                new RatePlan(5,"5","5","大床房5","5","2",100),
                new RatePlan(6,"3","6","大床房6","6","2",110),
                new RatePlan(7,"3","9","大床房7","7","2",120)
                );
        //list转map
        Map<String, RatePlan> map1 = list.stream().collect(Collectors.toMap(k -> k.getRoomId(), ratePlan -> ratePlan));
        map1.forEach((k,v)-> System.out.println("key:"+k+" value:"+v));
        System.out.println("-------------------------------------");
        Map<String,RatePlan> map2 = list.stream().collect(Collectors.toMap(s->s.getId().toString()+s.getPropertyId(),r->r));
        map2.forEach((k,v)-> System.out.println("key:"+k+" value:"+v));
        System.out.println("-------------------------------------");

        //filter的用法
        List<RatePlan> collectList1 = list.stream().filter(ratePlan -> "2".equals(ratePlan.getMerchantOfRecord())).collect(Collectors.toList());
        collectList1.forEach(ratePlan -> System.out.println(ratePlan));
        System.out.println("-------------------------------------");

        //map的用法
        List<String> collectList2 = list.stream().map(ratePlan -> ratePlan.getRoomId()).collect(Collectors.toList());
        List<String> collectList3 = list.stream().map(RatePlan::getRoomId).collect(Collectors.toList());
        List<String> collectList4 = list.stream().map(new Function<RatePlan, String>() {
            @Override
            public String apply(RatePlan ratePlan) {
                return ratePlan.getRoomId();
            }
        }).collect(Collectors.toList());
        System.out.println(collectList2);
        System.out.println(collectList3);
        System.out.println(collectList4);
    }

    public static class RatePlan{
        private Integer id;
        private String propertyId;
        private String roomId;
        private String roomName;
        private String rateId;
        private String merchantOfRecord;
        private Integer score;

        public RatePlan(Integer id, String propertyId, String roomId, String roomName, String rateId, String merchantOfRecord, Integer score) {
            this.id = id;
            this.propertyId = propertyId;
            this.roomId = roomId;
            this.roomName = roomName;
            this.rateId = rateId;
            this.merchantOfRecord = merchantOfRecord;
            this.score = score;
        }

        public Integer getId() {
            return id;
        }

        public String getPropertyId() {
            return propertyId;
        }

        public String getRoomId() {
            return roomId;
        }

        public String getRoomName() {
            return roomName;
        }

        public String getRateId() {
            return rateId;
        }

        public String getMerchantOfRecord() {
            return merchantOfRecord;
        }

        public Integer getScore() {
            return score;
        }

        @Override
        public String toString() {
            return "RatePlan{" +
                    "id=" + id +
                    ", propertyId='" + propertyId + '\'' +
                    ", roomId='" + roomId + '\'' +
                    ", roomName='" + roomName + '\'' +
                    ", rateId='" + rateId + '\'' +
                    ", merchantOfRecord='" + merchantOfRecord + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
