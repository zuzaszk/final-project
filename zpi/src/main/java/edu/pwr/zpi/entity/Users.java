package edu.pwr.zpi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class Users {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String usosId;

    private String email;

    private String name;

    private String alternativeEmail;

    private Integer state;

    private Timestamp createdAt;

    private Timestamp lastLoginAt;

    private Timestamp lastUpdatedAt;

    private String password;

    private String firstName;

    private String lastName;


    private Role role;  // The user's role in the project
}
