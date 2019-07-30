package com.ll.secondhouse.utils;
import com.ll.secondhouse.bean.recommend;
import com.ll.secondhouse.bean.users;

import java.util.*;

/**
 * created by liulei at 2019/6/29
 */
public class Recommend {
    /**
     * @param usersList 用户群
     * @param recommends 用户评分
     * @param uid 用户id
     * @return 针对用户的推荐系统
     */

    public List<Integer> gettherecommendhouse(List<users> usersList,List<recommend> recommends,int uid){
        System.out.println(recommends);
        List<Integer> result = new ArrayList<>();
        int recommendslongth = recommends.size();
        Map<Integer,Map<Integer,Integer>> usersmap = new HashMap<>();
        for(int i = 0;i<usersList.size();i++){
            if(uid != usersList.get(i).getU_id()){
                Map<Integer,Integer> map = new HashMap<>();
                for(int j = 0;j<recommendslongth;j++){
                    if(usersList.get(i).getU_id() == recommends.get(j).getU_id()){
                        map.put(recommends.get(j).getH_id(),recommends.get(j).getScore());
                    }
                }
                if(map.size() != 0){
                    usersmap.put(usersList.get(i).getU_id(),map);
                }

            }
        }
        System.out.println("用户群的map矩阵为");
        System.out.println(usersmap);
        Map<Integer,Integer> usermap = new HashMap<>();
        for(int i =0;i<recommendslongth;i++){
            if(uid == recommends.get(i).getU_id()){
                usermap.put(recommends.get(i).getH_id(),recommends.get(i).getScore());
            }
        }
        System.out.println("用户的map矩阵为");
        System.out.println(usermap);
        Map<Integer,Double> cosSimilarity = new HashMap<>();
        for(Integer userid:usersmap.keySet()){
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            Map<Integer,Integer> map = usersmap.get(userid);
            for(Integer a : usermap.keySet()){
                list1.add(usermap.get(a));
                if(map.keySet().contains(a)){
                    list2.add(map.get(a));
                }else{
                    list2.add(0);
                }
            }
            for(Integer a : map.keySet()){
                if(!usermap.keySet().contains(a)){
                    list1.add(0);
                    list2.add(map.get(a));
                }
            }
            cosSimilarity.put(userid,xiangliangyuxian(list1,list2));
        }
        System.out.println("得到的相似矩阵为");
        System.out.println(cosSimilarity);
        double a = -1;
        int indexid = 0;
        for(Integer h:cosSimilarity.keySet()){
            if(cosSimilarity.get(h)>=a){
                a = cosSimilarity.get(h);
                indexid = h;
            }
        }
        System.out.println(indexid);


        Map<Integer,Integer> nearmap = usersmap.get(indexid);
        List<Integer> record = new ArrayList<>();
        for(Integer data:nearmap.keySet()){
            if(usermap.keySet().contains(data)){
                record.add(data);
            }
        }
        for(int i =0;i<record.size();i++){
            nearmap.remove(record.get(i));
        }
        List<Integer> houseid = new ArrayList<>();
        while(nearmap.keySet().size()!=0){
            int pingfen = 0;
            int index = 0;
            for(Integer h:nearmap.keySet()){
                if(nearmap.get(h)>pingfen){
                    pingfen = nearmap.get(h);
                    index = h;
                }
            }
            houseid.add(index);
            nearmap.remove(index);
        }
        return result;
    }

    /*计算两个用户之间的余弦相似性*/
    public double xiangliangyuxian(List<Integer> list1,List<Integer> list2){
        int longth = list1.size();
        int sum = 0;
        int sumqure1 = 0;
        int sumqure2 = 0;
        for(int i =0;i<longth;i++){
            sum = list1.get(i)*list2.get(i) + sum;
            sumqure1 = sumqure1 + list1.get(i)*list1.get(i);
            sumqure2 = sumqure2 + list2.get(i)*list2.get(i);
        }
        return sum/(Math.sqrt(sumqure1)*Math.sqrt(sumqure2));
    }

}