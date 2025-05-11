package app.system;

import app.products.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> cartItems;
    private int total;


    public Cart() {
        this.cartItems = new ArrayList<>();
        this.total =0;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getTotal() {
        return total;
    }

    public void addItem(Product product,int cantitate){
        CartItem cartItem =getCartItemByProductName(product.getName());
        if(cartItem!=null){
            cartItem.setCantitate(cartItem.getCantitate()+cantitate);
        }else{
            CartItem  newItem = new CartItem(product,cantitate);
            this.cartItems.add(newItem);
        }
    }


    public CartItem getCartItemByProductName(String name){
        for(CartItem cartItem:cartItems){
            if (cartItem.getProduct().getName().equals(name)){
                return cartItem;
            }
        }
        return null;
    }

    public void showCart(){
        int total=totalCart();
        for (CartItem cartItem:cartItems){
            System.out.println(cartItem.descriere());

        }
        System.out.println("Total:" + totalCart());
    }
    public int totalCart(){
        total=0;
        for(CartItem cartItem:cartItems){
            total+=cartItem.getProduct().getPrice()*cartItem.getCantitate();
        }

        return total;

    }
    public void deleteCartItemByName(String name){
        for (CartItem cartItem:cartItems){
            if (cartItem.getProduct().getName().equals(name)){
                cartItems.remove(cartItem);
            }
        }
    }
}
