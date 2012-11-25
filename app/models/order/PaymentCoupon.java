/**
 * Copyright HomeOffice Ltda.
 *
 */
package models.order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TODO describe this class
 *
 * @since 2012
 */
@Entity
@Table(name="ORDER_PAYMENT_COUPONS")
public class PaymentCoupon {

    
    @Id
    @Column(name = "OPC_ID")
    @SequenceGenerator(name="ORDER_PAYMENT_COUPONS_SEQ")
    private long id;
    
    @Column(name="OPC_COUPON_CODE")
    private String couponCode;
    
    @Column(name="OPC_ISSUED_DATE")
    private Date issuedDate;
    
    @Column(name="OPC_PAYED_DATE")
    private Date payedDate;
    
    @Column(name="OPC_DUE_AMOUNT")
    private float dueAmount;
    
    @Column(name="OPC_PAYED_AMOUNT")
    private float payedAmount;

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getPayedDate() {
        return payedDate;
    }

    public void setPayedDate(Date payedDate) {
        this.payedDate = payedDate;
    }

    public float getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(float dueAmount) {
        this.dueAmount = dueAmount;
    }

    public float getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(float payedAmount) {
        this.payedAmount = payedAmount;
    }
}
