/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pankaj.amal
 */
@Entity
@Table(name = "exchange_feed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExchangeFeed.findAll", query = "SELECT e FROM ExchangeFeed e"),
    @NamedQuery(name = "ExchangeFeed.findByExchangeFeedId", query = "SELECT e FROM ExchangeFeed e WHERE e.exchangeFeedId = :exchangeFeedId"),
    @NamedQuery(name = "ExchangeFeed.findByExchageFeedCurrency", query = "SELECT e FROM ExchangeFeed e WHERE e.exchageFeedCurrency = :exchageFeedCurrency"),
    @NamedQuery(name = "ExchangeFeed.findByExchangeFeedSource", query = "SELECT e FROM ExchangeFeed e WHERE e.exchangeFeedSource = :exchangeFeedSource"),
    @NamedQuery(name = "ExchangeFeed.findByExchangeFeedDate", query = "SELECT e FROM ExchangeFeed e WHERE e.exchangeFeedDate = :exchangeFeedDate"),
    @NamedQuery(name = "ExchangeFeed.findByExchangeFeedTitle", query = "SELECT e FROM ExchangeFeed e WHERE e.exchangeFeedTitle = :exchangeFeedTitle"),
    @NamedQuery(name = "ExchangeFeed.findByExchageFeedFlag", query = "SELECT e FROM ExchangeFeed e WHERE e.exchageFeedFlag = :exchageFeedFlag")})
public class ExchangeFeed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exchange_feed_id")
    private Integer exchangeFeedId;
    @Column(name = "exchage_feed_currency")
    private String exchageFeedCurrency;
    @Column(name = "exchange_feed_source")
    private String exchangeFeedSource;
    @Column(name = "exchange_feed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exchangeFeedDate;
    @Column(name = "exchange_feed_title")
    private String exchangeFeedTitle;
    @Column(name = "exchage_feed_flag")
    private Integer exchageFeedFlag;
    @OneToMany(mappedBy = "exchangeFeedId")
    private Collection<ExchangeRate> exchangeRateCollection;

    public ExchangeFeed() {
    }

    public ExchangeFeed(Integer exchangeFeedId) {
        this.exchangeFeedId = exchangeFeedId;
    }

    public Integer getExchangeFeedId() {
        return exchangeFeedId;
    }

    public void setExchangeFeedId(Integer exchangeFeedId) {
        this.exchangeFeedId = exchangeFeedId;
    }

    public String getExchageFeedCurrency() {
        return exchageFeedCurrency;
    }

    public void setExchageFeedCurrency(String exchageFeedCurrency) {
        this.exchageFeedCurrency = exchageFeedCurrency;
    }

    public String getExchangeFeedSource() {
        return exchangeFeedSource;
    }

    public void setExchangeFeedSource(String exchangeFeedSource) {
        this.exchangeFeedSource = exchangeFeedSource;
    }

    public Date getExchangeFeedDate() {
        return exchangeFeedDate;
    }

    public void setExchangeFeedDate(Date exchangeFeedDate) {
        this.exchangeFeedDate = exchangeFeedDate;
    }

    public String getExchangeFeedTitle() {
        return exchangeFeedTitle;
    }

    public void setExchangeFeedTitle(String exchangeFeedTitle) {
        this.exchangeFeedTitle = exchangeFeedTitle;
    }

    public Integer getExchageFeedFlag() {
        return exchageFeedFlag;
    }

    public void setExchageFeedFlag(Integer exchageFeedFlag) {
        this.exchageFeedFlag = exchageFeedFlag;
    }

    @XmlTransient
    public Collection<ExchangeRate> getExchangeRateCollection() {
        return exchangeRateCollection;
    }

    public void setExchangeRateCollection(Collection<ExchangeRate> exchangeRateCollection) {
        this.exchangeRateCollection = exchangeRateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exchangeFeedId != null ? exchangeFeedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExchangeFeed)) {
            return false;
        }
        ExchangeFeed other = (ExchangeFeed) object;
        if ((this.exchangeFeedId == null && other.exchangeFeedId != null) || (this.exchangeFeedId != null && !this.exchangeFeedId.equals(other.exchangeFeedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.ExchangeFeed[ exchangeFeedId=" + exchangeFeedId + " ]";
    }
    
}
