package com.all_in_one_springdata.springdata.entity.otherStuff;


import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Audited
public class FooWithAudit extends BaseEntity {


    private String fooName;

    public String getFooName() {
        return fooName;
    }

    public void setFooName(String fooName) {
        this.fooName = fooName;
    }
}
