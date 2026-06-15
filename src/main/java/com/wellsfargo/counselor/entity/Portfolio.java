package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    private Long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    public Portfolio() {}

    public Portfolio(Client client, Date dateCreated, List<Security> securities) {
        this.client = client;
        this.dateCreated = dateCreated;
        this.securities = securities;
    }

    public Long getPortfolioId() { return portfolioId; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public Date getDateCreated() { return dateCreated; }
    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
