package com.everywhere.trip.bean;

import java.util.List;

public class MoveBean {

    /**
     * code : 0
     * desc :
     * result : {"share":{"shareTitle":"我是榎本伸也，看看我的私藏旅行线路！","shareContent":"作为东京著名花艺师，我的生活和旅行路线绝对精彩！","shareImage":"http://cdn.banmi.com/banmiapp/rahdna/1511446411945_9c435f6d4354d4b5b5e9340b7146cbdc.jpg","shareURL":"http://banmi.com/app2017/banmi.html?id=1"},"banmi":{"id":1,"name":"榎本伸也","location":"东京","occupation":"东京著名花艺师","introduction":"大家好，我是老夏，东京人，一个讲汉语带点北京味儿的花艺师。研习花道不仅修心养性，更让我对生活中的美有着独到的见解与嗅觉。旅途之中，我同样善于用一名花艺师的特有的目光，去发现并勾勒那些细微处的美好。","following":3288,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1511446411945_9c435f6d4354d4b5b5e9340b7146cbdc.jpg","isFollowed":true,"routesCount":2},"activities":[{"id":94,"content":"我和我的情侣装cp","audioURL":"","audioLength":0,"images":["http://cdn.banmi.com/banmiapp/rahdna/1511439688688_f2d662a6ec3b2a47d07757734b1bb812.jpeg"],"firstImageWidth":1000,"firstImageHeight":608,"likeCount":4,"replyCount":6,"isLiked":false,"date":"2017-11-23 20:22"},{"id":89,"content":"都说工作着的人是最帅的","audioURL":"","audioLength":0,"images":["http://cdn.banmi.com/banmiapp/rahdna/1511435277221_1997c40043637fe6b096077f061f5153.jpeg","http://cdn.banmi.com/banmiapp/rahdna/1511435308575_ed018ab49f58519fd14e2e260ef16191.jpeg","http://cdn.banmi.com/banmiapp/rahdna/1511435314862_5d45168b5231918bba0132479f61436c.jpeg"],"firstImageWidth":1280,"firstImageHeight":960,"likeCount":2,"replyCount":7,"isLiked":false,"date":"2017-11-20 19:08"},{"id":91,"content":"","audioURL":"","audioLength":0,"images":["http://cdn.banmi.com/banmiapp/rahdna/1511437010999_97fc889813da7cf8d327148c2334087e.jpeg"],"firstImageWidth":1125,"firstImageHeight":747,"likeCount":1,"replyCount":6,"isLiked":false,"date":"2017-11-16 19:36"},{"id":93,"content":"以前不知道这个地方为什么有那么多人跑来这里照相 后来我老婆给我科普了下。。原来这里是灌篮高手的取景地","audioURL":"","audioLength":0,"images":["http://cdn.banmi.com/banmiapp/rahdna/1511437740420_7e35d5a005c15a7f6a0c8838b45dc5b8.jpeg"],"firstImageWidth":3456,"firstImageHeight":5184,"likeCount":2,"replyCount":5,"isLiked":false,"date":"2017-11-10 16:02"}],"page":1,"limit":20,"count":4}
     */

    private int code;
    private String desc;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * share : {"shareTitle":"我是榎本伸也，看看我的私藏旅行线路！","shareContent":"作为东京著名花艺师，我的生活和旅行路线绝对精彩！","shareImage":"http://cdn.banmi.com/banmiapp/rahdna/1511446411945_9c435f6d4354d4b5b5e9340b7146cbdc.jpg","shareURL":"http://banmi.com/app2017/banmi.html?id=1"}
         * banmi : {"id":1,"name":"榎本伸也","location":"东京","occupation":"东京著名花艺师","introduction":"大家好，我是老夏，东京人，一个讲汉语带点北京味儿的花艺师。研习花道不仅修心养性，更让我对生活中的美有着独到的见解与嗅觉。旅途之中，我同样善于用一名花艺师的特有的目光，去发现并勾勒那些细微处的美好。","following":3288,"photo":"http://cdn.banmi.com/banmiapp/rahdna/1511446411945_9c435f6d4354d4b5b5e9340b7146cbdc.jpg","isFollowed":true,"routesCount":2}
         * activities : [{"id":94,"content":"我和我的情侣装cp","audioURL":"","audioLength":0,"images":["http://cdn.banmi.com/banmiapp/rahdna/1511439688688_f2d662a6ec3b2a47d07757734b1bb812.jpeg"],"firstImageWidth":1000,"firstImageHeight":608,"likeCount":4,"replyCount":6,"isLiked":false,"date":"2017-11-23 20:22"},{"id":89,"content":"都说工作着的人是最帅的","audioURL":"","audioLength":0,"images":["http://cdn.banmi.com/banmiapp/rahdna/1511435277221_1997c40043637fe6b096077f061f5153.jpeg","http://cdn.banmi.com/banmiapp/rahdna/1511435308575_ed018ab49f58519fd14e2e260ef16191.jpeg","http://cdn.banmi.com/banmiapp/rahdna/1511435314862_5d45168b5231918bba0132479f61436c.jpeg"],"firstImageWidth":1280,"firstImageHeight":960,"likeCount":2,"replyCount":7,"isLiked":false,"date":"2017-11-20 19:08"},{"id":91,"content":"","audioURL":"","audioLength":0,"images":["http://cdn.banmi.com/banmiapp/rahdna/1511437010999_97fc889813da7cf8d327148c2334087e.jpeg"],"firstImageWidth":1125,"firstImageHeight":747,"likeCount":1,"replyCount":6,"isLiked":false,"date":"2017-11-16 19:36"},{"id":93,"content":"以前不知道这个地方为什么有那么多人跑来这里照相 后来我老婆给我科普了下。。原来这里是灌篮高手的取景地","audioURL":"","audioLength":0,"images":["http://cdn.banmi.com/banmiapp/rahdna/1511437740420_7e35d5a005c15a7f6a0c8838b45dc5b8.jpeg"],"firstImageWidth":3456,"firstImageHeight":5184,"likeCount":2,"replyCount":5,"isLiked":false,"date":"2017-11-10 16:02"}]
         * page : 1
         * limit : 20
         * count : 4
         */

