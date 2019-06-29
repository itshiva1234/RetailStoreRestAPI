package com.myretailcompany.dataaccesslayer.repository;

import org.springframework.data.repository.CrudRepository;
import com.myretailcompany.dataaccesslayer.entity.Bill;

public interface BillRepository extends CrudRepository<Bill, Long> {

}
