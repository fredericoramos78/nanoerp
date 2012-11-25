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

import models.general.User;


/**
 * TODO describe this class
 *
 * @since 2012
 */
@Entity
@Table(name="ORDERS")
public class Order {

    @Id
    @Column(name = "ORD_ID")
    @SequenceGenerator(name="ORDER_SEQ")
    private long id;
    
    @Column(name = "ORD_CREATION_DATE")
    private Date creationDate;
    
    @Column(name = "ORD_CLOUSURE_DATE")
    private Date clousureDate;

    @Column(name = "ORD_STATUS")
    private OrderStatus status;
    
    @Column(name = "ORD_GROSS_AMOUNT")
    private float grossAmount;
    
    @Column(name = "ORD_DISCOUNT_AMOUNT")
    private float discountAmount;
    
    @Column(name = "ORD_NET_AMOUNT")
    private float netAmount;
    
    @ManyToOne
    @JoinColumn(name="USR_ID")
    private User discountUser;
    
    @OneToMany
    @JoinColumn(name="ORD_ID")
    private Collection<OrderPayments> payments;

    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getClousureDate() {
        return clousureDate;
    }

    public void setClousureDate(Date clousureDate) {
        this.clousureDate = clousureDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public float getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(float grossAmount) {
        this.grossAmount = grossAmount;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public float getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(float netAmount) {
        this.netAmount = netAmount;
    }

    public User getDiscountUser() {
        return discountUser;
    }

    public void setDiscountUser(User discountUser) {
        this.discountUser = discountUser;
    }

    public Collection<OrderPayments> getPayments() {
        return payments;
    }

    public void setPayments(Collection<OrderPayments> payments) {
        this.payments = payments;
    }
}