        private ShareBean share;
        private BanmiBean banmi;
        private int page;
        private int limit;
        private int count;
        private List<ActivitiesBean> activities;

        public ShareBean getShare() {
            return share;
        }

        public void setShare(ShareBean share) {
            this.share = share;
        }

        public BanmiBean getBanmi() {
            return banmi;
        }

        public void setBanmi(BanmiBean banmi) {
            this.banmi = banmi;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ActivitiesBean> getActivities() {
            return activities;
        }

        public void setActivities(List<ActivitiesBean> activities) {
            this.activities = activities;
        }

        public static class ShareBean {
            /**
             * shareTitle : 我是榎本伸也，看看我的私藏旅行线路！
             * shareContent : 作为东京著名花艺师，我的生活和旅行路线绝对精彩！
             * shareImage : http://cdn.banmi.com/banmiapp/rahdna/1511446411945_9c435f6d4354d4b5b5e9340b7146cbdc.jpg
             * shareURL : http://banmi.com/app2017/banmi.html?id=1
             */

            private String shareTitle;
            private String shareContent;
            private String shareImage;
            private String shareURL;

            public String getShareTitle() {
                return shareTitle;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public String getShareContent() {
                return shareContent;
            }

            public void setShareContent(String shareContent) {
                this.shareContent = shareContent;
            }

            public String getShareImage() {
                return shareImage;
            }

            public void setShareImage(String shareImage) {
                this.shareImage = shareImage;
            }

            public String getShareURL() {
                return shareURL;
            }

            public void setShareURL(String shareURL) {
                this.shareURL = shareURL;
            }
        }

        public static class BanmiBean {
            /**
             * id : 1
             * name : 榎本伸也
             * location : 东京
             * occupation : 东京著名花艺师
             * introduction : 大家好，我是老夏，东京人，一个讲汉语带点北京味儿的花艺师。研习花道不仅修心养性，更让我对生活中的美有着独到的见解与嗅觉。旅途之中，我同样善于用一名花艺师的特有的目光，去发现并勾勒那些细微处的美好。
             * following : 3288
             * photo : http://cdn.banmi.com/banmiapp/rahdna/1511446411945_9c435f6d4354d4b5b5e9340b7146cbdc.jpg
             * isFollowed : true
             * routesCount : 2
             */

            private int id;
            private String name;
            private String location;
            private String occupation;
            private String introduction;
            private int following;
            private String photo;
            private boolean isFollowed;
            private int routesCount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getOccupation() {
                return occupation;
            }

            public void setOccupation(String occupation) {
                this.occupation = occupation;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public int getFollowing() {
                return following;
            }

            public void setFollowing(int following) {
                this.following = following;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public boolean isIsFollowed() {
                return isFollowed;
            }

            public void setIsFollowed(boolean isFollowed) {
                this.isFollowed = isFollowed;
            }

            public int getRoutesCount() {
                return routesCount;
            }

            public void setRoutesCount(int routesCount) {
                this.routesCount = routesCount;
            }
        }

        public static class ActivitiesBean {
            /**
             * id : 94
             * content : 我和我的情侣装cp
             * audioURL :
             * audioLength : 0
             * images : ["http://cdn.banmi.com/banmiapp/rahdna/1511439688688_f2d662a6ec3b2a47d07757734b1bb812.jpeg"]
             * firstImageWidth : 1000
             * firstImageHeight : 608
             * likeCount : 4
             * replyCount : 6
             * isLiked : false
             * date : 2017-11-23 20:22
             */

            private int id;
            private String content;
            private String audioURL;
            private int audioLength;
            private int firstImageWidth;
            private int firstImageHeight;
            private int likeCount;
            private int replyCount;
            private boolean isLiked;
            private String date;
            private List<String> images;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getAudioURL() {
                return audioURL;
            }

            public void setAudioURL(String audioURL) {
                this.audioURL = audioURL;
            }

            public int getAudioLength() {
                return audioLength;
            }

            public void setAudioLength(int audioLength) {
                this.audioLength = audioLength;
            }

            public int getFirstImageWidth() {
                return firstImageWidth;
            }

            public void setFirstImageWidth(int firstImageWidth) {
                this.firstImageWidth = firstImageWidth;
            }

            public int getFirstImageHeight() {
                return firstImageHeight;
            }

            public void setFirstImageHeight(int firstImageHeight) {
                this.firstImageHeight = firstImageHeight;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public int getReplyCount() {
                return replyCount;
            }

            public void setReplyCount(int replyCount) {
                this.replyCount = replyCount;
            }

            public boolean isIsLiked() {
                return isLiked;
            }

            public void setIsLiked(boolean isLiked) {
                this.isLiked = isLiked;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }
        }
    }
}
