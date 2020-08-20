package com.mohamedfattah95.coffee.data.network.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResponse {

    /**
     * code : 200
     * Status : success
     * Product : {"id":1,"title":"قهوه اسبريسو","description":"قهوه مصنعه من اجود انواع البن","price":"10","img":"1567358201.TuvgjmZMwSr6NcJSm3jqtqnTY.png","cat_id":"1","confirm":"1","created_by":"1","updated_by":"1","created_at":"2019-06-24 11:45:17","updated_at":"2019-09-03 05:52:41","Additions":[{"id":1,"title":"السكر","subAdd":[{"id":2,"title":"بدون سكر","subAdd":1,"img":"1567419489.sugar-cube.svg"},{"id":3,"title":"سكر قليل","subAdd":1,"img":"1567418493.sugar(8).svg"},{"id":4,"title":"سكر متوسط","subAdd":1,"img":"1567357477.sugar(9).svg"},{"id":5,"title":"سكر كثير","subAdd":1,"img":"1567357490.sugar(10).svg"}]},{"id":6,"title":"حليب","subAdd":[{"id":7,"title":"كثير","subAdd":6,"img":"1567357766.milk(2).svg"},{"id":8,"title":"قليل","subAdd":6,"img":"1567419139.milk.svg"},{"id":9,"title":"متوسط","subAdd":6,"img":"1567357755.milk(1).svg"}]}],"tax":"5"}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("Status")
    private String Status;
    @SerializedName("Product")
    private ProductBean Product;

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

    public ProductBean getProduct() {
        return Product;
    }

    public void setProduct(ProductBean Product) {
        this.Product = Product;
    }

    public static class ProductBean {
        /**
         * id : 1
         * title : قهوه اسبريسو
         * description : قهوه مصنعه من اجود انواع البن
         * price : 10
         * img : 1567358201.TuvgjmZMwSr6NcJSm3jqtqnTY.png
         * cat_id : 1
         * confirm : 1
         * created_by : 1
         * updated_by : 1
         * created_at : 2019-06-24 11:45:17
         * updated_at : 2019-09-03 05:52:41
         * Additions : [{"id":1,"title":"السكر","subAdd":[{"id":2,"title":"بدون سكر","subAdd":1,"img":"1567419489.sugar-cube.svg"},{"id":3,"title":"سكر قليل","subAdd":1,"img":"1567418493.sugar(8).svg"},{"id":4,"title":"سكر متوسط","subAdd":1,"img":"1567357477.sugar(9).svg"},{"id":5,"title":"سكر كثير","subAdd":1,"img":"1567357490.sugar(10).svg"}]},{"id":6,"title":"حليب","subAdd":[{"id":7,"title":"كثير","subAdd":6,"img":"1567357766.milk(2).svg"},{"id":8,"title":"قليل","subAdd":6,"img":"1567419139.milk.svg"},{"id":9,"title":"متوسط","subAdd":6,"img":"1567357755.milk(1).svg"}]}]
         * tax : 5
         */

        @SerializedName("id")
        private int id;
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String description;
        @SerializedName("price")
        private String price;
        @SerializedName("img")
        private String img;
        @SerializedName("cat_id")
        private String catId;
        @SerializedName("confirm")
        private String confirm;
        @SerializedName("created_by")
        private String createdBy;
        @SerializedName("updated_by")
        private String updatedBy;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;
        @SerializedName("tax")
        private String tax;
        @SerializedName("Additions")
        private List<AdditionsBean> Additions;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getCatId() {
            return catId;
        }

        public void setCatId(String catId) {
            this.catId = catId;
        }

        public String getConfirm() {
            return confirm;
        }

        public void setConfirm(String confirm) {
            this.confirm = confirm;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
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

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public List<AdditionsBean> getAdditions() {
            return Additions;
        }

        public void setAdditions(List<AdditionsBean> Additions) {
            this.Additions = Additions;
        }

        public static class AdditionsBean {
            /**
             * id : 1
             * title : السكر
             * subAdd : [{"id":2,"title":"بدون سكر","subAdd":1,"img":"1567419489.sugar-cube.svg"},{"id":3,"title":"سكر قليل","subAdd":1,"img":"1567418493.sugar(8).svg"},{"id":4,"title":"سكر متوسط","subAdd":1,"img":"1567357477.sugar(9).svg"},{"id":5,"title":"سكر كثير","subAdd":1,"img":"1567357490.sugar(10).svg"}]
             */

            @SerializedName("id")
            private int id;
            @SerializedName("title")
            private String title;
            @SerializedName("subAdd")
            private List<SubAddBean> subAdd;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<SubAddBean> getSubAdd() {
                return subAdd;
            }

            public void setSubAdd(List<SubAddBean> subAdd) {
                this.subAdd = subAdd;
            }

            public static class SubAddBean {
                /**
                 * id : 2
                 * title : بدون سكر
                 * subAdd : 1
                 * img : 1567419489.sugar-cube.svg
                 */

                @SerializedName("id")
                private int id;
                @SerializedName("title")
                private String title;
                @SerializedName("subAdd")
                private int subAdd;
                @SerializedName("img")
                private String img;

                private boolean isSelected = false;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getSubAdd() {
                    return subAdd;
                }

                public void setSubAdd(int subAdd) {
                    this.subAdd = subAdd;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public boolean isSelected() {
                    return isSelected;
                }

                public void setSelected(boolean selected) {
                    isSelected = selected;
                }
            }
        }
    }
}
