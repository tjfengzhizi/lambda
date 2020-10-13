package com.jun;

import java.util.Arrays;
import java.util.List;

/**
 * findAny用法
 */
public class Test3 {
    public static void main(String args[]){
        List<RatePlan> list = Arrays.asList(
                new RatePlan(1,"1","1","大床房1","1","1",60),
                new RatePlan(2,"2","2","大床房2","2","1",70),
                new RatePlan(3,"3","3","大床房3","3","1",80),
                new RatePlan(4,"2","4","大床房4","4","2",90),
                new RatePlan(5,"5","5","大床房5","5","2",100),
                new RatePlan(3,"3","6","大床房6","6","2",110),
                new RatePlan(7,"3","9","大床房7","7","2",120)
        );
        boolean present = list.stream().filter(ratePlan -> ratePlan.getId() == 59).findAny().isPresent();
        System.out.println(present);
        boolean present1 = list.stream().filter(ratePlan -> ratePlan.getId() == 2).findFirst().isPresent();
        System.out.println(present1);
        System.out.println("===============");
        //不一定返回哪个
        RatePlan ratePlan1 = list.stream().filter(ratePlan -> ratePlan.getId() == 3).parallel().findAny().get();
        System.out.println(ratePlan1);
        //返回第一个
        RatePlan ratePlan2 = list.stream().filter(ratePlan -> ratePlan.getId() == 3).findFirst().get();
        System.out.println(ratePlan2);

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

        public void setId(Integer id) {
            this.id = id;
        }

        public void setPropertyId(String propertyId) {
            this.propertyId = propertyId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public void setRateId(String rateId) {
            this.rateId = rateId;
        }

        public void setMerchantOfRecord(String merchantOfRecord) {
            this.merchantOfRecord = merchantOfRecord;
        }

        public void setScore(Integer score) {
            this.score = score;
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
