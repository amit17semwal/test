package com.mkyong.domain;

public interface DomainRepositoryCustom {

    int updateDomain(String domain, boolean displayAds);
    
    void insertDomain(Domain domain);

}
