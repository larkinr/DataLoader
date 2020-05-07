package com.Hastings.ATCMT.Repositories.Suites;

import com.Hastings.ATCMT.Models.Suites.SuiteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiteRepository extends JpaRepository<SuiteModel, Long>{

}
