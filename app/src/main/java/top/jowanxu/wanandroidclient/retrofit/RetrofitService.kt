import retrofit2.Call
import retrofit2.http.*
import top.jowanxu.wanandroidclient.bean.*

/**
 * Retrofit请求api
 */
interface RetrofitService {

    /**
     * 首页数据
     * http://www.wanandroid.com/article/list/0/json
     * @param page page
     */
    @GET("/article/list/{page}/json")
    fun getHomeList(
            @Path("page") page: Int
    ): Call<HomeListResponse>

    /**
     * 知识体系
     * http://www.wanandroid.com/tree/json
     */
    @GET("/tree/json")
    fun getTypeTreeList(): Call<TreeListResponse>

    /**
     * 知识体系下的文章
     * http://www.wanandroid.com/article/list/0/json?cid=168
     * @param page page
     * @param cid cid
     */
    @GET("/article/list/{page}/json")
    fun getArticleList(@Path("page") page: Int,
                       @Query("cid") cid: Int
    ): Call<ArticleListResponse>

    /**
     * 常用网站
     * http://www.wanandroid.com/friend/json
     */
    @GET("/friend/json")
    fun getFriendList(): Call<FriendListResponse>

    /**
     * 大家都在搜
     * http://www.wanandroid.com/hotkey/json
     */
    @GET("/hotkey/json")
    fun getHotKeyList(): Call<HotKeyResponse>

    /**
     * 搜索
     * http://www.wanandroid.com/article/query/0/json
     * @param page page
     * @param k POST search key
     */
    @POST("/article/query/{page}/json")
    @FormUrlEncoded
    fun getSearchList(@Path("page") page: Int,
                      @Field("k") k: String
    ): Call<SearchListResponse>

    /**
     * 登录
     */
    @POST("/user/login")
    @FormUrlEncoded
    fun loginWanAndroid(@Field("username") username: String,
                        @Field("password") password: String
    ): Call<LoginResponse>

    /**
     * 注册
     */
    @POST("/user/register")
    @FormUrlEncoded
    fun registerWanAndroid(@Field("username") username: String,
                           @Field("password") password: String,
                           @Field("repassword") repassowrd: String
    ): Call<LoginResponse>

}