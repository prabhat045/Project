package main.java.com.examly.springapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopppingcart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Transient
    private double totalprice;

    @Transient
    private int itemsNumber;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<CartItem> items = new HashSet<CartItem>();

    public ShoppingCart(){

    }

    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }

    private String sessionToken;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotalprice() {
        Double sum= 0.0;
        for(CartItem item : this.items)
        {
            sum= sum +item.getProduct().getPrice();
        }
        return sum;
    }

    public int getItemsNumber() {
        return this.items.size();
    }



    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
//	private BigDecimal GrandTotal;
//
//	@OneToMany(mappedBy = "shoppingCart",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//	@JsonIgnore
//	private List<CartItem> cartItemList;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	private User user;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public BigDecimal getGrandTotal() {
//		return GrandTotal;
//	}
//
//	public void setGrandTotal(BigDecimal grandTotal) {
//		GrandTotal = grandTotal;
//	}
//
//	public List<CartItem> getCartItemList() {
//		return cartItemList;
//	}
//
//	public void setCartItemList(List<CartItem> cartItemList) {
//		this.cartItemList = cartItemList;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}



