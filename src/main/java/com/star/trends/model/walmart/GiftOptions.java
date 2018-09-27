package com.star.trends.model.walmart;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GiftOptions
{
    private String allowGiftMessage;

    private String allowGiftReceipt;

    private String allowGiftWrap;

    public String getAllowGiftMessage ()
    {
        return allowGiftMessage;
    }

    public void setAllowGiftMessage (String allowGiftMessage)
    {
        this.allowGiftMessage = allowGiftMessage;
    }

    public String getAllowGiftReceipt ()
    {
        return allowGiftReceipt;
    }

    public void setAllowGiftReceipt (String allowGiftReceipt)
    {
        this.allowGiftReceipt = allowGiftReceipt;
    }

    public String getAllowGiftWrap ()
    {
        return allowGiftWrap;
    }

    public void setAllowGiftWrap (String allowGiftWrap)
    {
        this.allowGiftWrap = allowGiftWrap;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [allowGiftMessage = "+allowGiftMessage+", allowGiftReceipt = "+allowGiftReceipt+", allowGiftWrap = "+allowGiftWrap+"]";
    }
}