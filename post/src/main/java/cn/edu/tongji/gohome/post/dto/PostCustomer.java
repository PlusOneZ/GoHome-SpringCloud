package cn.edu.tongji.gohome.post.dto;


import cn.edu.tongji.gohome.post.dto.mapper.PostCustomerMapper;

/**
 * @brief Customer information display in post detail page and post reply
 *
 * @author lilet
 */
public class PostCustomer {
    private long customerId;

    private String customerName;

    private String customerAvatarLink;


    public long getCustomerId()
    {
        return customerId;
    }

    public void setCustomerId(long customerId)
    {
        this.customerId=customerId;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAvatarLink() {
        return customerAvatarLink;
    }

    public void setCustomerAvatarLink(String customerAvatarLink) {
        this.customerAvatarLink = customerAvatarLink;
    }
}
