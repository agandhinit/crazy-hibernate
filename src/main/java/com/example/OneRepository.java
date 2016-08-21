/*
 * Copyright (c) 2015 Citrix Online LLC
 * All Rights Reserved Worldwide.
 *
 * THIS PROGRAM IS CONFIDENTIAL AND PROPRIETARY TO CITRIX ONLINE
 * AND CONSTITUTES A VALUABLE TRADE SECRET.  Any unauthorized use,
 * reproduction, modification, or disclosure of this program is
 * strictly prohibited.  Any use of this program by an authorized
 * licensee is strictly subject to the terms and conditions,
 * including confidentiality obligations, set forth in the applicable
 * License and Co-Branding Agreement between Citrix Online LLC and
 * the licensee.
 */
package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OneRepository extends JpaRepository<One, Long> {

    @Query( "from One o inner join fetch o.many m where o.oneKey = :oneKey and " +
            "m.manyKey = :manyKey")
    One findQuery1(@Param("oneKey") Long oneKey, @Param("manyKey") Long manyKey);
    
    @Query("from One o inner join fetch o.many m where o.oneKey = :oneKey")
    One findQuery2(@Param("oneKey") Long oneKey);
    
    
}
