package com.gc.recommend.utils;

import android.content.Context;
import android.util.SparseArray;

import com.gc.recommend.R;
import com.gc.recommend.beans.LocalClothBean;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class LocalClothProvider {
    public static final String LOCALCLOTH_JSON="localcloth_json";
    private SparseArray<LocalClothBean> mClothList =null;
    private Context mContext;


    public LocalClothProvider(Context context){
        mContext = context;
        mClothList = new SparseArray<>(20);
        listToSparse();
    }



    public void put(LocalClothBean cloth){

        LocalClothBean temp =  mClothList.get(cloth.getmID());

        if(temp==null){
            temp = cloth;
        }
        mClothList.put(cloth.getmID(), temp);

        commit();

    }

    public void update(LocalClothBean cloth){

        mClothList.put(cloth.getmID(), cloth);
        commit();
    }

    public void delete(LocalClothBean cloth){
        if(mClothList.get(cloth.getmID())!=null) {
            mClothList.delete(cloth.getmID());
            commit();
        }
    }

    public List<LocalClothBean> getAll(){
        return  getDataFromLocal();
    }


    public void commit(){
        List<LocalClothBean> carts = sparseToList();
        PreferencesUtils.putString(mContext,LOCALCLOTH_JSON,JSONUtil.toJSON(carts));
    }


    private List<LocalClothBean> sparseToList(){
        int size = mClothList.size();
        List<LocalClothBean> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(mClothList.valueAt(i));
        }
        return list;
    }



    private void listToSparse(){
        List<LocalClothBean> clothes =  getDataFromLocal();
        if(clothes!=null && clothes.size()>0){
            for (LocalClothBean cloth: clothes) {
                mClothList.put(cloth.getmID(), cloth);
            }
        }else{
            mClothList.put(1, new LocalClothBean(1,"蕾丝网纱连衣裙",589, R.mipmap.c1,"这件衣服是我让所有衣服中最不一样风格的一款，也是最漂亮的一款，做工精细，质量很好"));
            mClothList.put(2, new LocalClothBean(2,"印花雪纺连衣裙",489, R.mipmap.c2,"裙子很好看，就是一米六以下的要剪掉一圈，好评"));
            mClothList.put(3, new LocalClothBean(3,"墨绿色连衣裙",569, R.mipmap.c3,"裙子穿上显气质，尺码款式质量都不错，价格合理，值得拥有。"));
            mClothList.put(4, new LocalClothBean(4,"套装婚礼装",359, R.mipmap.c4,"裙子特别时尚大方，长度也正好，穿上显高挑，关键是版型好看，洗过也不掉色。"));
            mClothList.put(5, new LocalClothBean(5,"很仙的连衣裙两件套",289, R.mipmap.c5,"裙子的面料很舒适，版型设计很时尚，尺码标准，腰部收腰效果很好，很满意这条裙子。"));
            mClothList.put(6, new LocalClothBean(6,"印花连衣裙",189, R.mipmap.c6,"连衣裙穿上身的效果真心好看，衬得气色都很好了，卖家态度特别不错。"));
            mClothList.put(7, new LocalClothBean(7,"花式针织连衣裙",479, R.mipmap.c7,"款式是我喜欢的，穿和高跟鞋看着很有气质老公说感觉跟女神范她家的衣服一直是我喜欢的类型"));
            mClothList.put(8, new LocalClothBean(8,"优雅镂空设计连衣裙",239, R.mipmap.c8,"不论是款式面料，质量做工都非常满意，我还会继续光临你们店"));
            mClothList.put(9, new LocalClothBean(9,"收腰系带碎花茶歇裙",558, R.mipmap.c9,"颜色版型都很满意，洗了也没有发生掉色，细节做的很好，找不到一点点的线头，上身效果非常好。"));
            mClothList.put(10, new LocalClothBean(10,"毛边粗花呢两件套连衣裙",589, R.mipmap.c10,"这件连衣裙是我的最爱，尺码标准，款式时尚，穿上特别修身，很有女神范的一件裙子"));
            mClothList.put(11, new LocalClothBean(11,"单排扣荷叶边袖修身裙",519, R.mipmap.c11,"整体评价：挺好看的 很轻很飘逸 版型很好 我的身高体重：162cm 52kg"));
            mClothList.put(12, new LocalClothBean(12,"POLO领泡泡袖连衣裙",359, R.mipmap.c12,"质量很好，穿起来很瘦身，最滿意一次购物"));
            mClothList.put(13, new LocalClothBean(13,"重磅缎面真丝连衣裙",419, R.mipmap.c13,"好看好看，质量很好，很上档次！爱了爱了"));
            mClothList.put(14, new LocalClothBean(14,"收腰系带连衣裙",269, R.mipmap.c14,"衣裙收到立马上身试了一下，效果非常好，很大方很有气质，特别显瘦，蕾丝面料摸上去很舒服，客服推荐的码数也很合适"));
            mClothList.put(15, new LocalClothBean(15,"高端显瘦显高裙子",179, R.mipmap.c15,"裙子穿上很好看，像量身定做的一样 料子穿起来很舒服。会再来回购\n"));
            mClothList.put(16, new LocalClothBean(16,"棉质混纺T恤连衣裙",689, R.mipmap.c16,"质量不错，尺码合适，穿上身很好看，满意"));
            mClothList.put(17, new LocalClothBean(17,"旗袍镂空网纱格子连衣裙",469, R.mipmap.c17,"穿出去朋友都说好看，整个人的气质提升了不少，裙子面料舒适，很满意的衣服。"));
            mClothList.put(18, new LocalClothBean(18,"流苏吊带雪纺连衣裙",329, R.mipmap.c18,"穿完洗过一次就开始起球，真的太垃圾了，完全不值这个价"));
            mClothList.put(19, new LocalClothBean(19,"细格纹双排扣收腰连衣裙",169, R.mipmap.c19,"宝贝收到啦！非常漂亮，老公朋友都说好看，很满意下次再购买"));
            mClothList.put(20, new LocalClothBean(20,"POLO领连衣裙",519, R.mipmap.c20,"衣服刚收到了，打开试穿大小刚刚好，版型很漂亮，做工也细致，买过好几次了，一直都挺不错的。"));
            commit();
        }

    }



    public  List<LocalClothBean> getDataFromLocal(){

        String json = PreferencesUtils.getString(mContext,LOCALCLOTH_JSON);
        List<LocalClothBean> carts =null;
        if(json !=null ){
            carts = JSONUtil.fromJson(json,new TypeToken<List<LocalClothBean>>(){}.getType());
        }
        return  carts;
    }
}
