package cn.garjun;

/**
 * @author liangjiajun
 * @create 2020-03-05
 * @description
 **/
public class DividedCandy {
    public int[] distributeCandies(int candies, int num_people) {
        int[] array = new int[num_people];
        int leave = candies;
        int divided = 1;
        int nowPerson = 0;
        while (leave>0){
            if(leave<divided){
                divided = leave;
            }
            leave -= divided;
            array[nowPerson] += divided;
            nowPerson = (nowPerson+1)%num_people;
            divided++;
        }
        return array;
    }
}
