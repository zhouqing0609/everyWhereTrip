package com.everywhere.trip.net;

import com.everywhere.trip.bean.Banmi;
import com.everywhere.trip.bean.FollowedBanmi;
import com.everywhere.trip.bean.LikeBean;
import com.everywhere.trip.bean.LoginInfo;
import com.everywhere.trip.bean.MainDataInfo;
import com.everywhere.trip.bean.MoveBean;
import com.everywhere.trip.model.MainDataBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author xts
 *         Created by asus on 2019/5/3.
 */

public interface EveryWhereService {

    public static final int SUCCESS_CODE = 0;
    public static final int VERIFY_CODE_ERROR = 200502;
    public static final int WECHAT_HAVE_BINDED = 20171102;
    //token 失效
    public static final int TOKEN_EXPIRE = 20170707;
    //余额不足
    public static final int MONEY_NOT_ENOUGH = 200607;
    String BASE_URL = "http://api.banmi.com/";


    /**
     * 微信登录
     *
     * @param unionID
     * @return
     */
    @FormUrlEncoded
    @POST("api/3.0/account/login/wechat")
    Observable<LoginInfo> postWechatLogin(@Field("unionID") String unionID);

    /**
     * 微博登录
     *
     * @param oAuthToken 就是三方里面的uid
     * @return
     */
    @FormUrlEncoded
    @POST("api/3.0/account/login/oauth")
    Observable<LoginInfo> postWeiboLogin(@Field("oAuthToken") String oAuthToken);

    @GET("api/3.0/content/routesbundles")
    Observable<MainDataBean> getMainData(@Query("page") int page, @Header("banmi-app-token") String token);


    @GET("api/3.0/banmi")
    Observable<Banmi> getBanmiData(@Query("page") int page, @Header("banmi-app-token") String token);

    @FormUrlEncoded
    @POST("api/3.0/account/updateInfo")
    Observable<String> upDataInfo(@FieldMap HashMap<String,String> hashMap, @Header("banmi-app-token")String token);


    @POST("api/3.0/banmi/{banmiId}/follow")
    Observable<String> addFollow(@Header("banmi-app-token")String token, @Path("banmiId")int id);

    @POST("api/3.0/banmi/{banmiId}/unfollow")
    Observable<String> disFollow(@Header("banmi-app-token")String token, @Path("banmiId")int id);

    @GET("api/3.0/account/followedBanmi")
    Observable<FollowedBanmi> getCollectData(@Header("banmi-app-token")String token, @Query("page") int page);

    @GET("api/3.0/banmi/{banmiId}/routes")
    Observable<MainDataBean> getRoadInfo(@Header("banmi-app-token")String token,@Path("banmiId")int id,@Query("page")int page);

    @GET("api/3.0/banmi/{banmiId}")
    Observable<MoveBean> getMoveInfo(@Header("banmi-app-token")String token, @Path("banmiId")int id,@Query("page")int page);


    @GET("api/3.0/content/routes/{routeId}")
    Observable<MainDataInfo> getRoad(@Header("banmi-app-token")String token,@Path("routeId")int id);
}
