package com.onemedia.control;

/**
 * Created by PhamHai on 9/21/2016.
 */
public class PaymentTag {

    public PaymentTag(Tag tag, Payment payment) {
        setTag(tag);
        setPayment(payment);
    }

    @Override
    public boolean equals(Object obj) {
        return tag.equals(((PaymentTag)(obj)).getTag());
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getPayment() {
        return payment;
    }

    private Tag tag;
    private Payment payment;
}
