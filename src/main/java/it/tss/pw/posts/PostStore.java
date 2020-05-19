/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pw.posts;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author spaceman33
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PostStore {

    @PersistenceContext(name = "pw")
    EntityManager em;
}
