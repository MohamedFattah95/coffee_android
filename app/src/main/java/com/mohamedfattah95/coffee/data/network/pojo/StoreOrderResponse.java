package com.mohamedfattah95.coffee.data.network.pojo;

import com.google.gson.annotations.SerializedName;

public class StoreOrderResponse {

    /**
     * code : 200
     * Status : success
     * data : {"user_id":"1","product_id":"1","brunche_id":"1","addition":"1,6","subadd":"2,7","count":"5","totlePrice":null,"status":0,"created_at":"2020-08-19 04:47:07","updated_at":"2020-08-19 01:47:07","id":330}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("Status")
    private String Status;
    @SerializedName("data")
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * user_id : 1
         * product_id : 1
         * brunche_id : 1
         * addition : 1,6
         * subadd : 2,7
         * count : 5
         * totlePrice : null
         * status : 0
         * created_at : 2020-08-19 04:47:07
         * updated_at : 2020-08-19 01:47:07
         * id : 330
         */

        @SerializedName("user_id")
        private String userId;
        @SerializedName("product_id")
        private String productId;
        @SerializedName("brunche_id")
        private String bruncheId;
        @SerializedName("addition")
        private String addition;
        @SerializedName("subadd")
        private String subadd;
        @SerializedName("count")
        private String count;
        @SerializedName("totlePrice")
        private Object totlePrice;
        @SerializedName("status")
        private int status;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("id")
        private int id;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getBruncheId() {
            return bruncheId;
        }

        public void setBruncheId(String bruncheId) {
            this.bruncheId = bruncheId;
        }

        public String getAddition() {
            return addition;
        }

        public void setAddition(String addition) {
            this.addition = addition;
        }

        public String getSubadd() {
            return subadd;
        }

        public void setSubadd(String subadd) {
            this.subadd = subadd;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public Object getTotlePrice() {
            return totlePrice;
        }

        public void setTotlePrice(Object totlePrice) {
            this.totlePrice = totlePrice;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
