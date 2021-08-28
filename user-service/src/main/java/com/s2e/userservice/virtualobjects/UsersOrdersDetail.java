package com.s2e.userservice.virtualobjects;

import com.s2e.userservice.model.Orders;
import com.s2e.userservice.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersOrdersDetail {

    private Users users;
    private Orders orders;

}
