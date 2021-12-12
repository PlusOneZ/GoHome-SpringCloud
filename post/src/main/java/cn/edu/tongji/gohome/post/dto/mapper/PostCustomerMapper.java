package cn.edu.tongji.gohome.post.dto.mapper;


import cn.edu.tongji.gohome.post.dto.PostCustomer;
import cn.edu.tongji.gohome.post.model.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class PostCustomerMapper {

    private static final PostCustomerMapper mapper = new PostCustomerMapper();

    private PostCustomerMapper(){}

    public static PostCustomerMapper getInstance(){
        return mapper;
    }


    public PostCustomer toDto(CustomerEntity customer){

        PostCustomer postCustomer=new PostCustomer();
        postCustomer.setCustomerId(customer.getCustomerId());
        String defaultAvatarLink="";
        if(customer.getCustomerAvatarLink()!=null)
        {
            defaultAvatarLink= customer.getCustomerAvatarLink();
        }
        postCustomer.setCustomerAvatarLink(defaultAvatarLink);

        String defaultName="";
        if(customer.getCustomerName()!=null)
        {
            defaultName=customer.getCustomerName();
        }
        postCustomer.setCustomerName(defaultName);

        return postCustomer;
    }

}
