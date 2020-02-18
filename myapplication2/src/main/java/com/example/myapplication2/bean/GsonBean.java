package com.example.myapplication2.bean;

import java.util.List;

public class GsonBean {

    /**
     * orderList : [{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":14,"commodityName":"美诺MENOW面部刷","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/4.jpg","commodityPrice":47,"orderDetailId":13065},{"commentStatus":1,"commodityCount":1,"commodityId":17,"commodityName":"化妆镜","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/5.jpg","commodityPrice":31,"orderDetailId":13066}],"expressCompName":"京东快递","expressSn":"1001","orderId":"202002111158275631217","orderStatus":1,"orderTime":1581393508000,"payAmount":78,"payMethod":1,"userId":1217},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":14,"commodityName":"美诺MENOW面部刷","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/4.jpg","commodityPrice":47,"orderDetailId":13064}],"expressCompName":"京东快递","expressSn":"1001","orderId":"202002111157460101217","orderStatus":2,"orderTime":1581393466000,"payAmount":47,"payMethod":1,"userId":1217},{"detailList":[{"commentStatus":1,"commodityCount":1,"commodityId":23,"commodityName":"小白鞋 女款 时尚百搭休闲板鞋","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/1.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/2.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/3.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/4.jpg,http://mobile.bwstudent.com/images/small/commodity/nx/bx/6/5.jpg","commodityPrice":139,"orderDetailId":13062},{"commentStatus":1,"commodityCount":1,"commodityId":17,"commodityName":"化妆镜","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/5.jpg","commodityPrice":31,"orderDetailId":13063}],"expressCompName":"京东快递","expressSn":"1001","orderId":"202002111153144841217","orderStatus":3,"orderTime":1581393194000,"payAmount":170,"payMethod":1,"userId":1217}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<OrderListBean> orderList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * detailList : [{"commentStatus":1,"commodityCount":1,"commodityId":14,"commodityName":"美诺MENOW面部刷","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/4.jpg","commodityPrice":47,"orderDetailId":13065},{"commentStatus":1,"commodityCount":1,"commodityId":17,"commodityName":"化妆镜","commodityPic":"http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/4.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/7/5.jpg","commodityPrice":31,"orderDetailId":13066}]
         * expressCompName : 京东快递
         * expressSn : 1001
         * orderId : 202002111158275631217
         * orderStatus : 1
         * orderTime : 1581393508000
         * payAmount : 78
         * payMethod : 1
         * userId : 1217
         */

        private String expressCompName;
        private String expressSn;
        private String orderId;
        private int orderStatus;
        private long orderTime;
        private int payAmount;
        private int payMethod;
        private int userId;
        private List<DetailListBean> detailList;

        public String getExpressCompName() {
            return expressCompName;
        }

        public void setExpressCompName(String expressCompName) {
            this.expressCompName = expressCompName;
        }

        public String getExpressSn() {
            return expressSn;
        }

        public void setExpressSn(String expressSn) {
            this.expressSn = expressSn;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public long getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(long orderTime) {
            this.orderTime = orderTime;
        }

        public int getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(int payAmount) {
            this.payAmount = payAmount;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * commentStatus : 1
             * commodityCount : 1
             * commodityId : 14
             * commodityName : 美诺MENOW面部刷
             * commodityPic : http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/1.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/2.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/3.jpg,http://mobile.bwstudent.com/images/small/commodity/mzhf/mzgj/4/4.jpg
             * commodityPrice : 47
             * orderDetailId : 13065
             */

            private int commentStatus;
            private int commodityCount;
            private int commodityId;
            private String commodityName;
            private String commodityPic;
            private int commodityPrice;
            private int orderDetailId;

            public int getCommentStatus() {
                return commentStatus;
            }

            public void setCommentStatus(int commentStatus) {
                this.commentStatus = commentStatus;
            }

            public int getCommodityCount() {
                return commodityCount;
            }

            public void setCommodityCount(int commodityCount) {
                this.commodityCount = commodityCount;
            }

            public int getCommodityId() {
                return commodityId;
            }

            public void setCommodityId(int commodityId) {
                this.commodityId = commodityId;
            }

            public String getCommodityName() {
                return commodityName;
            }

            public void setCommodityName(String commodityName) {
                this.commodityName = commodityName;
            }

            public String getCommodityPic() {
                return commodityPic;
            }

            public void setCommodityPic(String commodityPic) {
                this.commodityPic = commodityPic;
            }

            public int getCommodityPrice() {
                return commodityPrice;
            }

            public void setCommodityPrice(int commodityPrice) {
                this.commodityPrice = commodityPrice;
            }

            public int getOrderDetailId() {
                return orderDetailId;
            }

            public void setOrderDetailId(int orderDetailId) {
                this.orderDetailId = orderDetailId;
            }
        }
    }
}
