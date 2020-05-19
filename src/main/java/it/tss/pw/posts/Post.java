/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.pw.posts;

import it.tss.pw.AbstractEntity;
import it.tss.pw.users.User;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author spaceman33
 */
@Entity
@Table(name = "post") //Chiamare al singolare
public class Post extends AbstractEntity {

    @NotEmpty
    @Column(name = "title", nullable = false)
    private String title;
    @ManyToOne(optional = false) //Molti post possono avere tanti proprietari, sarà il proprietario di un post
    private User owner;
    @NotEmpty
    @Column(name = "body", nullable = false)
    private String body;
    @Column(name = "end_date", nullable = true)
    private LocalDate endDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Post{" + "title=" + title + ", owner=" + owner + ", body=" + body + ", endDate=" + endDate + '}';
    }

}
