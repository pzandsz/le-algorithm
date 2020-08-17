package dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 类说明: 零钱兑换
 * 自定而下+备忘录
 * @author zengpeng
 */
public class CoinChange {

    Map<Integer,Integer> cache = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return 0;
        }

        if(amount == 0){
            for(int j=0;j<coins.length;j++){
                if(coins[j] == 0){
                    return 1;
                }
            }
            return 0;
        }

        int digui = digui(coins, amount);
        if(digui == Integer.MAX_VALUE || digui < 0){
            return -1;
        }

        cache.forEach((k,v)->{
            System.out.println(k+" , "+v);
        });
        return digui;
    }

    public int digui(int[] coins, int amount){
        if(amount < 0){
            return -1;
        }
        int min = Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            if(coins[i] == amount){
                return 1;
            }

            Integer digui = cache.get(amount);
            if(digui == null){
                digui = digui(coins, amount - coins[i])+1;
            }
            if(digui <= 0){
                continue;
            }
            min = Math.min(min,digui);
        }
        cache.put(amount,min);

        return min;
    }
}
