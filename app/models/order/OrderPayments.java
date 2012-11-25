/**
 * Copyright HomeOffice Ltda.
 *
 */
package models.order;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * TODO describe this class
 *
 * @since 2012
 */
@Entity
@Table(name="ORDER_PAYMENTS")
public class OrderPayments {
    
    @Id
    @Column(name = "OPM_ID")
    @SequenceGenerator(name="ORDER_PAYMENTS_SEQ")
    private long id;
    
    @Column(name="OPM_SEQ")
    private int sequence;
    
    @Column(name="OPM_DUE_DATE")
    private Date dueDate;
    
    @Column(name="OPM_DUE_AMOUNT")
    private float dueAmount;
    
    @OneToMany
    @JoinColumn(name="OPM_ID")
    private Collection<PaymentCoupon> coupons;

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public float getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(float dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Collection<PaymentCoupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(Collection<PaymentCoupon> coupons) {
        this.coupons = coupons;
    }
    
}
