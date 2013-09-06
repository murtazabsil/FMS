/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluestar.fms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pankaj.amal
 */
@Entity
@Table(name = "exchange_rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExchangeRate.findAll", query = "SELECT e FROM ExchangeRate e"),
    @NamedQuery(name = "ExchangeRate.findByExchangeRateId", query = "SELECT e FROM ExchangeRate e WHERE e.exchangeRateId = :exchangeRateId"),
    @NamedQuery(name = "ExchangeRate.findByExchangeRateFromCurrency", query = "SELECT e FROM ExchangeRate e WHERE e.exchangeRateFromCurrency = :exchangeRateFromCurrency"),
    @NamedQuery(name = "ExchangeRate.findByExchangeRateFromCurrencyId", query = "SELECT e FROM ExchangeRate e WHERE e.exchangeRateFromCurrencyId = :exchangeRateFromCurrencyId"),
    @NamedQuery(name = "ExchangeRate.findByExchangeRateToCurrency", query = "SELECT e FROM ExchangeRate e WHERE e.exchangeRateToCurrency = :exchangeRateToCurrency"),
    @NamedQuery(name = "ExchangeRate.findByExchangeRateToCurrencyId", query = "SELECT e FROM ExchangeRate e WHERE e.exchangeRateToCurrencyId = :exchangeRateToCurrencyId"),
    @NamedQuery(name = "ExchangeRate.findByExchangeRate", query = "SELECT e FROM ExchangeRate e WHERE e.exchangeRate = :exchangeRate"),
    @NamedQuery(name = "ExchangeRate.findByCreated", query = "SELECT e FROM ExchangeRate e WHERE e.created = :created")})
public class ExchangeRate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exchange_rate_id")
    private Integer exchangeRateId;
    @Column(name = "exchange_rate_from_currency")
    private String exchangeRateFromCurrency;
    @Column(name = "exchange_rate_from_currency_id")
    private Integer exchangeRateFromCurrencyId;
    @Column(name = "exchange_rate_to_currency")
    private String exchangeRateToCurrency;
    @Column(name = "exchange_rate_to_currency_id")
    private Integer exchangeRateToCurrencyId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "exchange_rate")
    private Double exchangeRate;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @JoinColumn(name = "exchange_feed_id", referencedColumnName = "exchange_feed_id")
    @ManyToOne
    private ExchangeFeed exchangeFeedId;

    public ExchangeRate() {
    }

    public ExchangeRate(Integer exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }

    public Integer getExchangeRateId() {
        return exchangeRateId;
    }

    public void setExchangeRateId(Integer exchangeRateId) {
        this.exchangeRateId = exchangeRateId;
    }

    public String getExchangeRateFromCurrency() {
        return exchangeRateFromCurrency;
    }

    public void setExchangeRateFromCurrency(String exchangeRateFromCurrency) {
        this.exchangeRateFromCurrency = exchangeRateFromCurrency;
    }

    public Integer getExchangeRateFromCurrencyId() {
        return exchangeRateFromCurrencyId;
    }

    public void setExchangeRateFromCurrencyId(Integer exchangeRateFromCurrencyId) {
        this.exchangeRateFromCurrencyId = exchangeRateFromCurrencyId;
    }

    public String getExchangeRateToCurrency() {
        return exchangeRateToCurrency;
    }

    public void setExchangeRateToCurrency(String exchangeRateToCurrency) {
        this.exchangeRateToCurrency = exchangeRateToCurrency;
    }

    public Integer getExchangeRateToCurrencyId() {
        return exchangeRateToCurrencyId;
    }

    public void setExchangeRateToCurrencyId(Integer exchangeRateToCurrencyId) {
        this.exchangeRateToCurrencyId = exchangeRateToCurrencyId;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public ExchangeFeed getExchangeFeedId() {
        return exchangeFeedId;
    }

    public void setExchangeFeedId(ExchangeFeed exchangeFeedId) {
        this.exchangeFeedId = exchangeFeedId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (exchangeRateId != null ? exchangeRateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExchangeRate)) {
            return false;
        }
        ExchangeRate other = (ExchangeRate) object;
        if ((this.exchangeRateId == null && other.exchangeRateId != null) || (this.exchangeRateId != null && !this.exchangeRateId.equals(other.exchangeRateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bluestar.fms.entity.ExchangeRate[ exchangeRateId=" + exchangeRateId + " ]";
    }
    
}
