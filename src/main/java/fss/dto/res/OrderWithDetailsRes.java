package fss.dto.res;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public record OrderWithDetailsRes(Integer orderId, Integer customerId, String customerName) {    

    public record CustomerRecord(Integer id, String name) {

    }

    public record OrderDetailsRecord(Integer qty, Integer qty2, String unit, Double totalAmount, ProductRecord product) {

        public Double getTotalAmount() {
            BigDecimal bd = new BigDecimal(this.totalAmount).setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
    }

    public record ProductRecord(String name) {

    }

}
