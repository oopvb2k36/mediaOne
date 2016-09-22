package com.onemedia.control;

/**
 * Created by PhamHai on 9/21/2016.
 */
public interface IPaymentManagement {
    public boolean savePaymentInfo(Payment payment);
    public boolean savePaymentTagInfo(PaymentTag paymentTag);

    public Payment[] getPaymentList();
    public PaymentTag[] getPaymentTagList();
    public Payment getPaymentByTagCode(String tagCode);
    public PaymentTag getPaymentTagByTagCode(String tagCode);
}
