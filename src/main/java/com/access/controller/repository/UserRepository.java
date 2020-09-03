/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.access.controller.repository;

import com.access.controller.models.UserModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Jucelio
 */
public interface UserRepository extends CrudRepository<UserModel, Integer> {
    
}
