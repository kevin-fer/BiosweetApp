package com.example.ProductMarket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends  CrudRepository<Account, String>{
    @Override
    List<Account> findAll();
}
