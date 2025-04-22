/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fss.dto.res;

import com.blazebit.persistence.view.CollectionMapping;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.Mapping;
import fss.domain.model.Customer;
import fss.domain.model.Order;
import fss.domain.model.OrderDetail;
import fss.domain.model.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@EntityView(Customer.class)
public record CustomerOrderSummaryView(
        @IdMapping
        Integer id,
        String name,
        @CollectionMapping
        List<OrderView> orders
        ) {

}

@EntityView(Order.class)
record OrderView(
        @IdMapping
        Integer id,
        LocalDate date,
        short size,
        List<OrderDetailView> orderDetail) {

}

@EntityView(OrderDetail.class)
record OrderDetailView(
        ProductRecord product,
        String unit,
        @Mapping("qty2*unitPrice")
        Double totalAmount,
        Double qty,
        Double qty2) {

    public Double totalAmount() {
        BigDecimal bd = new BigDecimal(this.totalAmount).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}

@EntityView(Product.class)
record ProductRecord(String name) {

}
