package main;

import org.koushik.javabrains.InvalidPropertyException_Exception;
import org.koushik.javabrains.ShopInfo;
import org.koushik.javabrains.ShopInfoService;

/**
 * Created by van on 6/21/15.
 */
public class Test {
    public static void main(String[] args) throws InvalidPropertyException_Exception {
        ShopInfoService service = new ShopInfoService();
        ShopInfo shopInfo = service.getShopInfoPort();
        String info = shopInfo.getShopInfo("since");
        System.out.println(info);
    }
}
