package thread.executor.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class OldOrderService {

    public void order(String orderNo) {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        Boolean inventoryResult = inventoryWork.call();
        Boolean shippingResult = shippingWork.call();
        Boolean accountingResult = accountingWork.call();

        if (inventoryResult && shippingResult && accountingResult) {
            log("Order Succeed!");
        } else {
            log("Order Failed!");
        }
    }

    static class InventoryWork {

        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() {
            log("{Update} Inventory: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class ShippingWork {

        private final String orderNo;

        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() {
            log("{Update} Shipping: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class AccountingWork {

        private final String orderNo;

        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() {
            log("{Update} Accounting: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}
